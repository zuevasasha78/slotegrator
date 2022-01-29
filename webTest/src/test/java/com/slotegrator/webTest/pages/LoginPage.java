package com.slotegrator.webTest.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage {

    private WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(id = "UserLogin_username")
    private WebElement login;

    @FindBy(id = "UserLogin_password")
    private WebElement passwordElement;

    @FindBy(css = "input[class='btn btn-primary btn-lg btn-block']")
    private WebElement signIn;

    @Step("Логин")
    public void login(String userName, String password) {
        login.sendKeys(userName);
        passwordElement.sendKeys(password);
        signIn.click();
    }
}
