package org.example.UiBankingProject.pages;

import org.example.utils.AllureLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerPage {

    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(org.example.UiBankingProject.pages.MainPage.class));

    WebDriver driver;

    @FindBy(xpath = "//td[1]/a[@href='#']")
    private WebElement firstNameElement;

    @FindBy(xpath = "//input[@ng-model='searchCustomer']")
    private WebElement searchCustomerField;

    @FindBy(xpath = "//tr[@class='ng-scope']")
    private List<WebElement> rows;

    @FindBy(xpath = "//tr/td[contains(text(),'Valada')]")
    private WebElement lastNameColum;

    @FindBy(xpath = "//td[@class='ng-binding']")
    private List<WebElement> columns;

    public List<String> getCustomerNames() {
        LOG.info("Get the customer's list names");
        return rows.stream()
                .map(row -> row.findElements(By.xpath("//td[@class='ng-binding']")).get(0).getText())
                .collect(Collectors.toList());
    }

    public void deleteCustomer(String name) {

        for (WebElement row : rows) {
            String customerName = columns.get(0).getText();
            if (customerName.equals(name)) {
                WebElement deleteButton = columns.get(4).findElement(By.xpath("//button[@ng-click='deleteCust(cust)']"));
                deleteButton.click();
                LOG.info("Delete the customer with the average length of his name");
                break;
            }
        }
    }

    public void clickFirstNameElement() {
        firstNameElement.click();
        LOG.info("Click on the First Name element");
    }

    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.xpath("//td[@class='ng-binding']"));
            if (!cells.isEmpty()) {
                names.add(cells.get(0).getText());
            }
        }
        return names;
    }

    public void inputTextIntoSearchCustomerField(String customer) {
        searchCustomerField.sendKeys(customer);
        LOG.info("Enter text into the Last Name field");
    }

    public String getCustomer() {
        LOG.infoWithScreenshot("Check if the customer has been added");
        return lastNameColum.getText();
    }

    public CustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}