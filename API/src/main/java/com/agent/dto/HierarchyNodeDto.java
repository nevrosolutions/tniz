package com.agent.dto;

import com.agent.model.AgentGroupCategory;
import com.agent.model.BusinessUnit;
import com.agent.model.Designation;

public class HierarchyNodeDto {
	
	private Long hierarchyNodeId;
	
	private BusinessUnit businessUnitId;
	
	private String hierarchyType;
	
	private Designation designationId;
	
	private AgentGroupCategory  agentGroupCategory;
	//
	//

	public Long getHierarchyNodeId() {
		return hierarchyNodeId;
	}

	public void setHierarchyNodeId(Long hierarchyNodeId) {
		this.hierarchyNodeId = hierarchyNodeId;
	}

	public BusinessUnit getBusinessUnitId() {
		return businessUnitId;
	}

	public void setBusinessUnitId(BusinessUnit businessUnitId) {
		this.businessUnitId = businessUnitId;
	}

	public String getHierarchyType() {
		return hierarchyType;
	}

	public void setHierarchyType(String hierarchyType) {
		this.hierarchyType = hierarchyType;
	}

	public Designation getDesignationId() {
		return designationId;
	}

	public void setDesignationId(Designation designationId) {
		this.designationId = designationId;
	}

	public AgentGroupCategory getAgentGroupCategory() {
		return agentGroupCategory;
	}

	public void setAgentGroupCategory(AgentGroupCategory agentGroupCategory) {
		this.agentGroupCategory = agentGroupCategory;
	}
	
	
	
}
