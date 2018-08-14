package repositories.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

import static constants.Constants.SCHEMA_NAME;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "ITEMS", schema = SCHEMA_NAME)
public class Item implements Serializable {

    private static final long serialVersionUID = 3728606069464237513L;


    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "S_PRICE")
    private Float sPrice;

    @Column(name = "M_PRICE")
    private Float mPrice;

    @Column(name = "L_PRICE")
    private Float lPrice;

    @Column(name = "URL")
    private String url;


    @JsonIgnore
    @OneToMany(mappedBy = "itemAssociation", cascade = ALL, orphanRemoval = true)
    private Collection<OrderItem> orders;


    public Item() {
    }

    public Item(String name, Float sPrice, Float mPrice, Float lPrice, String url) {
        this.name = name;
        this.sPrice = sPrice;
        this.mPrice = mPrice;
        this.lPrice = lPrice;
        this.url = url;
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

    public Float getsPrice() {
        return sPrice;
    }

    public void setsPrice(Float sPrice) {
        this.sPrice = sPrice;
    }

    public Float getmPrice() {
        return mPrice;
    }

    public void setmPrice(Float mPrice) {
        this.mPrice = mPrice;
    }

    public Float getlPrice() {
        return lPrice;
    }

    public void setlPrice(Float lPrice) {
        this.lPrice = lPrice;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Collection<OrderItem> getOrders() {
        return orders;
    }

    public void setOrders(Collection<OrderItem> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
