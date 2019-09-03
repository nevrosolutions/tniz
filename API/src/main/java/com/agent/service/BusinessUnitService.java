package com.agent.service;

import java.util.ArrayList;
import java.util.List;

import com.agent.model.BusinessUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agent.dto.BusinessUnitDto;
import com.agent.repository.BusinessUnitRepository;
import com.agent.transformer.BusinessUnitTransformer;

@Service
public class BusinessUnitService {

	@Autowired
	private BusinessUnitRepository bur;

	@Autowired
	private BusinessUnitTransformer but;

	public List<BusinessUnit> getAllBusinessUnits() {
		List<BusinessUnit> list = new ArrayList<BusinessUnit>();

		return (List<BusinessUnit>) bur.findAll();
	}

	public List<BusinessUnit> getActiveBusinessUnits() {
		return bur.findAllByBusinessChannelStatus("ACT");
	}

}
