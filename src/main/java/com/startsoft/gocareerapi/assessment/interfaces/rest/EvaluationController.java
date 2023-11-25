package com.startsoft.gocareerapi.assessment.interfaces.rest;

import com.startsoft.gocareerapi.assessment.domain.model.queries.GetAllEvaluationsQuery;
import com.startsoft.gocareerapi.assessment.domain.model.queries.GetEvaluationByIdQuery;
import com.startsoft.gocareerapi.assessment.domain.services.EvaluationCommandService;
import com.startsoft.gocareerapi.assessment.domain.services.EvaluationQueryService;
import com.startsoft.gocareerapi.assessment.interfaces.rest.resources.CreateEvaluationResource;
import com.startsoft.gocareerapi.assessment.interfaces.rest.resources.EvaluationResource;
import com.startsoft.gocareerapi.assessment.interfaces.rest.transform.CreateEvaluationtCommandFromResourceAssembler;
import com.startsoft.gocareerapi.assessment.interfaces.rest.transform.EvaluationResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/evaluations",produces = APPLICATION_JSON_VALUE)
@Tag(name = "Evaluations", description = "Evaluations Management Endpoints")
public class EvaluationController {

    private final EvaluationCommandService evaluationCommandService;
    private final EvaluationQueryService evaluationQueryService;

    public EvaluationController(EvaluationCommandService evaluationCommandService, EvaluationQueryService evaluationQueryService) {
        this.evaluationCommandService = evaluationCommandService;
        this.evaluationQueryService = evaluationQueryService;
    }

    @PostMapping
    public ResponseEntity<EvaluationResource> createevaluation(@RequestBody CreateEvaluationResource createEvaluationResource) {
        var createEvaluationCommand = CreateEvaluationtCommandFromResourceAssembler.toCommandFromResource(createEvaluationResource);
        var evaluationId = evaluationCommandService.handle(createEvaluationCommand);
        if (evaluationId == 0L) return ResponseEntity.badRequest().build();

        var getEvaluationQuery = new GetEvaluationByIdQuery(evaluationId);
        var evaluation = evaluationQueryService.handle(getEvaluationQuery);
        if (evaluation.isEmpty()) return ResponseEntity.notFound().build();

        var evaluationResource = EvaluationResourceFromEntityAssembler.toResourceFromEntity(evaluation.get());

        return new ResponseEntity<>(evaluationResource, HttpStatus.CREATED);
    }


    @CrossOrigin(origins = "http://localhost:4200",allowCredentials = "false",allowedHeaders = "*",exposedHeaders = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE,RequestMethod.OPTIONS,RequestMethod.HEAD,RequestMethod.TRACE},maxAge = 3600)
    @GetMapping()
    public ResponseEntity<List<EvaluationResource>> getAllevaluations() {
        var getAllEvaluationsQuery = new GetAllEvaluationsQuery();
        var evaluations = evaluationQueryService.handle(getAllEvaluationsQuery);
        var evaluationResources = evaluations.stream()
                .map(EvaluationResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(evaluationResources);
    }


    @GetMapping("/{evaluationId}")
    public ResponseEntity<EvaluationResource> getevaluationById(@PathVariable Long evaluationId){
        var getEvaluationByIdQuery = new GetEvaluationByIdQuery(evaluationId);
        var evaluation = evaluationQueryService.handle(getEvaluationByIdQuery);

        if (evaluation.isEmpty()) return ResponseEntity.notFound().build();

        var evaluationResource = EvaluationResourceFromEntityAssembler.toResourceFromEntity(evaluation.get());

        return ResponseEntity.ok(evaluationResource);
    }



}
