package com.adv.arithms.dto;


public class AddressDto {

	private int id;

	private String district;

	private int pincode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "AddressDto [id=" + id + ", district=" + district + ", pincode=" + pincode + "]";
	}

}
