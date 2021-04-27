package AddressBook;

/**
 * AddressBook Project 4 Qi Wang
 * @author John Koch
 * @Version 2.0
 */


public class Contact implements Comparable<Contact> {

    private String name, phone;
    private Address address;
    public Contact() {}

    public Contact(String name, String phone, Address address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure
     * {@code sgn(x.compareTo(y)) == -sgn(y.compareTo(x))}
     * for all {@code x} and {@code y}.  (This
     * implies that {@code x.compareTo(y)} must throw an exception iff
     * {@code y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
     * {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code x.compareTo(y)==0}
     * implies that {@code sgn(x.compareTo(z)) == sgn(y.compareTo(z))}, for
     * all {@code z}.
     *
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
     * class that implements the {@code Comparable} interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     *
     * <p>In the foregoing description, the notation
     * {@code sgn(}<i>expression</i>{@code )} designates the mathematical
     * <i>signum</i> function, which is defined to return one of {@code -1},
     * {@code 0}, or {@code 1} according to whether the value of
     * <i>expression</i> is negative, zero, or positive, respectively.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(Contact o) {
        /*
        Roe Is a int value for getting a comparison of the two Names
         */
       /**
        * This algorithm goes letter by letter and 
        */
    	char[] thisLetters = this.name.toCharArray();
    	char[] thatLetters = o.name.toCharArray();
    	int i = 0;
    	while(thisLetters.length > i && thatLetters.length > i)
    	{
        int roe = Character.compare(thisLetters[i], thatLetters[i]);
        	if(roe > 0)
        	{
        		return 1;
        	}
        	else if(roe < 0)
        	{
        		return -1;
        	}
        	else {
        		//go to the next letter
        	}
            i++;
    	}
    	if(thisLetters.length>thatLetters.length)
    		return 1;
    	else if(thisLetters.length<thatLetters.length)
    		return -1;
    	
    	return 0;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address=" + address.toString() +
                '}';
    }
}
