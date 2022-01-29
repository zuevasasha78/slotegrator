package com.slotegrator.webTest;

import com.slotegrator.webTest.pages.LoginPage;
import com.slotegrator.webTest.pages.PlayersDashboardElement;
import com.slotegrator.webTest.pages.TabBarElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {

    protected LoginPage loginPage;
    protected TabBarElement mainPage;
    protected PlayersDashboardElement playersDashboardElement;

    protected WebDriver driver;
    protected static final String userName = "admin1";
    protected static final String password = "[9k<k8^z!+$$GkuP";

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        mainPage = new TabBarElement(driver);
        playersDashboardElement = new PlayersDashboardElement(driver);
    }

    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
