package SakilaAPI.AddressComponents;

public class AddressModdle {

    //region Attributes
    private int addressID;
    private String address;
    private String addressDistrict;
    private int cityIdFromAddress;
    private String postCode;
    private String phoneNumber;
    //endregion

    //region Attributes

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
    
    //endregion
}
