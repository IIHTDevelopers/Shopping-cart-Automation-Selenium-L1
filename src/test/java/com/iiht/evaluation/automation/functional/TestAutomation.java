package com.iiht.evaluation.automation.functional;


import static com.iiht.evaluation.automation.testutils.TestUtils.businessTestFile;
import static com.iiht.evaluation.automation.testutils.TestUtils.currentTest;
import static com.iiht.evaluation.automation.testutils.TestUtils.yakshaAssert;

import java.io.IOException;

import org.testng.annotations.Test;

import com.iiht.evaluation.automation.Activities;
import com.iiht.evaluation.automation.App;
import com.iiht.evaluation.automation.testutils.MasterData;

public class TestAutomation extends App {

   

   

   

    @Test
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

