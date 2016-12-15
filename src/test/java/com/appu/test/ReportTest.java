package com.appu.test;

import org.testng.annotations.Test;

@Test(groups = { "Sanity" })
public class ReportTest {

	@Test(groups = { "Sanity", "createProduct" })
	public void createProduct() {

		System.out.println("createProduct !!!!!!!!");
	}

	@Test(groups = { "Sanity", "getProduct" })
	public void getProduct() {

		System.out.println("getProduct !!!!!!!!");
	}  

}
