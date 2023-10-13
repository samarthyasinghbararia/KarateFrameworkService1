package com.project.template.examples;

import com.intuit.karate.junit5.Karate;

/**
 * Run the feature files from the root directory.
 */
public class ExamplesTest {

	@Karate.Test
	Karate testAll() {
		return Karate.run().relativeTo(getClass());
	}

}
