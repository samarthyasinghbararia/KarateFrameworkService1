package com.project.template;

import com.intuit.karate.junit5.Karate;

class TestRunner {
	@Karate.Test
	Karate runTests() {
		return Karate.run("./src/test/java/com/project/template");
	}
}
