package com.san.readcsv;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedHashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.san.base.util.WooplrCsvUtil;
import com.wooplr.base.controller.TestPlan;
import com.wooplr.base.controller.TestRetryAnalyzer;
import com.wooplr.base.util.internal.entity.TestObject;

/**
 * @author Santosh C
 * 
 */
@Test(groups = { "SANITY" }, retryAnalyzer = TestRetryAnalyzer.class)
public class ReadFromCSVTestPlan extends TestPlan {

	final static String DATAPROVIDER_NAME = "READ_CSV";
	final static String CSV_PATH = "./src/test/java/com/san/readcsv/ReadFromCSVTestData.csv";

	@DataProvider(name = DATAPROVIDER_NAME)
	public static Iterator<Object[]> getInfo(Method method) {
		Iterator<Object[]> objectsFromCsv = null;
		try {
			String fileName = CSV_PATH;
			LinkedHashMap<String, Class<?>> entityClazzMap = new LinkedHashMap<String, Class<?>>();
			LinkedHashMap<String, String> methodFilter = new LinkedHashMap<String, String>();
			methodFilter.put(TestObject.TEST_TITLE, method.getName());
			entityClazzMap.put("SpireTestObject", TestObject.class);
			//entityClazzMap.put("TestData", TestData.class);     
			objectsFromCsv = WooplrCsvUtil.getObjectsFromCsv(ReadFromCSVTestPlan.class, entityClazzMap, fileName, null,
					methodFilter);

		} catch (Exception e) {
			e.printStackTrace();  
		}
		return objectsFromCsv;
	}

	/**
	 * readFromCSV
	 * 
	 * @param testObject
	 */
	@Test(groups = { "readFromCSV", "Sanity" }, dataProvider = DATAPROVIDER_NAME)
	public void readFromCSV(TestObject testObject) {

		System.out.println("DATA: " + testObject.getTestData());

	}

}