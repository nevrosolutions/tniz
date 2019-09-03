package com.agent.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.agent.model.Agent;

public interface AgentRepository extends CrudRepository<Agent,Long> {
	
	public List<Agent> findAllByDesignation(String designation);
	public List<Agent> findAllyByDesignationIn(Iterable<String> designations);
	
}
