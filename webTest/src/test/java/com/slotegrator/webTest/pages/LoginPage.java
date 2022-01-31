package com.slotegrator.webTest.pages;

import com.slotegrator.webTest.infrastructure.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "UserLogin_username")
    private WebElement login;

    @FindBy(id = "UserLogin_password")
    private WebElement passwordElement;

    @FindBy(css = "input[class='btn btn-primary btn-lg btn-block']")
    private WebElement signIn;

    @Step("Открыть сайт")
    public void openSite() {
        driver.get("http://test-app.d6.dev.devcaz.com/admin/login/");
    }

    @Step("Логин")
    public void login(String userName, String password) {
        login.sendKeys(userName);
        passwordElement.sendKeys(password);
        signIn.click();
    }
}
