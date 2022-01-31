package com.slotegrator.webTest.infrastructure;

import cucumber.api.java.After;
import org.openqa.selenium.WebDriver;

public class TearDown {

    private WebDriver driver;

    public TearDown() {
        this.driver = Setup.driver;
    }

    @After
    public void quitDriver() {
        this.driver.quit();
    }
}
