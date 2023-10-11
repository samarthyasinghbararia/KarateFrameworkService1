package com.project.template.services;

import com.project.template.entities.Template;
import com.project.template.exceptions.ResourceNotFoundException;

public interface Service {

	Template get(Integer id) throws ResourceNotFoundException;
	Template post(Template template);
	Template put(Template template) throws ResourceNotFoundException;
	Template delete(Integer id) throws ResourceNotFoundException;

}
