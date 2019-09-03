package com.agent.controller;

import com.agent.model.Agent;
import com.agent.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("agent")
@CrossOrigin
public class AgentController {
    @Autowired
    AgentService as;
    @GetMapping("/all")
    public List<Agent> getAllAgent() {
        return as.getAllAgent();

    }
    
    
}
