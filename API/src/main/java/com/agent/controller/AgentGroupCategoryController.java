package com.agent.controller;

import com.agent.model.AgentGroupCategory;
import com.agent.model.Designation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.agent.dto.AgentGroupCategoryDto;
import com.agent.service.AgentGroupCategoryService;

import java.util.List;

@RestController
@RequestMapping("agentGroupCategory")
@CrossOrigin
public class AgentGroupCategoryController {

    @Autowired
    private AgentGroupCategoryService agcs;

    @PostMapping("/save")
    public AgentGroupCategoryDto saveAgentGroupCategory(@RequestBody AgentGroupCategoryDto agentGroupCategoryDto) throws Exception {
        return agcs.saveAgentGroupCategory(agentGroupCategoryDto);
    }

    @GetMapping("/all")
    public List<AgentGroupCategory> findAll() {
        return agcs.findAll();
    }
}
