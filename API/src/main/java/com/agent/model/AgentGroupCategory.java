package com.agent.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "AGENT_CATEGORY_DETAIL")
public class AgentGroupCategory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1340269340709880350L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AgCatId")
	private Long agentId;
	
	@Column(name = "CategoryCode")
	private String code;

	@Column(name = "Label")
	private String label;

	@Column(name = "HierarchyWithingCategory")
	private boolean hierarchyWithingCategory;
	



	public Long getAgentId() {
		return agentId;
	}

	public void setAgentId(Long agentId) {
		this.agentId = agentId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isHierarchyWithingCategory() {
		return hierarchyWithingCategory;
	}

	public void setHierarchyWithingCategory(boolean hierarchyWithingCategory) {
		this.hierarchyWithingCategory = hierarchyWithingCategory;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AgentGroupCategory that = (AgentGroupCategory) o;
		return Objects.equals(agentId, that.agentId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(agentId);
	}
}
