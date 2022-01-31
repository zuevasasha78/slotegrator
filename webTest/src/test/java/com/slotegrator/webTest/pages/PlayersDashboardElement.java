package com.slotegrator.webTest.pages;

import com.slotegrator.webTest.infrastructure.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersDashboardElement extends BasePage {

    public PlayersDashboardElement() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "table[class='table table-hover table-striped table-bordered table-condensed']")
    private WebElement playersTable;

    @FindBy(xpath = "//*[text() = 'Registration date']")
    private WebElement registrationDate;

    @FindAll(@FindBy(xpath = "//*[@id=\"payment-system-transaction-grid\"]/table/tbody//td[10]"))
    private List<WebElement> registrationDataList;

    @Step("Таблица игроков загрузилась")
    public void checkPlayersTableDisplayed() {
        playersTable.isDisplayed();
    }

    @Step("Отсортировать игроков по дте регистрации")
    public void sortedByRegistrationDate() {
        registrationDate.click();
    }

    @Step("Проверка: игроки отсортированы по дате регистрации")
    public void checkSortedPlayers() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LinkedList<Date> elementsText = new LinkedList<>();
        for (WebElement element : registrationDataList) {
            String text = element.getText();
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Date date = formatter.parse(text);
                elementsText.add(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        assertThat(elementsText).isSorted();
    }
}
