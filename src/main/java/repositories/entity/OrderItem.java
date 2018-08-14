package repositories.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.util.Objects;

import static constants.Constants.SCHEMA_NAME;

@Entity
@Table(name = "ORDERS_ITEMS", schema = SCHEMA_NAME)
public class OrderItem {

    @EmbeddedId
    private OrderItemId id;

    @Column(name = "QUANTITY")
    private Integer quantity;


    @ManyToOne
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @JsonIgnore
    private Order orderAssociation;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @JsonIgnore
    private Item itemAssociation;

    public OrderItem() {
    }

    public OrderItem(OrderItemId id, Integer quantity, Order orderAssociation, Item itemAssociation) {
        this.id = id;
        this.quantity = quantity;
        this.orderAssociation = orderAssociation;
        this.itemAssociation = itemAssociation;
    }

    public OrderItemId getId() {
        return id;
    }

    public void setId(OrderItemId id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Order getOrderAssociation() {
        return orderAssociation;
    }

    public void setOrderAssociation(Order order) {
        this.orderAssociation = order;
    }

    public Item getItemAssociation() {
        return itemAssociation;
    }

    public void setItemAssociation(Item item) {
        this.itemAssociation = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        OrderItem that = (OrderItem) o;
        return Objects.equals(orderAssociation, that.orderAssociation) &&
                Objects.equals(itemAssociation, that.itemAssociation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderAssociation, itemAssociation);
    }

}
