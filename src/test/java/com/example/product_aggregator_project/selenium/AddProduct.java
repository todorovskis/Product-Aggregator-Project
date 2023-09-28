package com.example.product_aggregator_project.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AddProduct extends AbstractPage {

    private WebElement productName;
    private WebElement category;
    private WebElement manufacturer;
    private WebElement postDate;
    private WebElement characteristic;
    private WebElement submit;

    public AddProduct() {
        super();
    }

    public static ProductsPage addProduct(WebDriver driver, String productName, String category, String manufacturer, String postDate, String characteristic) {
        get(driver, "/products/add");
        AddProduct addProduct = PageFactory.initElements(driver, AddProduct.class);
        addProduct.productName.sendKeys(productName);
        addProduct.postDate.sendKeys(postDate);
        addProduct.characteristic.sendKeys(characteristic);
        addProduct.category.click();
        addProduct.category.findElement(By.xpath("//option[. = '" + category + "']")).click();
        addProduct.manufacturer.click();
        addProduct.manufacturer.findElement(By.xpath("//option[. = '" + manufacturer + "']")).click();

        addProduct.submit.click();
        return PageFactory.initElements(driver, ProductsPage.class);
    }

}
