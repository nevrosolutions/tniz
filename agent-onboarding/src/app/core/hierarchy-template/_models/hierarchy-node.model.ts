import { AgentCategory } from '../../manage-agent-category/_models/agent-category.model';
import { Designation } from '../../manage-designation/_models/designation.model';
import { BusinessUnit } from './business-unit.model';

export class HierarchyNode {
	hierarchyType: string;
	businessUnit: BusinessUnit;
	designation: Designation;
	agentGroupCategory: AgentCategory;
}
