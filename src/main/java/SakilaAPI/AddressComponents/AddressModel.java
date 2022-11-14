package SakilaAPI.AddressComponents;

import javax.persistence.Column;

public class AddressModel {

    private int addressID;
    private String address;
    private String addressDistrict;
    private int cityIdFromAddress;
    private String postCode;
    private String phoneNumber;

    public int getAddressID() {
        return addressID;
    }

    public String getAddress() {
        return address;
    }

    public String getAddressDistrict() {
        return addressDistrict;
    }

    public int getCityIdFromAddress() {
        return cityIdFromAddress;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
