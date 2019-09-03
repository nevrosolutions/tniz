package com.agent.controller;

import com.agent.model.HierarchyNodeDetail;
import com.agent.service.HierarchyNodeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.List;

@RestController
@RequestMapping("hierarchyNodeDetail")
@CrossOrigin
public class HierarchyNodeDetailController {
    @Autowired
    private HierarchyNodeDetailService hnds;

    @PostMapping("/save")
    public HierarchyNodeDetail saveHierarchyNodeDetail(@RequestBody HierarchyNodeDetail hierarchyNodeDetail) {
        return hnds.saveHierarchyNodeDetail(hierarchyNodeDetail);
    }

    @PostMapping("/saveAll")
    public List<HierarchyNodeDetail> saveHierarchyNodeDetail(@RequestBody List<HierarchyNodeDetail> hierarchyNodeDetailList) {
        return hnds.saveHierarchyNodeDetailList(hierarchyNodeDetailList);
    }

    @GetMapping("/findByBusinessUnit")
    public List<HierarchyNodeDetail> findHierarchyNodeDetailByBusinessUnitId(@RequestParam(value = "businessUnitId") Integer businessUnitId){
        return hnds.findHierarchyNodeDetailByBusinessUnitId(businessUnitId);
    }
    @GetMapping("/findByBusinessUnitIdAndDesignationId")

    public List<HierarchyNodeDetail> findHierarchyNodeDetailByBusinessUnitIdAndDesignationId(@RequestParam(value = "businessUnitId") Integer businessUnitId,@RequestParam(value = "designationId") Long designationId){
        System.out.print("Called");
        return hnds.findHierarchyNodeDetailByBusinessUnitIdAndDesignationId(businessUnitId,designationId);
    }
}
