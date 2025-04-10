package GeneralProblems.Pratice.HashSet;

import java.util.Objects;

public class Address {
    private final int doorNo;
    private final String streetName;
    private final String country;
    private final String state;
    private final int pinCode;

    public Address(String country, int doorNo, int pinCode, String state, String streetName) {
        this.country = country;
        this.doorNo = doorNo;
        this.pinCode = pinCode;
        this.state = state;
        this.streetName = streetName;
    }

    public String getCountry() {
        return country;
    }

    public int getDoorNo() {
        return doorNo;
    }

    public int getPinCode() {
        return pinCode;
    }

    public String getState() {
        return state;
    }

    public String getStreetName() {
        return streetName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return doorNo == address.doorNo && pinCode == address.pinCode && Objects.equals(streetName, address.streetName) && Objects.equals(country, address.country) && Objects.equals(state, address.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doorNo, streetName, country, state, pinCode);
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", doorNo=" + doorNo +
                ", streetName='" + streetName + '\'' +
                ", state='" + state + '\'' +
                ", pinCode=" + pinCode +
                '}';
    }
}
