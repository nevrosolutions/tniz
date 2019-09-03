package com.agent.transformer;

import org.springframework.stereotype.Component;

import com.agent.dto.DesignationDto;
import com.agent.model.Designation;

@Component
public class DesignationTransformer {
	public Designation transform(DesignationDto dto) {

		Designation designation = new Designation();
		designation.setDesignationId(dto.getDesignationId());
		designation.setCode(dto.getCode());
		designation.setLabel(dto.getLabel());
		designation.setStatus(dto.getStatus());
		return designation;

	}

	public DesignationDto transform(Designation entity) {

		DesignationDto designationDto = new DesignationDto();
		designationDto.setDesignationId(entity.getDesignationId());
		designationDto.setCode(entity.getCode());
		designationDto.setLabel(entity.getLabel());
		designationDto.setStatus(entity.getStatus());
		return designationDto;
	}
}
