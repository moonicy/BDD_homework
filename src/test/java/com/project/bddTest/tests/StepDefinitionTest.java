package com.project.bddTest.tests;

import com.project.bddTest.config.SpringIntegrationTest;
import com.project.bddTest.pageObjects.MainPageObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

@Slf4j
public class StepDefinitionTest extends SpringIntegrationTest {
    @Autowired
    private WebDriver driver;
    @Autowired
    private MainPageObject mainPageObject;

    private boolean hasLogo;

    @Given("^open main page$")
    public void open_main_page() {
        mainPageObject.openMainPage();
    }

    @When("^find logo on main page$")
    public void find_logo_on_main_page() {
        hasLogo = mainPageObject.mainLogoExists();
    }

    @Then("^main page has logo$")
    public void main_page_has_logo() {
        assertTrue(hasLogo);
    }

    @When("^click on auth button$")
    public void click_on_auth_button() {
        mainPageObject.openSignInPopup();
    }

    @Then("^opened signIn and signUp modal window$")
    public void opened_singin_modal_window() {
        assertNotNull(mainPageObject.getModalAuthAndReg());
    }

    @When("^input email for subscribe$")
    public void input_email_for_subscribe() {
        mainPageObject.getInputSubscribe().sendKeys("testmail@mail.ru");
    }

    @When("^click on subscribe button$")
    public void click_on_subscribe_button() {
        mainPageObject.getButtonSubscribe().click();
    }

    @Then("^view text success subscribe$")
    public void view_text_success_subscribe() {
        assertEquals("Вы успешно подписались", mainPageObject.getModalSuccessSubscribe().getText());
    }

    @Then("^check (facebook|vkontakte|Zen|OK|youtube) social icon$")
    public void check_social_icon(String socialIconType) {
        switch (socialIconType) {
            case "facebook":
                assertNotNull(mainPageObject.getIconFB());
            case "vkontakte":
                assertNotNull(mainPageObject.getIconVK());
            case "Zen":
                assertNotNull(mainPageObject.getIconZen());
            case "OK":
                assertNotNull(mainPageObject.getIconOK());
            case "youtube":
                assertNotNull(mainPageObject.getIconYT());
        }
    }

    @When("^click on support widget button$")
    public void click_on_support_widget_button() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(mainPageObject.getSupportWidgetButton()));
        mainPageObject.getSupportWidgetButton().click();
    }

    @Then("^opened support widget modal$")
    public void opened_support_widget_modal() {
        assertNotNull(mainPageObject.getSupportWidgetModal());
    }

    @When("^cursor move to notification icon$")
    public void cursor_move_to_notification_icon() {
        Actions actions = new Actions(driver);
        actions.moveToElement(mainPageObject.getIconNotification()).build().perform();
    }

    @Then("^opened notifications dropdown$")
    public void opened_notifications_dropdown() {
        assertNotNull(mainPageObject.getNotificationsDropdown());
    }
}
