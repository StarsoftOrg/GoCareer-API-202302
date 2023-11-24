package com.startsoft.gocareerapi.assessment.interfaces.rest;

import com.startsoft.gocareerapi.assessment.domain.model.aggregates.VocacionalTest;
import com.startsoft.gocareerapi.assessment.domain.services.VocacionalTestCommandService;
import com.startsoft.gocareerapi.assessment.interfaces.rest.resources.CreateVocacionalTestResource;
import com.startsoft.gocareerapi.assessment.interfaces.rest.transform.CreateVocacionalTestCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/vacacionaltests",produces = APPLICATION_JSON_VALUE)
@Tag(name = "Vocacional Tests", description = "Vocacional Tests Management Endpoints")
public class VocionalTestsController {

    private VocacionalTestCommandService vocacionalTestCommandService;

    public VocionalTestsController(VocacionalTestCommandService vocacionalTestCommandService) {
        this.vocacionalTestCommandService = vocacionalTestCommandService;
    }

    @PostMapping
    public ResponseEntity<VocacionalTest> createMeeting(@RequestBody CreateVocacionalTestResource createVocacionalTestResource) {
        var createVocacionalTestCommand = CreateVocacionalTestCommandFromResourceAssembler.toCommandFromResource(createVocacionalTestResource);
        var vocacionalTestId = vocacionalTestCommandService.handle(createVocacionalTestCommand);
        if (vocacionalTestId == 0L) return ResponseEntity.badRequest().build();



        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
