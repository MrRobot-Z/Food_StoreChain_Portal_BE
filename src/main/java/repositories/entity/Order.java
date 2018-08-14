package repositories.entity;


import javax.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

import static constants.Constants.SCHEMA_NAME;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "ORDERS", schema = SCHEMA_NAME)
public class Order implements Serializable {

    private static final long serialVersionUID = -8391402750642850055L;


    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "TOTAL_PRICE")
    private Float price;

    @Column(name = "ORDER_DATE")
    private Timestamp timestamp;


    @OneToMany(mappedBy = "orderAssociation", cascade = ALL, orphanRemoval = true)
    private Collection<OrderItem> items;


    public Order() {
    }

    public Order(Float price, Timestamp timestamp) {
        this.price = price;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Collection<OrderItem> getItems() {
        return items;
    }

    public void setItems(Collection<OrderItem> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
