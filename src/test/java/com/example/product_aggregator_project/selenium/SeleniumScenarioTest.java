package com.example.product_aggregator_project.selenium;

import com.example.product_aggregator_project.model.Category;
import com.example.product_aggregator_project.model.Manufacturer;
import com.example.product_aggregator_project.model.User;
import com.example.product_aggregator_project.service.CategoryService;
import com.example.product_aggregator_project.service.ManufacturerService;
import com.example.product_aggregator_project.service.ProductService;
import com.example.product_aggregator_project.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SeleniumScenarioTest {

    @Autowired
    UserService userService;

    @Autowired
    ManufacturerService manufacturerService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    private HtmlUnitDriver driver;

    private static Category c1;
    private static Category c2;
    private static Manufacturer m1;
    private static Manufacturer m2;
    private static User regularUser;

    private static String user = "user3";

    private static boolean dataInitialized = false;

    @BeforeEach
    private void setup() {
        this.driver = new HtmlUnitDriver(true);
        initData();
    }

    @AfterEach
    public void destroy() {
        if (this.driver != null) {
            this.driver.close();
        }
    }

    private void initData() {
        if (!dataInitialized) {
            c1 = new Category("TestCategory1", null);
            c2 = new Category("TestCategory2", null);

            m1 = new Manufacturer("TestManufacturer1", "TestCountry");
            m2 = new Manufacturer("TestManufacturer2", "TestCountry");


            regularUser = userService.register(user, user, user, user, user, "user3@gmail.com", "123-456-789");
            dataInitialized = true;
        }
    }

    @Test
    public void testScenario() throws Exception {
        ProductsPage productsPage = ProductsPage.to(this.driver);
        productsPage.assertElements(0,  0);
        LoginPage loginPage = LoginPage.openLogin(this.driver);

        LoginPage.doLogin(this.driver, loginPage, regularUser.getUsername(), user);
        productsPage.assertElements(0 , 0);

        productsPage = AddProduct.addProduct(this.driver, "testProduct", c1.getCategoryName(), m1.getManufacturerName(), "2023-09-24", "TestDesc");
        productsPage.assertElements(1, 1);
        loginPage = LoginPage.logout(this.driver);
        productsPage = LoginPage.doLogin(this.driver, loginPage, regularUser.getUsername(), user);
        productsPage.assertElements(1 , 0);
    }
}
