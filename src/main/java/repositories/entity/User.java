package repositories.entity;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

import static constants.Constants.SCHEMA_NAME;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "USERS", schema = SCHEMA_NAME)
public class User implements Serializable {

    private static final long serialVersionUID = 5498203776487471985L;


    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ROLE")
    private String role;

    @JoinColumn(name = "USER_ID")
    @OneToMany(fetch = LAZY, cascade = ALL)
    private Collection<Address> addresses;

    @JoinColumn(name = "USER_ID")
    @OneToMany(fetch = LAZY, cascade = ALL)
    private Collection<Feedback> feedbacks;

    @JoinColumn(name = "USER_ID")
    @OneToMany(fetch = LAZY, cascade = ALL)
    private Collection<Order> orders;

    public User() {
    }

    public User(String name, String email, String password, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Collection<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Collection<Address> addresses) {
        this.addresses = addresses;
    }

    public Collection<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(Collection<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public Collection<Order> getOrders() {
        return orders;
    }

    public void setOrders(Collection<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return name + " " + id;
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj)
            return false;
        if (!(obj instanceof User))
            return false;
        User that = (User) obj;
        return that.email.equals(this.email) && that.id.equals(this.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
