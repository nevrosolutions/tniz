package com.agent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.agent.model.HierarchyTransferDetail;

public interface HierarchyTransferDetailRepository extends CrudRepository<HierarchyTransferDetail,Long> {
	
	public List<HierarchyTransferDetail> findHierarchyTransferDetailByAgentSystemIdAgentIdAndBusinessUnitBusinessUnitId( int agentId,
			 int businessId);
	public List<HierarchyTransferDetail> 
	findAllHierarchyTransferDetailBydesignationTypeDesignationIdInAndBusinessUnitBusinessUnitIdAndEffectiveToIsNull(
			Iterable<Long> designations,int businessUnitId);

}