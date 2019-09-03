package com.agent.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.agent.model.Designation;

public interface DesignationRepository extends CrudRepository<Designation, Long> {
	public Designation findByCodeAndLabel(String code, String label);
	public Designation getDesignationByLabel(String  designation);
	public List<Designation> getDesignationByDesignationIdGreaterThan(long designationId);
}
