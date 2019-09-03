package com.agent.transformer;

import org.springframework.stereotype.Component;

import com.agent.dto.AgentGroupCategoryDto;
import com.agent.model.AgentGroupCategory;

@Component
public class AgentGroupCategoryTransformer {

	public AgentGroupCategory transform(AgentGroupCategoryDto dto) {

		AgentGroupCategory agc = new AgentGroupCategory();
		agc.setAgentId(dto.getAgentId());
		agc.setCode(dto.getCode());
		agc.setHierarchyWithingCategory(dto.isHierarchyWithingCategory());
		agc.setLabel(dto.getLabel());

		return agc;

	}

	public AgentGroupCategoryDto transform(AgentGroupCategory entity) {

		AgentGroupCategoryDto agcDto = new AgentGroupCategoryDto();
		agcDto.setAgentId(entity.getAgentId());
		agcDto.setCode(entity.getCode());
		agcDto.setHierarchyWithingCategory(entity.isHierarchyWithingCategory());
		agcDto.setLabel(entity.getLabel());

		return agcDto;

	}
}
