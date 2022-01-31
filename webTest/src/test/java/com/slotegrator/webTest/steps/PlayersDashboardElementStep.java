package com.slotegrator.webTest.steps;

import com.slotegrator.webTest.pages.PlayersDashboardElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class PlayersDashboardElementStep {

    private PlayersDashboardElement playersDashboardElement;

    public PlayersDashboardElementStep() {
        this.playersDashboardElement =
                new PlayersDashboardElement();
    }

    @And("Check players table displayed")
    public void checkPlayersTableDisplayed() {
        playersDashboardElement.checkPlayersTableDisplayed();
    }

    @And("Sorted players by registration date")
    public void sortedByRegistrationDate() {
        playersDashboardElement.sortedByRegistrationDate();
    }

    @Then("Check sorted players")
    public void checkSortedPlayers() {
        playersDashboardElement.checkSortedPlayers();
    }
}
