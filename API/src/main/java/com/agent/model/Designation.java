package com.agent.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "DESIGNATION_MASTER")
public class Designation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1408991789080739063L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DesignationId")
	private Long designationId;
	@Column(name = "DesignationCode")
	private String code;
	@Column(name = "Label")
	private String label;
	@Column(name = "Status")
	private String status;
	//
	//
	public Long getDesignationId() {
		return designationId;
	}

	public void setDesignationId(Long designationId) {
		this.designationId = designationId;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Designation that = (Designation) o;
		return Objects.equals(designationId, that.designationId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(designationId);
	}
}
