package com.project.template.examples.controllers;

import com.intuit.karate.junit5.Karate;

public class ControllersTest {

	@Karate.Test
	Karate testControllers() {
		return Karate.run("controllerTests").relativeTo(getClass());
	}

}
