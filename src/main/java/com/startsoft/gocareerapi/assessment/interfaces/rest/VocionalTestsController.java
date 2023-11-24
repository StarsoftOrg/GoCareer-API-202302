package com.startsoft.gocareerapi.assessment.interfaces.rest;

import com.startsoft.gocareerapi.assessment.domain.model.queries.GetAllVocacionalTestsQuery;
import com.startsoft.gocareerapi.assessment.domain.model.queries.GetVocacionalTestByIdQuery;
import com.startsoft.gocareerapi.assessment.domain.services.VocacionalTestCommandService;
import com.startsoft.gocareerapi.assessment.domain.services.VocacionalTestQueryService;
import com.startsoft.gocareerapi.assessment.interfaces.rest.resources.CreateVocacionalTestResource;
import com.startsoft.gocareerapi.assessment.interfaces.rest.resources.VocacionalTestResource;
import com.startsoft.gocareerapi.assessment.interfaces.rest.transform.CreateVocacionalTestCommandFromResourceAssembler;
import com.startsoft.gocareerapi.assessment.interfaces.rest.transform.VocacionalTestResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/vacacionaltests",produces = APPLICATION_JSON_VALUE)
@Tag(name = "Vocacional Tests", description = "Vocacional Tests Management Endpoints")
public class VocionalTestsController {

    private final VocacionalTestCommandService vocacionalTestCommandService;
    private final VocacionalTestQueryService vocacionalTestQueryService;

    public VocionalTestsController(VocacionalTestCommandService vocacionalTestCommandService, VocacionalTestQueryService vocacionalTestQueryService) {
        this.vocacionalTestCommandService = vocacionalTestCommandService;
        this.vocacionalTestQueryService = vocacionalTestQueryService;
    }

    @PostMapping
    public ResponseEntity<VocacionalTestResource> createVocacionalTest(@RequestBody CreateVocacionalTestResource createVocacionalTestResource) {
        var createVocacionalTestCommand = CreateVocacionalTestCommandFromResourceAssembler.toCommandFromResource(createVocacionalTestResource);
        var vocacionalTestId = vocacionalTestCommandService.handle(createVocacionalTestCommand);
        if (vocacionalTestId == 0L) return ResponseEntity.badRequest().build();

        var getVocacionalTestbyIdQuery = new GetVocacionalTestByIdQuery(vocacionalTestId);
        var vocacionalTest = vocacionalTestQueryService.handle(getVocacionalTestbyIdQuery);
        if (vocacionalTest.isEmpty()) return ResponseEntity.notFound().build();

        var vocacionalTestResource = VocacionalTestResourceFromEntityAssembler.toResourceFromEntity(vocacionalTest.get());

        return new ResponseEntity<>(vocacionalTestResource, HttpStatus.CREATED);
    }


    @GetMapping()
    public ResponseEntity<List<VocacionalTestResource>> getAllVocacionalTests() {
        var getAllVocacionalTestsQuery = new GetAllVocacionalTestsQuery();
        var vocacionalTests = vocacionalTestQueryService.handle(getAllVocacionalTestsQuery);
        var vocacionalTestResources = vocacionalTests.stream()
                .map(VocacionalTestResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(vocacionalTestResources);
    }


    @GetMapping("/{vocacionalTestId}")
    public ResponseEntity<VocacionalTestResource> getVocacionalTestById(@PathVariable Long vocacionalTestId){
        var getVocacionalTestByIdQuery = new GetVocacionalTestByIdQuery(vocacionalTestId);
        var vocacionalTest = vocacionalTestQueryService.handle(getVocacionalTestByIdQuery);

        if (vocacionalTest.isEmpty()) return ResponseEntity.notFound().build();

        var vocacionalTestResource = VocacionalTestResourceFromEntityAssembler.toResourceFromEntity(vocacionalTest.get());

        return ResponseEntity.ok(vocacionalTestResource);
    }



}
