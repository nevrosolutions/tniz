package com.agent.repository;

import org.springframework.data.repository.CrudRepository;

import com.agent.model.AgentGroupCategory;

public interface AgentGroupCategoryRepository extends CrudRepository<AgentGroupCategory, Long> {
	public AgentGroupCategory findByCodeAndLabel(String code, String label);
}
