package repositories.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderItemId implements Serializable {

    private static final long serialVersionUID = -5879089085305844616L;

    @Column(name = "ORDER_ID")
    private Long orderId;

    @Column(name = "ITEM_ID")
    private Long itemId;

    @Column(name = "ITEM_SIZE")
    private String itemSize;

    public OrderItemId() {
    }

    public OrderItemId(Long orderId, Long itemId, String itemSize) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.itemSize = itemSize;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemSize() {
        return itemSize;
    }

    public void setItemSize(String itemSize) {
        this.itemSize = itemSize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, itemId, itemSize);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        OrderItemId that = (OrderItemId) o;
        return Objects.equals(orderId, that.orderId) &&
                Objects.equals(itemId, that.itemId) &&
                Objects.equals(itemSize, that.itemSize);
    }
}
