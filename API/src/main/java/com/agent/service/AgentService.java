package com.agent.service;

import com.agent.model.Agent;
import com.agent.model.Designation;
import com.agent.model.HierarchyNode;
import com.agent.model.HierarchyNodeDetail;
import com.agent.repository.AgentRepository;
import com.agent.repository.DesignationRepository;
import com.agent.repository.HierarchyNodeDetailRepository;
import com.agent.repository.HierarchyNodeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class AgentService {

	@Autowired
	private AgentRepository ar;

	@Autowired
	private HierarchyNodeRepository hnr;

	@Autowired
	private HierarchyNodeDetailRepository hndr;

	public List<Agent> getAllAgent() {
		return (List<Agent>) ar.findAll();
	}
	
	public Agent saveAgent(Agent agent){
		return ar.save(agent);
	}

	
}
