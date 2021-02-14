package com.project.bddTest.pageObjects;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MainPageObject {
    private boolean isInit = false;

    @Autowired
    private WebDriver driver;

    @FindBy(className = "header2__logo")
    private WebElement mainLogo;

    @FindBy(className = "header2__auth")
    private WebElement buttonAuthAndReg;

    @FindBy(className = "new-log-reg-container")
    private WebElement modalAuthAndReg;

    @FindBy(className = "footer2__subscribe-input")
    private WebElement inputSubscribe;

    @FindBy(className = "footer2__subscribe-button")
    private WebElement buttonSubscribe;

    @FindBy(className = "subscribe-modal__success")
    private WebElement modalSuccessSubscribe;

    @FindBy(className = "ic-fb-footer2")
    private WebElement iconFB;

    @FindBy(className = "ic-vk-footer2")
    private WebElement iconVK;

    @FindBy(className = "ic-zen")
    private WebElement iconZen;

    @FindBy(className = "ic-ok-footer2")
    private WebElement iconOK;

    @FindBy(className = "ic-yt-footer2")
    private WebElement iconYT;

    @FindBy(xpath = "//jdiv [@id = \"jvlabelWrap\"]")
    private WebElement supportWidgetButton;

    @FindBy(className = "contentWrapper_f036")
    private WebElement supportWidgetModal;

    @FindBy(className = "header2_subheader-notification")
    private WebElement iconNotification;

    @FindBy(className = "notifications-dropdown")
    private WebElement notificationsDropdown;

    public WebElement getIconNotification() {
        return iconNotification;
    }

    public WebElement getNotificationsDropdown() {
        return notificationsDropdown;
    }

    public void openSignInPopup() {
        buttonAuthAndReg.click();
    }

    public MainPageObject openMainPage() {
        log.info("driver = " + String.valueOf(driver == null));
        driver.get("https://otus.ru/");
        log.info("Open main page");
        if (!isInit) {
            PageFactory.initElements(driver, this);
            isInit = true;
        }
        return this;
    }

    public boolean mainLogoExists() {
        return mainLogo != null;
    }

    public WebElement getModalAuthAndReg() {
        return modalAuthAndReg;
    }

    public WebElement getInputSubscribe() {
        return inputSubscribe;
    }

    public WebElement getButtonSubscribe() {
        return buttonSubscribe;
    }

    public WebElement getModalSuccessSubscribe() {
        return modalSuccessSubscribe;
    }

    public WebElement getIconFB() {
        return iconFB;
    }

    public WebElement getIconVK() {
        return iconVK;
    }

    public WebElement getIconZen() {
        return iconZen;
    }

    public WebElement getIconOK() {
        return iconOK;
    }

    public WebElement getIconYT() {
        return iconYT;
    }

    public WebElement getSupportWidgetButton() {
        return supportWidgetButton;
    }

    public WebElement getSupportWidgetModal() {
        return supportWidgetModal;
    }
}
