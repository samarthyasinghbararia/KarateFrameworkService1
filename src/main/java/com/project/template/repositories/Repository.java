package com.project.template.repositories;

import com.project.template.entities.Template;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Template, Integer> {}
