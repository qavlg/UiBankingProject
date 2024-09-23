package org.example.UiBankingProject.tests;

import org.example.utils.Extension;
import org.example.UiBankingProject.pages.AddCustomerPage;
import org.example.UiBankingProject.pages.CustomerPage;
import org.example.UiBankingProject.pages.MainPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(Extension.class)

public class AddCustomerTest extends BaseTest {

    AddCustomerPage acp;
    MainPage mp;
    CustomerPage cp;

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        getDriver().get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
        mp = new MainPage(getDriver());
        mp.clickAddCustomerButton();

        acp = new AddCustomerPage(getDriver());
        cp = new CustomerPage(getDriver());
    }

    @Test
    @DisplayName("#1. Customer will be added successfully after entering the valid data into the fields in 'Add Customer' form  ")
    public void addCustomer() {
        String lastName = "Valada";
        String customer = "Valada";

        acp.generateAndInputFullName();
        acp.inputTextIntoLastNameField(lastName);
        acp.generateAndInputPostCode();
        acp.clickAddCustomerButton();

        mp.clickCustomersButton();
        cp.inputTextIntoSearchCustomerField(customer);

        assertEquals(lastName, cp.getCustomer(),
                "The text has not been deleted");
    }
}