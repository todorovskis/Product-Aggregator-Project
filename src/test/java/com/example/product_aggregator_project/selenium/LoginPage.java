package com.example.product_aggregator_project.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {

    private WebElement username;
    private WebElement password;
    private WebElement submit;

    public LoginPage() {
        super();
    }

    public WebElement find(By by) throws InterruptedException {
        for (int milis=0; milis<3000; milis=milis+200){
            try{
                submit = webDriver.findElement(by);

            }catch(Exception e){
                Thread.sleep(200);
            }

        }
        return submit;
    }

    public static LoginPage openLogin(WebDriver webDriver) {
        get(webDriver, "/login");
        System.out.println(webDriver.getCurrentUrl());
        return PageFactory.initElements(webDriver, LoginPage.class);
    }

    public static ProductsPage doLogin(WebDriver webDriver, LoginPage loginPage, String username, String password) throws InterruptedException {
        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);
        WebElement submitButton = webDriver.findElement(By.id("submitBtn"));
        submitButton.click();
//        loginPage.submit.click();
        System.out.println(webDriver.getCurrentUrl());
        return PageFactory.initElements(webDriver, ProductsPage.class);
    }

    public static LoginPage logout(WebDriver webDriver) {
        get(webDriver, "/logout");
        return PageFactory.initElements(webDriver, LoginPage.class);
    }
}
