package SakilaAPI.CustomerComponents;

import javax.persistence.*;
import java.security.PublicKey;

@Entity
@Table(name = "customer")
public class Customer {
    //region Attributes
    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerID;

    @Column(name = "store_id")
    private int storeIDFromCustomer;

    @Column(name = "first_name")
    private String customerFirstName;

    @Column(name = "last_name")
    private String customerLastName;

    @Column(name = "email")
    private String customerEmail;

    @Column(name = "address_id")
    private int addressIDFromCustomer;

    @Column(name = "active")
    private boolean customerIsActive;
    //endregion

    //region Constructors
    public Customer(int myID, int myStoreID, String myFirstName, String myLastName, String myEmail, int myAddressID, boolean myIsActive)
    {
        customerID = myID;
        storeIDFromCustomer = myStoreID;
        customerFirstName = myFirstName;
        customerLastName = myLastName;
        customerEmail = myEmail;
        addressIDFromCustomer = myAddressID;
        customerIsActive = myIsActive;
    }

    public Customer()
    {

    }
    //endregion

    //region Methods
    //region Getters
    public int getCustomerID()
    {
        return customerID;
    }

    public int getStoreIDFromCustomer()
    {
        return storeIDFromCustomer;
    }

    public String getCustomerFirstName()
    {
        return customerFirstName;
    }

    public String getCustomerLastName()
    {
        return customerLastName;
    }

    public String getCustomerEmail()
    {
        return customerEmail;
    }

    public int getAddressIDFromCustomer()
    {
        return addressIDFromCustomer;
    }

    public boolean isCustomerIsActive()
    {
        return customerIsActive;
    }
    //endregion

    //region Setters
    public void setCustomerID(int customerID)
    {
        this.customerID = customerID;
    }

    public void setStoreIDFromCustomer(int storeIDFromCustomer)
    {
        this.storeIDFromCustomer = storeIDFromCustomer;
    }

    public void setCustomerFirstName(String customerFirstName)
    {
        this.customerFirstName = customerFirstName;
    }

    public void setCustomerLastName(String customerLastName)
    {
        this.customerLastName = customerLastName;
    }

    public void setCustomerEmail(String customerEmail)
    {
        this.customerEmail = customerEmail;
    }

    public void setAddressIDFromCustomer(int addressIDFromCustomer)
    {
        this.addressIDFromCustomer = addressIDFromCustomer;
    }

    public void setCustomerIsActive(boolean customerIsActive)
    {
        this.customerIsActive = customerIsActive;
    }
    //endregion
    //endregion
}
