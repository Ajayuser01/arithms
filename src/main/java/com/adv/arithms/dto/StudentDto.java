package com.adv.arithms.dto;

public class StudentDto {

	private int id;

	private String name;

	private String section;

	private String standard;

	private String mobile;
	
	private AddressDto address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public AddressDto getAddress() {
		return address;
	}

	public void setAddress(AddressDto addressDto) {
		this.address = addressDto;
	}

	@Override
	public String toString() {
		return "StudentDto [id=" + id + ", name=" + name + ", section=" + section + ", standard="
					+ standard + ", mobile=" + mobile + ", address=" + address + "]";
	}

}
