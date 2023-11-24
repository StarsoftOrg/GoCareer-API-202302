package com.startsoft.gocareerapi.assessment.domain.services;

import com.startsoft.gocareerapi.assessment.domain.model.aggregates.VocacionalTest;
import com.startsoft.gocareerapi.assessment.domain.model.queries.GetAllVocacionalTestsQuery;
import com.startsoft.gocareerapi.assessment.domain.model.queries.GetVocacionalTestByIdQuery;

import java.util.List;
import java.util.Optional;

public interface VocacionalTestQueryService {
    Optional<VocacionalTest> handle(GetVocacionalTestByIdQuery query);

    List<VocacionalTest> handle(GetAllVocacionalTestsQuery query);
}
