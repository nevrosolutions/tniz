package com.agent.dto;

public class AgentGroupCategoryDto {

	private long agentId;
	private String code;
	private boolean hierarchyWithingCategory;
	private String label;
	//
	//
	public long getAgentId() {
		return agentId;
	}
	public void setAgentId(long agentId) {
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
	
	

}
