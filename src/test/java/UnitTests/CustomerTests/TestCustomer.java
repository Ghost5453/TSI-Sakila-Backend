package UnitTests.CustomerTests;

import SakilaAPI.CustomerComponents.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCustomer {

    private Customer testCustomer = new Customer(
            6,
            3,
            "TEST",
            "TESTSON",
            "TEST.TESTSON@fakemail.com",
            4,
            true
    );

    private Customer testBlackCustomer = new Customer();

    //region Get Tests
    @Test
    public void testGetID()
    {
        Assertions.assertEquals(6, testCustomer.getCustomerID(), "Couldn't get customer ID");
    }

    @Test
    public void testGetBlankCustomerID()
    {
        Assertions.assertEquals(0, testBlackCustomer.getCustomerID(), "Error with blanSk customer ID");
    }

    @Test
    public void testGetStoreID()
    {
        Assertions.assertEquals(3, testCustomer.getStoreIDFromCustomer(), "Couldn't get store ID");
    }

    @Test
    public void testGetFName()
    {
        Assertions.assertEquals("TEST", testCustomer.getCustomerFirstName(), "Couldn't get first name");
    }

    @Test
    public void testGetLName()
    {
        Assertions.assertEquals("TESTSON", testCustomer.getCustomerLastName(), "Couldn't get last name");
    }

    @Test
    public void testGetEmail()
    {
        Assertions.assertEquals("TEST.TESTSON@fakemail.com", testCustomer.getCustomerEmail(), "Couldn't get email");
    }

    @Test
    public void testGetAddressID()
    {
        Assertions.assertEquals(4, testCustomer.getAddressIDFromCustomer(), "Couldn't get address ID");
    }

    @Test
    public void testGetActive()
    {
        Assertions.assertTrue(testCustomer.getIsCustomerActive(), "Couldn't get is customer active");
    }

    @Test
    public void testGetIsBlankCusterActive()
    {
        Assertions.assertFalse(testBlackCustomer.getIsCustomerActive(), "Error with blank active customer");
    }
    //endregion

    //region Set Tests
    @Test
    public void testSetID()
    {
        testCustomer.setCustomerID(78);
        Assertions.assertEquals(78, testCustomer.getCustomerID(), "Couldn't set customer ID");
    }

    @Test
    public void testSetBlankCustomerID()
    {
        testBlackCustomer.setCustomerID(95);
        Assertions.assertEquals(95, testBlackCustomer.getCustomerID(), "Error with set blank customer ID");
    }

    @Test
    public void testSetStoreID()
    {
        testCustomer.setStoreIDFromCustomer(9);
        Assertions.assertEquals(9, testCustomer.getStoreIDFromCustomer(), "Couldn't set store ID");
    }

    @Test
    public void testSetFName()
    {
        testCustomer.setCustomerFirstName("NEW");
        Assertions.assertEquals("NEW", testCustomer.getCustomerFirstName(), "Couldn't set first name");
    }

    @Test
    public void testSetLName()
    {
        testCustomer.setCustomerLastName("NAME");
        Assertions.assertEquals("NAME", testCustomer.getCustomerLastName(), "Couldn't set last name");
    }

    @Test
    public void testSetEmail()
    {
        testCustomer.setCustomerEmail("NEW.NAME@fakemail.com");
        Assertions.assertEquals("NEW.NAME@fakemail.com", testCustomer.getCustomerEmail(), "Couldn't set email");
    }

    @Test
    public void testSetAddressID()
    {
        testCustomer.setAddressIDFromCustomer(9);
        Assertions.assertEquals(9, testCustomer.getAddressIDFromCustomer(), "Couldn't set address ID");
    }

    @Test
    public void testSetActive()
    {
        testCustomer.setCustomerIsActive(false);
        Assertions.assertFalse(testCustomer.getIsCustomerActive(), "Couldn't set is customer active");
    }
    //endregion
}
