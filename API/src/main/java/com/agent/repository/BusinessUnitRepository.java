package com.agent.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.agent.model.BusinessUnit;

public interface BusinessUnitRepository extends CrudRepository<BusinessUnit, Long> {

	List<BusinessUnit> findAllByBusinessChannelStatus(String string);

}
