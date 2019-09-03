package com.agent.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "HIERARCHY_NODE_DETAIL")
public class HierarchyNodeDetail implements Serializable {
    private static final long serialVersionUID = 8123036186389464927L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HNodeDetailId")
    private Long hierarchyNodeDetailId;

    @ManyToOne(targetEntity = HierarchyNode.class)
    @JoinColumn(name = "hnodeid", referencedColumnName = "HNodeId")
    private HierarchyNode hierarchyNodeId;

    @ManyToOne(targetEntity = HierarchyNode.class)
    @JoinColumn(name = "parentnodeid", referencedColumnName = "HNodeId")
    private HierarchyNode parentNodeId;

    @Column(name = "Status")
    private String status;

    @Column(name = "EffectiveFrom")
    private LocalDate effectiveFrom;

    @Column(name = "EffectiveTo")
    private LocalDate effectiveTo;

    //
    //
    public Long getHierarchyNodeDetailId() {
        return hierarchyNodeDetailId;
    }

    public void setHierarchyNodeDetailId(Long hierarchyNodeDetailId) {
        this.hierarchyNodeDetailId = hierarchyNodeDetailId;
    }

    public HierarchyNode getHierarchyNodeId() {
        return hierarchyNodeId;
    }

    public void setHierarchyNodeId(HierarchyNode hierarchyNodeId) {
        this.hierarchyNodeId = hierarchyNodeId;
    }

    public HierarchyNode getParentNodeId() {
        return parentNodeId;
    }
    public long getParentNodeIdFromObject() {
    	return parentNodeId.getHierarchyNodeId();
    }

    public void setParentNodeId(HierarchyNode parentNodeId) {
        this.parentNodeId = parentNodeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
}
