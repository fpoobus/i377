package com.homework.model;

import javax.persistence.*;

@Entity
public class DbItem {

	@Id
	@SequenceGenerator(name="my_seq", sequenceName="SEQ1",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="my_seq")
	private Long id;
	private String name;
	private String code;
	private Long super_unit_id;
	
	public DbItem(String name) {
		this.name = name;
	}
	
	public DbItem() {
		//Do nothing
	} 
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public Long getSuperior() {
		return super_unit_id;
	}
	
	public void setSuperior(Long superior) {
		this.super_unit_id = superior;
	}
	
	public Long getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "DbItem: [Name: " + name +"] [Code: " + code+"] [Superior: " + super_unit_id +"]";
	}
	
}
