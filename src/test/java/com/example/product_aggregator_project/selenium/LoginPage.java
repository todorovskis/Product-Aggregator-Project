package com.example.product_aggregator_project.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {

    private WebElement username;
    private WebElement password;
    private WebElement submit;

    protected LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public static LoginPage openLogin(WebDriver webDriver) {
        get(webDriver, "/login");
        System.out.println(webDriver.getCurrentUrl());
        return PageFactory.initElements(webDriver, LoginPage.class);
    }

    public static ProductsPage doLogin(WebDriver webDriver, LoginPage loginPage, String username, String password) {
        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);
        loginPage.submit.click();
        System.out.println(webDriver.getCurrentUrl());
        return PageFactory.initElements(webDriver, ProductsPage.class);
    }

    public static LoginPage logout(WebDriver webDriver) {
        get(webDriver, "/logout");
        return PageFactory.initElements(webDriver, LoginPage.class);
    }
}
