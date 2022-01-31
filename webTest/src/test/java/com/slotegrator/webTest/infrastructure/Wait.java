package com.slotegrator.webTest.infrastructure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

    private WebDriver driver;

    public Wait(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilCondition(ExpectedCondition condition, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(condition);
    }

    public void forElementToBeClickable(int timeout, WebElement webElement) {
        ExpectedCondition<WebElement> condition = ExpectedConditions.elementToBeClickable(webElement);
        waitUntilCondition(condition, timeout);
    }

    public void forLoading(int timeout) {
        ExpectedCondition<Object> condition = ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";");
        waitUntilCondition(condition, timeout);
    }
}
