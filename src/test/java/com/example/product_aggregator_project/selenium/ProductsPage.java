package com.example.product_aggregator_project.selenium;

import lombok.Getter;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
public class ProductsPage extends AbstractPage {

    @FindBy(css = "li[class=product]")
    private List<WebElement> productRows;

    @FindBy(className = ".add-item")
    private List<WebElement> addProductButton;

    public ProductsPage() {
        super();
    }

    public static ProductsPage to(WebDriver webDriver) {
        get(webDriver, "/home");
        return PageFactory.initElements(webDriver, ProductsPage.class);
    }

    public void assertElements(int productsNumber, int addButtons) {
        Assert.assertEquals("rows do not match", productsNumber, this.getProductRows().size());
        Assert.assertEquals("add is visible", addButtons, this.getAddProductButton().size());
    }

}
