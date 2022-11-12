package UnitTests.AddressTests;

import SakilaAPI.AddressComponents.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestAddress {
    private Address testAddress = new Address(
            40,
            "30 MySakila Street",
            "QLD",
            20,
            "394000",
            "6571389258"
    );

    private Address testBlankAddress = new Address();

    //region Get Tests
    @Test
    public void testGetID()
    {
        Assertions.assertEquals(40, testAddress.getAddressID(), "Couldn't get address ID");
    }

    @Test
    public void testBlankGetID()
    {
        Assertions.assertEquals(0, testBlankAddress.getAddressID(), "Couldn't get blank ID");
    }

    @Test
    public void testGetAddress()
    {
        Assertions.assertEquals("30 MySakila Street", testAddress.getAddress(), "Couldn't get address");
    }

    @Test
    public void testGetDistrict()
    {
        Assertions.assertEquals("QLD", testAddress.getAddressDistrict(), "Couldn't get address district");
    }

    @Test
    public void testGetCityID()
    {
        Assertions.assertEquals(20, testAddress.getCityIdFromAddress(), "Couldn't get address city ID");
    }

    @Test
    public void testGetPostCode()
    {
        Assertions.assertEquals("394000", testAddress.getPostCode(), "Couldn't get postcode");
    }

    @Test
    public void testGetPhoneNumber()
    {
        Assertions.assertEquals("6571389258", testAddress.getPhoneNumber(), "Couldn't get phone number");
    }
    //endregion

    //region Set Tests
    @Test
    public void testSetID()
    {
        testAddress.setAddressID(30);
        Assertions.assertEquals(30, testAddress.getAddressID(), "Couldn't set address ID");
    }

    @Test
    public void testBlankSetID()
    {
        testBlankAddress.setAddressID(35);
        Assertions.assertEquals(35, testBlankAddress.getAddressID(), "Couldn't set blank ID");
    }

    @Test
    public void testSetAddress()
    {
        testAddress.setAddress("30 MySakila Lane");
        Assertions.assertEquals("30 MySakila Lane", testAddress.getAddress(), "Couldn't set address");
    }

    @Test
    public void testSetDistrict()
    {
        testAddress.setAddressDistrict("Alberta");
        Assertions.assertEquals("Alberta", testAddress.getAddressDistrict(), "Couldn't set address district");
    }

    @Test
    public void testSetCityID()
    {
        testAddress.setCityIdFromAddress(36);
        Assertions.assertEquals(36, testAddress.getCityIdFromAddress(), "Couldn't set address city ID");
    }

    @Test
    public void testSetPostCode()
    {
        testAddress.setPostCode("857497");
        Assertions.assertEquals("857497", testAddress.getPostCode(), "Couldn't set postcode");
    }

    @Test
    public void testSetPhoneNumber()
    {
        testAddress.setPhoneNumber("1587285743");
        Assertions.assertEquals("1587285743", testAddress.getPhoneNumber(), "Couldn't set phone number");
    }

    //endregion
}
