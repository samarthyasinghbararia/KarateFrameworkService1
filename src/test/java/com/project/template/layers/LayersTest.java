package com.project.template.layers;

import com.intuit.karate.junit5.Karate;

/**
 * Run the feature files from the root directory.
 */
public class LayersTest {

	@Karate.Test
	Karate testAll() {
		return Karate.run().relativeTo(getClass());
	}

}
