package com.agent.controller;

import java.util.List;

import com.agent.model.BusinessUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agent.dto.BusinessUnitDto;
import com.agent.service.BusinessUnitService;

@RestController
@RequestMapping("businessUnit")
@CrossOrigin
public class BusinessUnitController {

	@Autowired
	private BusinessUnitService bus;

	@GetMapping("/all")
	public List<BusinessUnit> getAllBusinessUnits() {
		return bus.getAllBusinessUnits();
	}
	
	@GetMapping("/active")
	public List<BusinessUnit> getActiveBusinessUnits() {
		return bus.getActiveBusinessUnits();
	}
}
