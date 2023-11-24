package com.startsoft.gocareerapi.assessment.interfaces.rest.transform;

import com.startsoft.gocareerapi.assessment.domain.model.aggregates.VocacionalTest;
import com.startsoft.gocareerapi.assessment.interfaces.rest.resources.VocacionalTestResource;

public class VocacionalTestFromEntityAssembler {
    public static VocacionalTestResource toResourceFromEntity(VocacionalTest vocacionalTest) {
        return new VocacionalTestResource(
                vocacionalTest.getId(),
                vocacionalTest.getTitle(),
                vocacionalTest.getDescription(),
                vocacionalTest.getNumberQuestions());
    }
}
