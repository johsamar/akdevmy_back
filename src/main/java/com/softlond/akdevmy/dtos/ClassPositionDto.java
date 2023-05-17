package com.softlond.akdevmy.dtos;

import jakarta.validation.constraints.NotBlank;

public class ClassPositionDto {

	@NotBlank(message = "required")
	private String _id;
	@NotBlank(message = "required")
	private String position;

	public ClassPositionDto(String _id, String position) {
		super();
		this._id = _id;
		this.position = position;
	}

	public String getName() {
		return _id;
	}

	public void setName(String _id) {
		this._id = _id;
	}

	public String getDescription() {
		return position;
	}

	public void setDescription(String position) {
		this.position = position;
	}

}
