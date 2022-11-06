package SakilaAPI.AddressComponents;

import javax.persistence.*;

@Entity
@Table(name="address")
public class Address {

    //region Attributes


    @Id
    @Column(name="address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressID;

    @Column(name="address")
    private String address;

    @Column(name="district")
    private String addressDistrict;

    @Column(name="city_id")
    private int cityIdFromAddress;

    @Column(name="postal_code")
    private String postCode;

    @Column(name="phone")
    private String phoneNumber;

    //TODO Work out how to store blobs for Column(name="location")

    //endregion

    //region Constructors

    public Address(int myID, String myAddress, String myAddressDistrict, int myCityID, String myPostCode, String myPhoneNumber)
    {
        this.addressID = myID;
        this.address = myAddress;
        this.addressDistrict = myAddressDistrict;
        this.cityIdFromAddress = myCityID;
        this.postCode = myPostCode;
        this.phoneNumber = myPhoneNumber;

    }

    public Address()
    {

    }

    //endregion

    //region Methods

    public void setAll(int myID, String myAddress, String myAddressDistrict, int myCityID, String myPostCode, String myPhoneNumber)
    {
        addressID = myID;
        address = myAddress;
        addressDistrict = myAddressDistrict;
        cityIdFromAddress = myCityID;
        postCode = myPostCode;
        phoneNumber = myPhoneNumber;
    }

    //region Getters

    public int getAddressID()
    {
        return addressID;
    }

    public String getAddress()
    {
        return address;
    }

    public String getAddressDistrict()
    {
        return addressDistrict;
    }

    public int getCityIdFromAddress()
    {
        return cityIdFromAddress;
    }

    public String getPostCode()
    {
        return postCode;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    //endregion

    //region Setters

    public void setAddressID(int myID)
    {
        addressID = myID;
    }

    public void setAddress(String myAddress)
    {
        address = myAddress;
    }

    public void setAddressDistrict(String myAddressDistrict)
    {
        addressDistrict = myAddressDistrict;
    }

    public void setCityIdFromAddress(int myCityID)
    {
        cityIdFromAddress = myCityID;
    }

    public void setPostCode(String myPostCode)
    {
        postCode = myPostCode;
    }

    public void  setPhoneNumber(String myPhoneNumber)
    {
        phoneNumber = myPhoneNumber;
    }


    //endregion
    //endregion

}
