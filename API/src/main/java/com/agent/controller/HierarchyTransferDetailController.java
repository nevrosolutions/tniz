package com.agent.controller;

import com.agent.model.Agent;
import com.agent.model.HierarchyTransferDetail;
import com.agent.repository.AgentRepository;
import com.agent.service.AgentService;
import com.agent.service.HierarchyTransferDetailService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("hierarchyTransferDetail")
@CrossOrigin
public class HierarchyTransferDetailController {
    @Autowired
    private HierarchyTransferDetailService htds;
    
    @Autowired
    private AgentService as;

    @PostMapping("/update")
    public HierarchyTransferDetail updateHierarchyTransferDetail(@RequestBody HierarchyTransferDetail hierarchyTransferDetail){
        return htds.saveHierarchyTransferDetail(hierarchyTransferDetail);
    }
    
    @PostMapping("/create")
    public HierarchyTransferDetail saveHierarchyTransferDetail(@RequestBody HierarchyTransferDetail hierarchyTransferDetail){
    	System.out.println(hierarchyTransferDetail.toString());
    	as.saveAgent(hierarchyTransferDetail.getAgentSystemId());
    	return htds.saveHierarchyTransferDetail(hierarchyTransferDetail);
    }

    @PostMapping("/saveAll")
    public List<HierarchyTransferDetail> saveHierarchyTransferDetail(@RequestBody List<HierarchyTransferDetail> hierarchyTransferDetailList){
        return htds.saveHierarchyTransferDetailList(hierarchyTransferDetailList);
    }
    
    @GetMapping("/getAll")
    public Iterable<HierarchyTransferDetail> getHierarchyTransferDetailList(){
        return htds.getHierarchyTransferDetailList();
    }
    
    @GetMapping("/getHierarchyTransferDetail")
    public HierarchyTransferDetail getHierarchyTransferDetail(@RequestParam Long systemId){
    	return htds.getHierarchyTransferDetailListById(systemId);
    }
    
    @GetMapping("/findHierarchyTransferDetail")
    public List<HierarchyTransferDetail> findHierarchyTransferDetail(@RequestParam int agentId,@RequestParam int businessUnitId){
    	return htds.findHierarchyTransferDetail(agentId, businessUnitId);
    }
    
    @GetMapping("/getParent")
    public List<HierarchyTransferDetail> getParents(@RequestParam int businessUnitId,@RequestParam long designationId){
    	return htds.getParent(businessUnitId, designationId);
    }
    
}
