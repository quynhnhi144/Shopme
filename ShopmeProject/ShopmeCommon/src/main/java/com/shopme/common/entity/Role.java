package com.shopme.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "roles")
public class Role {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 40, nullable = false, unique = true)
	private String name;

	@Column(length = 150, nullable = false)
	private String description;

	/**
	 *
	 **/
	public Role() {
		// TODO Auto-generated constructor stub
	}
	
	public Role(Integer id) {
		this.id = id;
	}

	public Role(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).append(getName()).append(getDescription()).build();
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(!(obj instanceof Role)) return false;
		
		Role that = (Role)obj;
		
		return new EqualsBuilder()
				.append(getId(), that.getId())
				.append(getName(), that.getName())
				.append(getDescription(), that.getDescription())
				.isEquals();
	}

	@Override
	public String toString() {
		return name;
	}
}
