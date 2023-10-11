package com.project.template.exceptions;

public class ResourceNotFoundException extends Exception {
	public ResourceNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
