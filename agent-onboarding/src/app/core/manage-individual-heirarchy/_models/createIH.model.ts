import { Agent } from './agent.model';
import { BussinesUnit } from './bussinesUnit.model';
import { Designation } from './designation.model';

export class CreateIH {
    agentSystemId: Agent;
    parentSystemId: Agent;
    designationType: Designation;
    businessUnit: BussinesUnit;
    branchcode: string;
    effectiveFrom: string;
    effectiveTo: string;

    clear() {
        this.agentSystemId = new Agent();
        this.parentSystemId = new Agent();
        this.designationType = new Designation();
        this.businessUnit = new BussinesUnit();
        this.branchcode = '';
        this.effectiveFrom = '';
        this.effectiveTo = '';
    }
}