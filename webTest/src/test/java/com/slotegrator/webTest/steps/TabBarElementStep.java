package com.slotegrator.webTest.steps;

import com.slotegrator.webTest.pages.TabBarElement;
import cucumber.api.java.en.And;

public class TabBarElementStep {

    private TabBarElement tabBarElementStep;

    public TabBarElementStep() {
        this.tabBarElementStep = new TabBarElement();
    }

    @And("Check page is loading")
    public void navigationDisplay() {
        this.tabBarElementStep.navigationDisplay();
    }

    @And("Open players list")
    public void openPlayersList() {
        this.tabBarElementStep.openPlayersList();
    }
}
