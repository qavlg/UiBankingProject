package org.example.UiBankingProject.tests;

import org.example.utils.Extension;
import org.example.UiBankingProject.pages.CustomerPage;
import org.example.UiBankingProject.pages.MainPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(Extension.class)

public class CustomerTest extends org.example.UiBankingProject.tests.BaseTest {

    MainPage mp;
    CustomerPage cp;

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        getDriver().get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
        mp = new MainPage(getDriver());
        mp.clickCustomersButton();

        cp = new CustomerPage(getDriver());
    }

    @Test
    @DisplayName("#2. It is possible to sort the customers by First name")
    public void addCustomer() {

        cp.clickFirstNameElement();

        List<String> names = cp.getNames();
        List<String> sortedNames = new ArrayList<>(names);
        Collections.sort(sortedNames);

        LOG.infoWithScreenshot("Check if the customers have been sorted correctly");
        assertEquals(sortedNames, names, "The customers have not been correctly");
    }

    @Test
    @DisplayName("#3. Deleting the customer with the average length of a name in the table")
    public void deleteCustomer() {

        List<String> names = cp.getCustomerNames();

        double averageLength = names.stream()
                .mapToInt(String::length)
                .average()
                .orElse(0.0);

        LOG.info("Find the average length of a name");
        String closestName = names.stream()
                .min((name1, name2) -> {
                    double diff1 = Math.abs(name1.length() - averageLength);
                    double diff2 = Math.abs(name2.length() - averageLength);
                    return Double.compare(diff1, diff2);
                }).orElse(null);

        assertNotNull(closestName, "The name has not been found");
        cp.deleteCustomer(closestName);
        LOG.infoWithScreenshot("Check if the the customer with the arithmetic mean name has been deleted");
    }
}