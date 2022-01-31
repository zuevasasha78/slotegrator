package com.slotegrator.webTest.pages;

import com.slotegrator.webTest.infrastructure.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TabBarElement extends BasePage {

    public TabBarElement() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "nav-container")
    private WebElement navigation;

    @FindBy(xpath = "//span[text()='Users']")
    private WebElement users;

    @FindBy(xpath = "//*[text() = 'Players']")
    private WebElement players;

    @FindBy(css = "i[class='fa fa-bars']")
    private WebElement bar;

    @Step("Навигация загрузилась")
    public void navigationDisplay() {
        navigation.isDisplayed();
    }

    @Step("Открыть список игроков")
    public void openPlayersList() {
        bar.click();
        wait.forElementToBeClickable(5, users);
        users.click();
        players.click();
    }
}
