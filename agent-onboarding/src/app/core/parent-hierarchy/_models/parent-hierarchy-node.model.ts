import { BusinessUnit } from '../../hierarchy-template/_models/business-unit.model';
import { AgentCategory } from '../../manage-agent-category/_models/agent-category.model';
import { Designation } from '../../manage-designation/_models/designation.model';

export class ParentHierarchyNodeModel {
	hierarchyNodeId: number;
	hierarchyType: string;
	agentGroupCategory: AgentCategory;
	designationId: Designation;
	businessUnitId: BusinessUnit;
}

export class ParentHierarchySaveNodeModel {
	hierarchyNodeDetailId: number;
	hierarchyNodeId: {
		hierarchyNodeId: number;
	};
	parentNodeId: {
		hierarchyNodeId: number;
	};
	status: string;
	effectiveFrom: string;
	effectiveTo: string;
}
