package testcases;

import static testutils.TestUtils.businessTestFile;
import static testutils.TestUtils.currentTest;
import static testutils.TestUtils.yakshaAssert;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coreUtilities.testutils.ApiHelper;
import coreUtilities.utils.FileOperations;
import pages.Practice_Automation_L1_Pages;
import pages.StartupPage;
import testBase.AppTestBase;

public class Practice_Automation_L1_TestCases extends AppTestBase {
	Map<String, String> configData;
	Map<String, String> loginCredentials;
	String expectedDataFilePath = testDataFilePath + "expected_data.json";
	StartupPage startupPage;
	Practice_Automation_L1_Pages L1PageClass;

	@Parameters({ "browser", "environment" })
	@BeforeClass(alwaysRun = true)
	public void initBrowser(String browser, String environment) throws Exception {
		try {
			configData = new FileOperations().readJson(config_filePath, environment);
			configData.put("url", configData.get("url").replaceAll("[\\\\]", ""));
			configData.put("browser", browser);

			boolean isValidUrl = new ApiHelper().isValidUrl(configData.get("url"));
			
			initialize(configData);
			startupPage = new StartupPage(driver);
			L1PageClass = new Practice_Automation_L1_Pages(driver);
			yakshaAssert(currentTest(), isValidUrl, businessTestFile);
			Assert.assertTrue(isValidUrl,
					configData.get("url") + " might be Server down at this moment. Please try after sometime.");
		} catch (Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 1, groups = { "sanity" }, description = "Check if “Shop” Menu Option is available.")
	public void check_Shop_Menu() throws Exception {
		try {
			Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "Shop_menu");
			String title = L1PageClass.Shop_is_available_or_not();
			yakshaAssert(currentTest(),
					title.equals(expectedData.get("Shop_menu_title")),
					businessTestFile);
			Assert.assertEquals(title, expectedData.get("Shop_menu_title"),
					"page title is not matching please check manually");
		} catch (Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 2, groups = { "sanity" }, description = " Click on “Shop” Menu Option")
	public void click_Shop_Menu() throws Exception {
		try {
			Practice_Automation_L1_Pages page = L1PageClass.ClickOnShop();
			Assert.assertNotNull(page);
			yakshaAssert(currentTest(), page != null, businessTestFile);
		} catch (Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 3, groups = {
			"sanity" }, description = "Check if the control is successfully navigated to “Shop” page.")
	public void navigate_to_Shop_page() throws Exception {
		try {
			Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "Shop_page");
			String title = L1PageClass.Shop_page_title();
			yakshaAssert(currentTest(), title.equals(expectedData.get("Shop_page_title")),
					businessTestFile);
			Assert.assertEquals(title, expectedData.get("Shop_page_title"),
					"page title is not matching please check manually");
		} catch (Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
			Assert.assertTrue(false);
		}

	}

	

	

	@Test(priority = 4, groups = {
			"sanity" }, description = "Check if “Home” Menu Option is available on navigated page.")
	public void Home_menu() throws Exception {
		try {
			String page = L1PageClass.Home_link_is_available();
			
			yakshaAssert(currentTest(), page != null, businessTestFile);
			Assert.assertNotNull(page);
		} catch (Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 5, groups = {
			"sanity" }, description = "Check if “Home” Menu Option is available on navigated page.")
	public void Click_on_Home() throws Exception {
		try {
			Practice_Automation_L1_Pages page = L1PageClass.click_on_Home_Link();
			
			yakshaAssert(currentTest(), page != null, businessTestFile);
			Assert.assertNotNull(page);
		} catch (Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 6, groups = {
			"sanity" }, description = "Check if the control is successfully navigated to “Home” page.")
	public void navigateToHomePage() throws Exception {
		try {
			Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "HomePage_Title");
			yakshaAssert(currentTest(), L1PageClass.navigate_to_Home_page().equals(expectedData.get("HomepageTitle")),
					businessTestFile);
			Assert.assertEquals(L1PageClass.navigate_to_Home_page(), expectedData.get("HomepageTitle"),
					"page title is not matching please check manually");
		} catch (Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 7, groups = { "sanity" }, description = "Check if “Home” page has a section of new arrivals.")
	public void new_arrival_is_present() throws Exception {
		try {
			String page = L1PageClass.new_Arrivals();
			
			yakshaAssert(currentTest(), page != null, businessTestFile);
			Assert.assertNotNull(page);
		} catch (Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
			Assert.assertTrue(false);
		}
	}

	@Test(priority =8, groups = { "sanity" }, description = "Check of “Arrivals” section has selenium ruby is present")
	public void seleniumu_Ruby_is_present() throws Exception {
		try {
			String page = L1PageClass.seleniumRuby();
			
			yakshaAssert(currentTest(), page != null, businessTestFile);
			Assert.assertNotNull(page);
		} catch (Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
			Assert.assertTrue(false);
		}

	}

	@Test(priority = 9, groups = { "sanity" }, description = "check one product is clickable")
	public void one_product_isClickable() throws Exception {
		try {
			Practice_Automation_L1_Pages page = L1PageClass.click_on_seleniumRuby_Product();
			
			yakshaAssert(currentTest(), page != null, businessTestFile);
			Assert.assertNotNull(page);
		} catch (Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 10, groups = {
			"sanity" }, description = "Check if the control is successfully navigated to Product Details page.")
	public void navigates_to_Selenium_Ruby() throws Exception {
		try {
			Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "Selenium_Ruby");
			yakshaAssert(currentTest(),
					L1PageClass.navigate_to_Home_page().equals(expectedData.get("Selenium_Ruby_title")),
					businessTestFile);
			Assert.assertEquals(L1PageClass.navigate_to_Home_page(), expectedData.get("Selenium_Ruby_title"),
					"page title is not matching please check manually");
		} catch (Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 11, groups = {
			"sanity" }, description = "Check if product details page has an option “ADD TO BASKET”.")
	public void add_to_basket() throws Exception {
		try {
			Practice_Automation_L1_Pages page = L1PageClass.Add_to_basket_is_present();
			
			yakshaAssert(currentTest(), page != null, businessTestFile);
			Assert.assertNotNull(page);
		} catch (Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 12, groups = { "sanity" }, description = "Click on “ADD TO BASKET” option.")
	public void Click_on_add_to_basket() throws Exception {
		try {
			Practice_Automation_L1_Pages page = L1PageClass.ClickonAddToBasket();
			
			yakshaAssert(currentTest(), page != null, businessTestFile);
			Assert.assertNotNull(page);
		} catch (Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 13, groups = {
			"sanity" }, description = "Check if product added message is shown when product is added to basket. Check for message")
	public void verify_message() throws Exception {
		try {
			Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "Message");
			yakshaAssert(currentTest(), L1PageClass.verifyMessages().equals(expectedData.get("message_details")),
					businessTestFile);
			Assert.assertEquals(L1PageClass.verifyMessages(), expectedData.get("message_details"),
					"page title is not matching please check manually");
		} catch (Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 14, groups = { "sanity" }, description = "  Go to cart(Click Cart icon)")
	public void GoToCart() throws Exception {
		try {
			Practice_Automation_L1_Pages page = L1PageClass.go_to_cart();
			
			yakshaAssert(currentTest(), page != null, businessTestFile);
			Assert.assertNotNull(page);
		} catch (Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
			Assert.assertTrue(false);
		}

	}

	@Test(priority = 15, groups = { "sanity" }, description = "Check how many items are there in cart.")
	public void CheckItem() throws Exception {
		try {
			String page = L1PageClass.Check_item_in_cart();
			
			yakshaAssert(currentTest(), page != null, businessTestFile);
			Assert.assertNotNull(page);
		} catch (Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
			Assert.assertTrue(false);
		}

	}

	@Test(priority = 16, groups = { "sanity" }, description = " Check if we have “APPLY COUPON” button or not.")
	public void Apply_Coupon() throws Exception {
		try {
			Practice_Automation_L1_Pages page = L1PageClass.applyCouponIsPresent();
		
			yakshaAssert(currentTest(), page != null, businessTestFile);
			Assert.assertNotNull(page);
		} catch (Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
			Assert.assertTrue(false);
		}

	}

	@Test(priority = 17, groups = { "sanity" }, description = "Check if we have price defined after product name.")
	public void Price_Defined() throws Exception {
		try {
			String page = L1PageClass.PriceDefined();
			
			yakshaAssert(currentTest(), page != null, businessTestFile);
			Assert.assertNotNull(page);
		} catch (Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
			Assert.assertTrue(false);
		}

	}

	@Test(priority = 18, groups = { "sanity" }, description = "Check if we have price defined in correct format or not")
	public void Price_Defined_in_correct_Format() throws Exception {
		try {
			String page = L1PageClass.priceIsInCorrectFormat();
			
			yakshaAssert(currentTest(), page != null, businessTestFile);
			Assert.assertNotNull(page);
		} catch (Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 19, groups = { "sanity" }, description = "Check if we have quantity defined after product price.")
	public void Quantity_Defined() throws Exception {
		try {
			String page = L1PageClass.QuantityDefined();
			
			yakshaAssert(currentTest(), page != null, businessTestFile);
			Assert.assertNotNull(page);
		} catch (Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 20, groups = {
			"sanity" }, description = "Check if we have quantity defined in correct format or not.")
	public void quantity_Defined_in_correct_Format() throws Exception {
		try {
			String page = L1PageClass.quantityIsInCorrectFormat();
		
			yakshaAssert(currentTest(), page != null, businessTestFile);
			Assert.assertNotNull(page);
		} catch (Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 21, groups = { "sanity" }, description = "Check if we have total defined after quantity.")
	public void Total_Defined() throws Exception {
		try {
			String page = L1PageClass.TotalDefined();
			
			yakshaAssert(currentTest(), page != null, businessTestFile);
			Assert.assertNotNull(page);
		} catch (Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 22, groups = {
			"sanity" }, description = "Check if we have total defined in correct format or not.")
	public void Total_Defined_in_Correct_Format() throws Exception {
		try {
			String page = L1PageClass.totalDefinedInCorrectFormat();
			
			yakshaAssert(currentTest(), page != null, businessTestFile);
			Assert.assertNotNull(page);
		} catch (Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
			Assert.assertTrue(false);
		}
	}


	@AfterClass(alwaysRun = true)
	public void tearDown() {
		System.out.println("before closing the browser");
		browserTearDown();
	}

	
}
