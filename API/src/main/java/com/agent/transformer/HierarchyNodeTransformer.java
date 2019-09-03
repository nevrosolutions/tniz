package com.agent.transformer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.agent.dto.HierarchyNodeDto;
import com.agent.model.HierarchyNode;

@Component
public class HierarchyNodeTransformer {
	public HierarchyNode transform(HierarchyNodeDto dto) {

		HierarchyNode hierarchyNode = new HierarchyNode();
		hierarchyNode.setHierarchyNodeId(dto.getHierarchyNodeId());
		hierarchyNode.setHierarchyType(dto.getHierarchyType());
		hierarchyNode.setDesignation(dto.getDesignationId());
		hierarchyNode.setBusinessUnit(dto.getBusinessUnitId());
		hierarchyNode.setAgentGroupCategory(dto.getAgentGroupCategory());
		
		return hierarchyNode;
	}

	public HierarchyNodeDto transform(HierarchyNode entity) {

		HierarchyNodeDto hierarchyNodeDto = new HierarchyNodeDto();
		hierarchyNodeDto.setHierarchyNodeId(entity.getHierarchyNodeId());
		hierarchyNodeDto.setHierarchyType(entity.getHierarchyType());
		hierarchyNodeDto.setDesignationId(entity.getDesignation());
		hierarchyNodeDto.setBusinessUnitId(entity.getBusinessUnit());
		hierarchyNodeDto.setAgentGroupCategory(entity.getAgentGroupCategory());
		
		return hierarchyNodeDto;
	}

	public List<HierarchyNode> transformDtoList(List<HierarchyNodeDto> list) {
		List<HierarchyNode>  convertedList = new ArrayList<HierarchyNode>();
		list.forEach(hnd->{
			convertedList.add(this.transform(hnd));
		});
		return convertedList;
	}

	public List<HierarchyNodeDto> transformEntityList(List<HierarchyNode> list) {
		List<HierarchyNodeDto>  convertedList = new ArrayList<HierarchyNodeDto>();
		list.forEach(hnd->{
			convertedList.add(this.transform(hnd));
		});
		return convertedList;
	}
}
