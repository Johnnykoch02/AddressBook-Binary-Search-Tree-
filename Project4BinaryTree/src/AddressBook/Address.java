package AddressBook;

/**
 * AddressBook Project 4 Qi Wang
 * @author John Koch
 * @Version 2.0 
 */

public class Address {

	/**
	 * Components of Address
	 */
    private String street, city, state, zipcode;

    /**
     * Blank Address Constructor 
     */
    public  Address() {}

    /**
     * Default Address Constructor
     * @param street is reference to Street 
     * @param city is reference to City 
     * @param state is reference to State
     * @param Zipcode is reference to Zipcode
     */
    public Address(String street, String city, String state, String Zipcode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = Zipcode;
    }
    /**
     * Getter for Street Value
     * @return Street Value
     */
    public String getStreet() {
        return street;
    }

    /**
     * Setter for Street Value
     * @param street value
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Getter for Street Value
     * @return Street Value
     */
    public String getCity() {
        return city;
    }
    /**
    * Setter for City Value
    * @return City Value
    */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Getter for State Value
     * @return State Value
     */
    public String getState() {
        return state;
    }

    /**
     * Setter for State Value
     * @param state value
     */
    public void setState(String state) {
        this.state = state;
    }
    
    /**
     * Getter for ZipCode Value
     * @return Zipcode Value
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * Setter for ZipCode Value
     * @param zipcode value
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * Override toString Method for Address Class
     */
    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}
