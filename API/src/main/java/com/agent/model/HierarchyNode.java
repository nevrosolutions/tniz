package com.agent.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "HIERARCHY_NODE_MASTER")
public class HierarchyNode implements Serializable {


	private static final long serialVersionUID = 1927684461006315067L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "HNodeId")
	private Long hierarchyNodeId;

	@Column(name = "HType")
	private String hierarchyType;

	@JoinColumn(name = "BUID",referencedColumnName = "BusinessChannelsId")
	@ManyToOne(targetEntity = BusinessUnit.class)
	private BusinessUnit businessUnit;

	@JoinColumn(name = "Designation_ID",referencedColumnName = "DesignationId")
	@ManyToOne(targetEntity = Designation.class)
	private Designation designation;

	@JoinColumn(name = "category",referencedColumnName = "AgCatId")
	@ManyToOne(targetEntity = AgentGroupCategory.class)
	private AgentGroupCategory agentGroupCategory;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getHierarchyNodeId() {
		return hierarchyNodeId;
	}


	public void setHierarchyNodeId(Long hierarchyNode) {
		this.hierarchyNodeId = hierarchyNode;
	}

	public BusinessUnit getBusinessUnitId() {
		return businessUnit;
	}
	public int getBusinessUnitIdFromObject() {
		return businessUnit.getBusinessUnitId();
	}

	public void setBusinessUnitId(BusinessUnit businessUnit) {
		this.businessUnit = businessUnit;
	}
	
	public String getHierarchyType() {
		return hierarchyType;
	}

	public void setHierarchyType(String hierarchyType) {
		this.hierarchyType = hierarchyType;
	}

	public BusinessUnit getBusinessUnit() {
		return businessUnit;
	}

	public void setBusinessUnit(BusinessUnit businessUnit) {
		this.businessUnit = businessUnit;
	}

	public Designation getDesignation() {
		return designation;
	}
	public long getDesignationIdFromObject() {
		return designation.getDesignationId();
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	public AgentGroupCategory getAgentGroupCategory() {
		return agentGroupCategory;
	}

	public void setAgentGroupCategory(AgentGroupCategory agentGroupCategory) {
		this.agentGroupCategory = agentGroupCategory;
	}

}
