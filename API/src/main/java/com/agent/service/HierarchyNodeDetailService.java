package com.agent.service;

import com.agent.model.HierarchyNodeDetail;
import com.agent.repository.HierarchyNodeDetailRepository;
import com.agent.repository.HierarchyNodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HierarchyNodeDetailService {
    @Autowired
    HierarchyNodeDetailRepository hndr;

    public HierarchyNodeDetail saveHierarchyNodeDetail(HierarchyNodeDetail hierarchyNodeDetail) {
        return hndr.save(hierarchyNodeDetail);
    }

    public List<HierarchyNodeDetail> saveHierarchyNodeDetailList(List<HierarchyNodeDetail> hierarchyNodeDetailList) {
        return (List<HierarchyNodeDetail>) hndr.saveAll(hierarchyNodeDetailList);
    }

    public List<HierarchyNodeDetail> findHierarchyNodeDetailByBusinessUnitId(Integer businessUnitId) {
        return hndr.findByHierarchyNodeIdBusinessUnitBusinessUnitId(businessUnitId);
    }

    public List<HierarchyNodeDetail> findHierarchyNodeDetailByBusinessUnitIdAndDesignationId(Integer businessUnitId, Long designationId) {
        return hndr.findByHierarchyNodeIdBusinessUnitBusinessUnitIdAndHierarchyNodeIdDesignationDesignationId(businessUnitId,designationId);
    }
}
