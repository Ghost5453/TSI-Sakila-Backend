package ApiComponents.Sakila.Project;

import javax.persistence.*;

@Entity
@Table(name="address")
public class Address {

    //region Attributes


    @Id
    @Column(name="address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int addressID;

    @Column(name="address")
    String address;

    @Column(name="district")
    String addressDistrict;

    @Column(name="city_id")
    int cityIdFromAddress;

    @Column(name="postal_code")
    String postCode;

    @Column(name="phone")
    String phoneNumber;

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
