package com.slotegrator.webTest;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

public class PlayersTest extends BaseTest {

    private static final String userName = "admin1";
    private static final String password = "[9k<k8^z!+$$GkuP";

    @Description("Тест на провекру списка игроков")
    @Test
    public void playersListTes() {
        driver.get("http://test-app.d6.dev.devcaz.com/admin/login/");
        loginPage.login(userName, password);
    }
}