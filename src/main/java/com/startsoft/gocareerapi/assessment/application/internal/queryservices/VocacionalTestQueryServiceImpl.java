package com.startsoft.gocareerapi.assessment.application.internal.queryservices;

import com.startsoft.gocareerapi.assessment.domain.model.aggregates.VocacionalTest;
import com.startsoft.gocareerapi.assessment.domain.model.queries.GetAllVocacionalTestsQuery;
import com.startsoft.gocareerapi.assessment.domain.model.queries.GetVocacionalTestByIdQuery;
import com.startsoft.gocareerapi.assessment.domain.services.VocacionalTestQueryService;
import com.startsoft.gocareerapi.assessment.infrastructure.persistance.jpa.repositories.VocacionalTestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VocacionalTestQueryServiceImpl implements VocacionalTestQueryService {

    private final VocacionalTestRepository vocacionalTestRepository;

    public VocacionalTestQueryServiceImpl(VocacionalTestRepository vocacionalTestRepository) {
        this.vocacionalTestRepository = vocacionalTestRepository;
    }

    @Override
    public Optional<VocacionalTest> handle(GetVocacionalTestByIdQuery query) {
        return vocacionalTestRepository.findById(query.id());
    }

    @Override
    public List<VocacionalTest> handle(GetAllVocacionalTestsQuery query) {
        return vocacionalTestRepository.findAll();
    }
}
