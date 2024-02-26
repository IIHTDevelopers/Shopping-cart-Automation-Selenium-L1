package com.iiht.evaluation.automation.functional;


import static com.iiht.evaluation.automation.testutils.TestUtils.businessTestFile;
import static com.iiht.evaluation.automation.testutils.TestUtils.currentTest;
import static com.iiht.evaluation.automation.testutils.TestUtils.yakshaAssert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


import com.iiht.evaluation.automation.Activities;
import com.iiht.evaluation.automation.App;
import com.iiht.evaluation.automation.testutils.MasterData;

@TestMethodOrder(OrderAnnotation.class)
public class TestAutomation extends App {

    private static WebDriver driver;
	private static Actions actions;
	
	
	
	public static String getHrefOfLink(WebElement w)
	{
		
		if (w.getAttribute("outerHTML").startsWith("<a")) {
			return w.getAttribute("href");
		}
		else
			return w.getAttribute("outerHTML");
		
	}

    @Test
    @Order(1)
    public void test_click_on_shop_menu() throws IOException {
        boolean testcase_status = true;
        try {
            boolean click_shop_menu_succeed = Activities.click_shop_menu(driver);
            System.out.println("click_shop_menu_succeed " + click_shop_menu_succeed);
            if (!click_shop_menu_succeed) {
                testcase_status = false;
            }
            System.out.println("testcase_status " + testcase_status);
            yakshaAssert(currentTest(), testcase_status, businessTestFile);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
           yakshaAssert(currentTest(), testcase_status, businessTestFile);
        }
    }
    @Test
    @Order(2)
    public void test_click_cart_icon() throws IOException {
        boolean testcase_status = true;
        try {
            boolean click_cart_item_succeed = Activities.click_cart_icon(driver);
           
            if (!click_cart_item_succeed) {
                testcase_status = false;
            }
            System.out.println("testcase_status " + testcase_status);
            yakshaAssert(currentTest(), testcase_status, businessTestFile);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
           yakshaAssert(currentTest(), testcase_status, businessTestFile);
        }
    }

    @Test
    @Order(3)
    public void test_add_current_product_count_in_excel() throws IOException {
        boolean testcase_status = true;
        try {
            boolean add_current_product_count_in_excel = Activities.add_current_product_count_in_excel(driver);
           
            if (!add_current_product_count_in_excel) {
                testcase_status = false;
            }
           // System.out.println("testcase_status " + testcase_status);
            yakshaAssert(currentTest(), testcase_status, businessTestFile);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
           yakshaAssert(currentTest(), testcase_status, businessTestFile);
        }
    }



    @Test
    @Order(4)
    public void test_arrival_images_add_to_basket_clik_home_menu_button() throws IOException {
        boolean testcase_status = true;
        try {
            boolean click_home_menu_button_succeed = Activities.click_home_menu_button(driver);
            System.out.println("click_home_menu_button_succeed " + click_home_menu_button_succeed);
            if (!click_home_menu_button_succeed) {
                testcase_status = false;
            }
            System.out.println("testcase_status " + testcase_status);
            yakshaAssert(currentTest(), testcase_status, businessTestFile);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
            yakshaAssert(currentTest(), testcase_status, businessTestFile);
        }
    }

  

    @Test
    @Order(5)
    public void test_click_image_in_arrival() throws IOException {
        boolean testcase_status = true;
        String product_name = MasterData.test_arrival_add_to_basket_items_master_data.get("product_name");
        try {
            boolean click_image_in_arrival_succeed = Activities.click_product_product_image_in_arrival(driver,product_name);
            System.out.println("click_image_in_arrival_succeed " + click_image_in_arrival_succeed);
            if (!click_image_in_arrival_succeed) {
                testcase_status = false;
            }
            System.out.println("testcase_status " + testcase_status);
            yakshaAssert(currentTest(), testcase_status, businessTestFile);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
            yakshaAssert(currentTest(), testcase_status, businessTestFile);
        }
    }

    @Test
    @Order(6)
    public void test_click_add_to_basket_button_product_detail_page() throws IOException {
        boolean testcase_status = true;
        try {
            boolean click_add_to_basket_button_product_detail_page_succeed = Activities.click_add_to_basket_button_product_detail_page(driver);
            System.out.println("click_add_to_basket_button_product_detail_page_succeed " + click_add_to_basket_button_product_detail_page_succeed);
            if (!click_add_to_basket_button_product_detail_page_succeed) {
                testcase_status = false;
            }
            System.out.println("testcase_status " + testcase_status);
            yakshaAssert(currentTest(), testcase_status, businessTestFile);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
            yakshaAssert(currentTest(), testcase_status, businessTestFile);
        }
    }

    @Test
    @Order(7)
    public void test_check_product_added_message_product_detail_page() throws IOException {
        String product_name = MasterData.test_arrival_add_to_basket_items_master_data.get("product_name");
        boolean testcase_status = true;
        try {
            boolean check_product_added_message_product_detail_page_succeed = Activities.check_product_added_message_product_detail_page(driver,product_name);
            System.out.println("check_product_added_message_product_detail_page_succeed " + check_product_added_message_product_detail_page_succeed);
            if (!check_product_added_message_product_detail_page_succeed) {
                testcase_status = false;
            }
            System.out.println("testcase_status " + testcase_status);
            yakshaAssert(currentTest(), testcase_status, businessTestFile);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
            yakshaAssert(currentTest(), testcase_status, businessTestFile);
        }
    }

    @Test
    @Order(8)
    public void test_click_item_detail_menu() throws IOException {
        boolean testcase_status = true;
        try {
            boolean click_item_detail_menu_succeed = Activities.click_item_detail_menu(driver);
            System.out.println("click_item_detail_menu_succeed " + click_item_detail_menu_succeed);
            if (!click_item_detail_menu_succeed) {
                testcase_status = false;
            }
            System.out.println("testcase_status " + testcase_status);
            yakshaAssert(currentTest(), testcase_status, businessTestFile);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
            yakshaAssert(currentTest(), testcase_status, businessTestFile);
        }
    }

    @Test
    @Order(9)
    public void test_check_checkout_button() throws IOException {
        String product_name = MasterData.test_arrival_add_to_basket_items_master_data.get("product_name");
        boolean testcase_status = true;
        try {
            boolean check_product_total_checkout_page_succeed = Activities.check_checkout_button(driver,product_name);
            System.out.println("check_product_total_checkout_page_succeed " + check_product_total_checkout_page_succeed);
            if (!check_product_total_checkout_page_succeed) {
                testcase_status = false;
            }
            System.out.println("testcase_status " + testcase_status);
            yakshaAssert(currentTest(), testcase_status, businessTestFile);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
            yakshaAssert(currentTest(), testcase_status, businessTestFile);
        }
    }


}

