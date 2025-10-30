package com.orangehrm.test;

import org.testng.annotations.Test;

import com.orangehrm.base.BaseClass;

public class Dummyclass extends BaseClass {

	@Test
	public void dummytest() {
		String title = driver.getTitle();
		assert title.equals("Test Login | Practice Test Automation") : "test failed- Title not matching";

		System.out.println("title is matching");
		
	}

}
