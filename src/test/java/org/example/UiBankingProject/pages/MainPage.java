package org.example.UiBankingProject.pages;

import org.example.utils.AllureLogger;
import org.example.utils.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

public class MainPage {

    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(MainPage.class));

    WebDriver driver;

    @FindBy(css = "button[ng-class='btnClass1']")
    private WebElement addCustomerButton;

    @FindBy(css = "button[ng-class='btnClass3']")
    private WebElement customersButton;

    public void clickAddCustomerButton() {
        addCustomerButton.click();
        LOG.info("Click on the Add Customer button");
    }

    public void clickCustomersButton() {
        Wait.myWait(5).clickable(customersButton);
        customersButton.click();
        LOG.info("Click on the Customer button");
    }

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}