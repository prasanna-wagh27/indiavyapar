package com.indiavyapar.webservice.entity;

import java.io.Serializable;

import org.hibernate.annotations.JdbcTypeCode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "district")
public class District extends Auditable implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@JdbcTypeCode(java.sql.Types.VARCHAR)
	@Column(name = "district_id")
	private String districtId;
	
	@Column(name = "district_name")
	private String districtName;
	
	@JoinColumn(name = "state_id")
	@ManyToOne(targetEntity = State.class)
	private State state;
	
	@Column(name = "status")
	private boolean status;

	public String getDistrictId() {
		return districtId;
	}

	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	

}
