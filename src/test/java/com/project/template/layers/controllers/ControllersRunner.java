package com.project.template.layers.controllers;

import com.intuit.karate.junit5.Karate;

public class ControllersRunner {

	@Karate.Test
	Karate testControllers() {
		return Karate.run("controllers").relativeTo(getClass());
	}

}
