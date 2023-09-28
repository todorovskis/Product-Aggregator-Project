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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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

    private WebDriver driver;

    private static Category c1;
    private static Category c2;
    private static Manufacturer m1;
    private static Manufacturer m2;
    private static User regularUser;

    private static String user = "user3";

    private static boolean dataInitialized = false;

    @BeforeEach
    private void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        int desiredPort = 65432;

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--port=" + desiredPort);
        options.addArguments("--remote-allow-origins=*");
        options.setBinary("C:\\Users\\User\\Desktop\\chrome-win64 (1)\\chrome-win64\\chrome.exe");

        this.driver = new ChromeDriver(options);
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

            dataInitialized = true;
        }
    }

    @Test
    public void testScenario() throws Exception {
        ProductsPage productsPage = ProductsPage.to(this.driver);
        productsPage.assertElements(0,  0);
        LoginPage loginPage = LoginPage.openLogin(this.driver);

        LoginPage.doLogin(this.driver, loginPage, "admin.admin@gmail.com", "admin");
        productsPage.assertElements(0 , 0);

        productsPage = AddProduct.addProduct(this.driver, "testProduct", c1.getCategoryName(), m1.getManufacturerName(), "2023-09-24", "TestDesc");
        productsPage.assertElements(1, 1);
        loginPage = LoginPage.logout(this.driver);
        productsPage = LoginPage.doLogin(this.driver, loginPage, regularUser.getUsername(), user);
        productsPage.assertElements(1 , 0);
    }
}
