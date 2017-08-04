package com.mysefrmwrk.mytestproject.testgames.testdata;

import org.testng.annotations.DataProvider;

import com.mysefrmwrk.sefrmwrk.utils.ExcelHelper;


public class TestDataProvider {

	@DataProvider(parallel = false, name = "logins")
	public static Object[][] logins() {
		return new Object[][] { { "admin", "superduper" }, { "doesnotexist", "test" }, { "admin", "test" },
				{ "", "" }, };
	}
	
	
	@DataProvider(parallel = false, name = "loginsExcel")
	public static Object[][] loginsExcel() {
		ExcelHelper datafile = new ExcelHelper(
				System.getProperty("user.dir") + "/src/test/java/com/sefrmwrk/app/testgames/data/" + "TestData.xlsx");
		Object[][] sheetData = datafile.getExcelData("Login");
		Object[] headers = sheetData[0];
		int numberOfRows = sheetData.length;
		int numberofTC = numberOfRows-1;
		
		Object[][] objects = new Object[numberofTC][1];
		for (int i = 0; i < numberofTC; i++) {
			objects[i][0] =sheetData[i+1][getHeaderColumnNumber("Login", headers)];
			System.out.println("Test Parameters: " + objects[i][0].toString());
		}
		return objects;
		
	}
	
	@DataProvider(parallel = false, name = "loginValid")
	public static Object[][] loginValid() {
		return new Object[][] { { "admin", "superduper" } };
	}

	@DataProvider(parallel = false, name = "loginInvalidUserName")
	public static Object[][] loginInvalidUserName() {
		return new Object[][] { { "mario", "superduper" } };
	}

	@DataProvider(parallel = false, name = "loginInvalidPassword")
	public static Object[][] loginInvalidPassword() {
		return new Object[][] { { "admin", "invalid" } };
	}

	@DataProvider(parallel = false, name = "loginEmpty")
	public static Object[][] loginEmpty() {
		return new Object[][] { { "", "" } };
	}
	
	private static int getHeaderColumnNumber(String headerName, Object[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].toString().equals(headerName)) {
				return i;
			}
		}
		return -1;
	}

}
