package com.shop.fuelcoupons.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_details")
public class OrderDetail extends AbstractBaseEntity {

    @Column(name = "amount", nullable = false)
    @NotNull
    @Digits(integer=20, fraction=2)
    private BigDecimal amount = new BigDecimal(0.00).setScale(2, BigDecimal.ROUND_HALF_UP);

    @Column(name = "fuel_name", nullable = false)
    @NotBlank
    @Size(min = 2, max = 120)
    private String fuelName;

    @Column(name = "quantity", nullable = false)
    @Range(min = 10, max = 5000)
    private int quantity;

    @Column(name = "order_address", nullable = false)
    @Size(min = 2, max = 120)
    private String orderAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Order order;

    public OrderDetail() {
    }

    public OrderDetail(BigDecimal amount, String fuelName, int quantity,  String orderAddress) {
        this.amount = amount;
        this.fuelName = fuelName;
        this.quantity = quantity;
        this.orderAddress = orderAddress;
    }

    public OrderDetail(Integer id, BigDecimal amount, String fuelName, int quantity, String orderAddress) {
        super(id);
        this.amount = amount;
        this.fuelName = fuelName;
        this.quantity = quantity;
        this.orderAddress = orderAddress;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getFuelName() {
        return fuelName;
    }

    public void setFuelName(String fuelName) {
        this.fuelName = fuelName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "amount=" + amount +
                ", fuelName='" + fuelName + '\'' +
                ", quantity=" + quantity +
                ", id=" + id +
                '}';
    }
}
