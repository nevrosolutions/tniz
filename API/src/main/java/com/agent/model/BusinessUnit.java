package com.agent.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "BUSINESS_CHANNELS")
public class BusinessUnit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3243281869488878410L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BusinessChannelsId")
	private Integer businessUnitId;
	@Column(name = "BusinessChannelsName")
	private String businessChannelName;
	@Column(name = "BusinessChannelsStatus")
	private String businessChannelStatus;

	//
	//

	public Integer getBusinessUnitId() {
		return businessUnitId;
	}

	public void setBusinessUnitId(Integer businessUnitId) {
		this.businessUnitId = businessUnitId;
	}

	public String getBusinessChannelName() {
		return businessChannelName;
	}

	public void setBusinessChannelName(String businessChannelName) {
		this.businessChannelName = businessChannelName;
	}

	public String getBusinessChannelStatus() {
		return businessChannelStatus;
	}

	public void setBusinessChannelStatus(String businessChannelStatus) {
		this.businessChannelStatus = businessChannelStatus;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BusinessUnit that = (BusinessUnit) o;
		return businessUnitId.equals(that.businessUnitId) &&
				businessChannelName.equals(that.businessChannelName) &&
				businessChannelStatus.equals(that.businessChannelStatus);
	}

	@Override
	public int hashCode() {
		return Objects.hash(businessUnitId, businessChannelName, businessChannelStatus);
	}
}
