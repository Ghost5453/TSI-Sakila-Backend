package SakilaAPI.CustomerComponents;

public class CustomerModel {
    //region Attributes
    private int customerID;
    private int storeIDFromCustomer;
    private String customerFirstName;
    private String customerLastName;
    private String customerEmail;
    private int addressIDFromCustomer;
    private boolean customerIsActive;
    //endregion

    //region Methods
    public int getCustomerID() {
        return customerID;
    }

    public int getStoreIDFromCustomer() {
        return storeIDFromCustomer;
    }

    public int getAddressIDFromCustomer() {
        return addressIDFromCustomer;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public boolean getIsCusterActive() {
        return customerIsActive;
    }
    //endregion
}
