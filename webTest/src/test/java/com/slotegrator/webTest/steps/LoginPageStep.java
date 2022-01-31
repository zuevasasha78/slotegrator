package com.slotegrator.webTest.steps;

import com.slotegrator.webTest.pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class LoginPageStep {

    private LoginPage loginPage;

    public LoginPageStep() {
        this.loginPage = new LoginPage();
    }

    @Given("Open login page")
    public void openLoginPage() {
        this.loginPage.openSite();
    }

    @When("^Login \"([^\"]*)\" , \"([^\"]*)\"$")
    public void login(String userName, String password) {
        this.loginPage.login(userName, password);
    }
}
