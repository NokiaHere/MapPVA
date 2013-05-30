package com.nokia.poi;

import static org.junit.Assert.*;

import org.junit.Test;

public class PoiTest {

	@Test
	public void testHasCoord() {
		assertEquals(true, new Poi("10001", 20.1f, 90.1f).hasCoord());
		assertEquals(false, new Poi("10002", -200f, 30f).hasCoord());
		assertEquals(false, new Poi("10003", -30f, -200f).hasCoord());
		assertEquals(false, new Poi("10004", -200f, -200f).hasCoord());
	}

}
