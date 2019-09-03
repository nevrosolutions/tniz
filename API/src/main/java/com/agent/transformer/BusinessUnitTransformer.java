package com.agent.transformer;

import org.springframework.stereotype.Component;

import com.agent.dto.BusinessUnitDto;
import com.agent.model.BusinessUnit;

@Component
public class BusinessUnitTransformer {
	public BusinessUnit transform(BusinessUnitDto dto) {

		BusinessUnit businessUnit = new BusinessUnit();
		businessUnit.setBusinessUnitId(dto.getBusinessUnitId());
		businessUnit.setBusinessChannelName(dto.getBusinessChannelName());
		businessUnit.setBusinessChannelStatus(dto.getBusinessChannelStatus());
		return businessUnit;

	}

	public BusinessUnitDto transform(BusinessUnit entity) {

		BusinessUnitDto businessUnitDto = new BusinessUnitDto();
		businessUnitDto.setBusinessUnitId(entity.getBusinessUnitId());
		businessUnitDto.setBusinessChannelName(entity.getBusinessChannelName());
		businessUnitDto.setBusinessChannelStatus(entity.getBusinessChannelStatus());
		return businessUnitDto;
	}
}
