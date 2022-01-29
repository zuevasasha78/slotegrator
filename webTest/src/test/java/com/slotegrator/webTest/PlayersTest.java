package com.slotegrator.webTest;

import io.cucumber.junit.platform.engine.Cucumber;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

@Cucumber
public class PlayersTest extends BaseTest {

    @Description("Тест на провекру списка игроков")
    @Test
    public void playersListTes() {
        driver.get("http://test-app.d6.dev.devcaz.com/admin/login/");
        loginPage.login(userName, password);
        mainPage.navigationDisplay();
        mainPage.openPlayersList();
        playersDashboardElement.checkPlayersTableDisplayed();
        playersDashboardElement.sortedByRegistrationDate();
        playersDashboardElement.checkSortedPlayers();
    }
}