package com.softlond.akdevmy.dtos;

import jakarta.validation.constraints.NotBlank;

public class ModuleUpdateDto {

	@NotBlank(message = "required")
	private String name;
	@NotBlank(message = "required")
	private String description;

	public ModuleUpdateDto(String name, String description) {
		super();
		this.name = name;
		this.description = description;
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

}
