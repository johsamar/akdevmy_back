package com.softlond.akdevmy.dtos;

import jakarta.validation.constraints.NotBlank;

public class ClassPositionDto {

	@NotBlank(message = "required")
	private String _id;
	@NotBlank(message = "required")
	private Integer position;

	public ClassPositionDto(String _id, Integer position) {
		super();
		this._id = _id;
		this.position = position;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

}
