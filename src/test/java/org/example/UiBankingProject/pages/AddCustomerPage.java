package org.example.UiBankingProject.pages;

import org.example.utils.AllureLogger;
import org.example.utils.Wait;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

public class AddCustomerPage {
    private static WebDriver driver;
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(org.example.UiBankingProject.pages.MainPage.class));


    @FindBy(xpath = "//input[@ng-model='fName']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@ng-model='lName']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@ng-model='postCd']")
    private WebElement postCodeField;

    @FindBy(css = "button[class='btn btn-default']")
    private WebElement addCustomerButton;

    private String generatePostCode() {
        StringBuilder postcode = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int randomNumber = (int) (Math.random() * 10);
            if (randomNumber < 0 || randomNumber > 9) {
                continue;
            }
            postcode.append(randomNumber);
        }
        return postcode.toString();
    }

    public void inputTextIntoPostCodeField(String postcode) {
        postCodeField.sendKeys(postcode);
        LOG.info("Enter text into the Post Code field");
    }

    public void generateAndInputPostCode() {
        String generatedPostcode = generatePostCode();
        inputTextIntoPostCodeField(generatedPostcode);
    }

    private String generateFullNameFromPostCode(String postcode) {
        StringBuilder fullname = new StringBuilder();
        for (char c : postcode.toCharArray()) {
            int value = Character.getNumericValue(c);
            if (value > 25) {
                value -= 26;
            }
            fullname.append((char) ('a' + value));
        }
        return fullname.toString();
    }

    public void inputTextIntoFirstNameField(String fullname) {
        firstNameField.sendKeys(fullname);
        LOG.info("Enter text into the Full Name field");
    }

    public void generateAndInputFullName() {
        String generatedFullname = generateFullNameFromPostCode(generatePostCode());
        inputTextIntoFirstNameField(generatedFullname);
    }

    public void inputTextIntoLastNameField(String lastName) {
        lastNameField.sendKeys(lastName);
        LOG.info("Enter the text into the Last Name field");
    }

    public void clickAddCustomerButton() {
        Wait.myWait(5).clickable(addCustomerButton);
        addCustomerButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        LOG.info("Click on the Add Customer button");
    }

    public AddCustomerPage(WebDriver driver) {
        AddCustomerPage.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
