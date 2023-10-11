package com.project.template.services;

import com.project.template.entities.Template;
import com.project.template.exceptions.ResourceNotFoundException;
import com.project.template.repositories.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceImpl implements Service {

	@Autowired
	private Repository repository;

	@Override
	public Template get(Integer id) throws ResourceNotFoundException {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found For Id: " + id));
	}

	@Override
	public Template post(Template template) {
		return repository.save(template);
	}

	@Override
	public Template put(Template template) throws ResourceNotFoundException {

		this.get(template.getId());
		return repository.save(template);

	}

	@Override
	public Template delete(Integer id) throws ResourceNotFoundException {

		Template template = this.get(id);
		repository.deleteById(id);
		return template;

	}

}
