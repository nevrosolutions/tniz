package com.agent.service;

import java.util.List;

import com.agent.model.BusinessUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agent.model.HierarchyNode;
import com.agent.repository.HierarchyNodeRepository;
import com.agent.transformer.HierarchyNodeTransformer;

@Service
public class HierarchyNodeService {

    @Autowired
    private HierarchyNodeRepository hnr;

    @Autowired
    private HierarchyNodeTransformer hnt;

    public List<HierarchyNode> saveHierarchyNodeList(List<HierarchyNode> list) {
        return (List<HierarchyNode>) hnr.saveAll(list);
    }

    public boolean isHierarchyNodeExist(HierarchyNode hn) {
        return hnr.existsByBusinessUnitAndDesignationAndAgentGroupCategoryAndHierarchyType(
                hn.getBusinessUnit(), hn.getDesignation(), hn.getAgentGroupCategory(), hn.getHierarchyType());
    }

    public List<HierarchyNode> getHierarchyNodeByBusinessUnitAndHierarchyType(Integer businessUnitId,String hierarchyType) {
		return hnr.findByBusinessUnitBusinessUnitIdAndHierarchyType(businessUnitId,hierarchyType);
    }

    public List<HierarchyNode> getHierarchyNodeByBusinessUnitAndHierarchyType(Integer businessUnitId) {
        return hnr.findByBusinessUnitBusinessUnitId(businessUnitId);
    }
}
