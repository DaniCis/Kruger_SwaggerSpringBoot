package com.kruger.microservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.kruger.microservice.test.ISO216Document;

public class ISO216DocumentTestCase {
	
	@Test
	public void testA4Width() {
		ISO216Document doc = new ISO216Document("A4");
		assertEquals(210, doc.getWidth());
	}
	@Test
	public void testA4Height() {
		ISO216Document doc = new ISO216Document("a4");
		assertEquals(297, doc.getHeight());
	}
	

}
