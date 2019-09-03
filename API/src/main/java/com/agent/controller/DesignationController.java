package com.agent.controller;

import com.agent.model.Designation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.agent.service.DesignationService;

import java.util.List;

@RestController
@RequestMapping("designation")
@CrossOrigin
public class DesignationController {

    @Autowired
    DesignationService ds;

    @PostMapping("/save")
    public Designation saveDesignation(@RequestBody Designation designation) throws Exception {
        return ds.saveDesignation(designation);
    }

    @GetMapping("/all")
    public List<Designation> findAll() {
        return ds.findAll();
    }
}
