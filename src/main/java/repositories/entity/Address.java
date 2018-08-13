package repositories.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;


import java.io.Serializable;
import java.util.Objects;

import static constants.Constants.SCHEMA_NAME;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "ADDRESSES", schema = SCHEMA_NAME)
public class Address implements Serializable {

    private static final long serialVersionUID = -2962717198146426182L;


    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STREET_ADDRESS")
    private String streetAddress;


    public Address() {
    }

    public Address(String country, String city, String streetAddress) {
        this.country = country;
        this.city = city;
        this.streetAddress = streetAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
