package com.agent.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agent.model.Agent;
import com.agent.model.Designation;
import com.agent.model.HierarchyNode;
import com.agent.model.HierarchyNodeDetail;
import com.agent.model.HierarchyTransferDetail;
import com.agent.repository.DesignationRepository;
import com.agent.repository.HierarchyNodeDetailRepository;
import com.agent.repository.HierarchyNodeRepository;
import com.agent.repository.HierarchyTransferDetailRepository;

@Service
public class HierarchyTransferDetailService {
    @Autowired
    private HierarchyTransferDetailRepository htdr;
    
    @Autowired
	private HierarchyNodeRepository hnr;

	@Autowired
	private HierarchyNodeDetailRepository hndr;
    
    public HierarchyTransferDetail saveHierarchyTransferDetail(HierarchyTransferDetail hierarchyTransferDetail) {
        return htdr.save(hierarchyTransferDetail);
    }

    public List<HierarchyTransferDetail> saveHierarchyTransferDetailList(List<HierarchyTransferDetail> hierarchyTransferDetailList) {
        return (List<HierarchyTransferDetail>) htdr.saveAll(hierarchyTransferDetailList);
    }
    
    public Iterable<HierarchyTransferDetail> getHierarchyTransferDetailList(){
    	return htdr.findAll();
    }
    
    public HierarchyTransferDetail getHierarchyTransferDetailListById(long systemId){
    	return htdr.findById(systemId).get();
    }
    
    public List<HierarchyTransferDetail> findHierarchyTransferDetail(int agentId,int businessUnitId){
	    return htdr.findHierarchyTransferDetailByAgentSystemIdAgentIdAndBusinessUnitBusinessUnitId(agentId, businessUnitId);
    }
    
    public List<HierarchyTransferDetail> getParent(int businessUnitId,long designationId){

		HierarchyNode hierarchyNode =
				hnr.findFirstByBusinessUnitBusinessUnitIdAndDesignationDesignationIdAndHierarchyType(businessUnitId, designationId,"P");
		List<HierarchyNodeDetail> hierarchyNodeDetailList = 
				hndr.findAllByhierarchyNodeIdHierarchyNodeId(hierarchyNode.getHierarchyNodeId());
		Iterable<Long> parentNodeIds = hierarchyNodeDetailList.parallelStream().map(HierarchyNodeDetail::getParentNodeIdFromObject).
				collect(Collectors.toList());
		List<HierarchyNode> parentNodeDetailList =hnr.findAllById(parentNodeIds).stream().collect(Collectors.toList());
		Iterable<Long> parentDesignationIds = parentNodeDetailList.parallelStream().map(HierarchyNode::getDesignationIdFromObject).
				map(row->row.longValue()).collect(Collectors.toList());
		List<HierarchyTransferDetail> parents = htdr.
				findAllHierarchyTransferDetailBydesignationTypeDesignationIdInAndBusinessUnitBusinessUnitIdAndEffectiveToIsNull(
						parentDesignationIds,businessUnitId);
		return parents;
	}

    
    
}
