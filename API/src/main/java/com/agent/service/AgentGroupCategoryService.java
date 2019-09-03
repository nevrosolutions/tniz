package com.agent.service;

import com.agent.model.AgentGroupCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agent.dto.AgentGroupCategoryDto;
import com.agent.repository.AgentGroupCategoryRepository;
import com.agent.transformer.AgentGroupCategoryTransformer;

import java.util.List;

@Service
public class AgentGroupCategoryService {

    @Autowired
    private AgentGroupCategoryTransformer agcTransformer;

    @Autowired
    private AgentGroupCategoryRepository agcrepo;

    public AgentGroupCategoryDto saveAgentGroupCategory(AgentGroupCategoryDto agentGroupCategoryDto) throws Exception {

        if (agcrepo.findByCodeAndLabel(agentGroupCategoryDto.getCode(), agentGroupCategoryDto.getLabel()) == null) {
            return agcTransformer.transform(agcrepo.save(agcTransformer.transform(agentGroupCategoryDto)));
        } else {
            throw new Exception("Duplicate AgentGroupCategory...!");
        }


    }


    public List<AgentGroupCategory> findAll() {
        return (List<AgentGroupCategory>) agcrepo.findAll();
    }
}
