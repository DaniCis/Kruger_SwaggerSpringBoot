package com.kruger.microservice;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.kruger.microservice.test.Location;

public class LocationTestCase {

	@Test
	public void testLocationAddresNotNull() {
		Location location = new Location();
		//location.setAddress("old fire station");
		assertNull(location.getAddress());
	}
}
