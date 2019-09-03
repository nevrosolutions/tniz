package com.agent.repository;

import com.agent.model.HierarchyNodeDetail;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HierarchyNodeDetailRepository extends CrudRepository<HierarchyNodeDetail, Long> {

    public List<HierarchyNodeDetail> findByHierarchyNodeIdBusinessUnitBusinessUnitId(Integer businessUnitId);
    
    public List<HierarchyNodeDetail> findAllByhierarchyNodeIdHierarchyNodeId(long hierarchyNodeId);

    public List<HierarchyNodeDetail> findByHierarchyNodeIdBusinessUnitBusinessUnitIdAndHierarchyNodeIdDesignationDesignationId(Integer businessUnitId, Long designationId);
}
