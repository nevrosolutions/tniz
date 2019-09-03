package com.agent.service;

import com.agent.model.Designation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agent.repository.DesignationRepository;
import com.agent.transformer.DesignationTransformer;

import java.util.List;

@Service
public class DesignationService {

    @Autowired
    DesignationRepository dr;

    @Autowired
    DesignationTransformer dt;

    public Designation saveDesignation(Designation designation) throws Exception {
        if (dr.findByCodeAndLabel(designation.getCode(), designation.getLabel()) == null) {
            return dr.save(designation);

        } else {
            throw new Exception("Duplicate Designation Entry...!");
        }
    }

    public List<Designation> findAll() {
        return (List<Designation>) dr.findAll();
    }
}
