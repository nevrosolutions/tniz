package com.agent.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "hierarchy_tranfer_detail")
public class HierarchyTransferDetail implements Serializable {

    private static final long serialVersionUID = -85814915841162074L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "system_id")
    private Long hierarchyTransferDetailId;

    @ManyToOne(targetEntity = Agent.class)
    @JoinColumn(name = "agent", referencedColumnName = "id_agent_info")
    private Agent agentSystemId;
    
    @ManyToOne(targetEntity = Agent.class)
    @JoinColumn(name = "parent_system_id", referencedColumnName = "id_agent_info")
    private Agent parentSystemId;
    
    @ManyToOne(targetEntity=Designation.class)
    @JoinColumn(name = "designation_type", referencedColumnName="DesignationId")
    private Designation designationType;

    @JoinColumn(name = "BUID", referencedColumnName = "BusinessChannelsId")
    @ManyToOne(targetEntity = BusinessUnit.class)
    private BusinessUnit businessUnit;

    @Column(name = "branch_code")
    private String branchcode;
    
    @Column(name = "effective_from")
    private LocalDate effectiveFrom;

    @Column(name = "effective_to")
    private LocalDate effectiveTo;

    //
    //

    public Long getHierarchyTransferDetailId() {
        return hierarchyTransferDetailId;
    }

    public void setHierarchyTransferDetailId(Long hierarchyTransferDetailId) {
        this.hierarchyTransferDetailId = hierarchyTransferDetailId;
    }

    public Agent getAgentSystemId() {
        return agentSystemId;
    }

    public void setAgentSystemId(Agent agentSystemId) {
        this.agentSystemId = agentSystemId;
    }

    

    public Designation getDesignationType() {
		return designationType;
	}

	public void setDesignationType(Designation designationType) {
		this.designationType = designationType;
	}

	public BusinessUnit getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(BusinessUnit businessUnit) {
        this.businessUnit = businessUnit;
    }

    public LocalDate getEffectiveFrom() {
        return effectiveFrom;
    }

    public void setEffectiveFrom(LocalDate effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
    }

    public LocalDate getEffectiveTo() {
        return effectiveTo;
    }

    public void setEffectiveTo(LocalDate effectiveTo) {
        this.effectiveTo = effectiveTo;
    }

	public String getBranchcode() {
		return branchcode;
	}

	public void setBranchcode(String branchcode) {
		this.branchcode = branchcode;
	}

	public Agent getParentSystemId() {
		return parentSystemId;
	}

	public void setParentSystemId(Agent parentSystemId) {
		this.parentSystemId = parentSystemId;
	}

	@Override
	public String toString() {
		return "HierarchyTransferDetail [hierarchyTransferDetailId=" + hierarchyTransferDetailId + ", agentSystemId="
				+ agentSystemId + ", parentSystemId=" + parentSystemId + ", designationType=" + designationType
				+ ", businessUnit=" + businessUnit + ", branchcode=" + branchcode + ", effectiveFrom=" + effectiveFrom
				+ ", effectiveTo=" + effectiveTo + "]";
	}
    
    
}
