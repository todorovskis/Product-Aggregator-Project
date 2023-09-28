package com.example.product_aggregator_project.selenium;

import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
public class AbstractPage {

    protected WebDriver webDriver;

    public AbstractPage(){}

    static void get(WebDriver webDriver, String relativeUrl) {
        String url = System.getProperty("geb.build.baseUrl", "http://localhost:9090") + relativeUrl;
        webDriver.get(url);
    }
}
