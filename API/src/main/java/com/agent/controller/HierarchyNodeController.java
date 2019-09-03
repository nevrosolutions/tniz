package com.agent.controller;

import java.util.List;

import com.agent.model.BusinessUnit;
import com.agent.model.HierarchyNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;


import com.agent.service.HierarchyNodeService;

@RestController
@RequestMapping("hierarchyNode")
@CrossOrigin
public class HierarchyNodeController {

    @Autowired
    private HierarchyNodeService hns;

    @PostMapping("/save")
    public List<HierarchyNode> saveHierarchyNodeList(@RequestBody List<HierarchyNode> list) {
      return hns.saveHierarchyNodeList(list);
    }

    @PostMapping("/isExist")
    public boolean isHierarchyNodeExist(@RequestBody HierarchyNode hn) {
        return hns.isHierarchyNodeExist(hn);
    }

    @GetMapping("/findByBusinessUnitAndHierarchyType")
    public List<HierarchyNode> getHierarchyNodeByBusinessUnit(@RequestParam(value = "businessUnitId") Integer businessUnitId,@RequestParam(value = "hierarchyType") String hierarchyType) {
        return hns.getHierarchyNodeByBusinessUnitAndHierarchyType(businessUnitId,hierarchyType);
    }
    @GetMapping("/findByBusinessUnit")
    public List<HierarchyNode> getHierarchyNodeByBusinessUnit(@RequestParam(value = "businessUnitId") Integer businessUnitId) {
        return hns.getHierarchyNodeByBusinessUnitAndHierarchyType(businessUnitId);
    }

}
