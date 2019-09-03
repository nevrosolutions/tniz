package com.agent.repository;

import com.agent.model.AgentGroupCategory;
import com.agent.model.BusinessUnit;
import com.agent.model.Designation;
import org.springframework.data.repository.CrudRepository;

import com.agent.model.HierarchyNode;

import java.util.List;

public interface HierarchyNodeRepository extends CrudRepository<HierarchyNode, Long> {

    public boolean existsByBusinessUnitAndDesignationAndAgentGroupCategoryAndHierarchyType(
            BusinessUnit businessUnitId, Designation designationId, AgentGroupCategory agentGroupCategory,
            String hierarchyType);


    public List<HierarchyNode> findByBusinessUnitBusinessUnitId(Integer businessUnitId);
    
    public HierarchyNode findFirstByBusinessUnitBusinessUnitIdAndDesignationDesignationIdAndHierarchyType(int businessUnitId,long designationId,String type);
    
    public List<HierarchyNode> findAllById(Iterable<Long> parentNodeIds);
    

    public List<HierarchyNode> findByBusinessUnitBusinessUnitIdAndHierarchyType(Integer businessUnitId,String hierarchyType);

}
