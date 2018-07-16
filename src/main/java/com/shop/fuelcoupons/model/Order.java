package com.shop.fuelcoupons.model;

import com.shop.fuelcoupons.util.DateTimeUtil;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "date_time", "status"}, name = "orders_unique_id_datetime_status_idx")})
public class Order extends AbstractBaseEntity {

    @Column(name = "date_time", nullable = false)
    @NotNull
    @DateTimeFormat(pattern = DateTimeUtil.DATE_TIME_PATTERN)
    private LocalDateTime dateTime;

    @Column(name = "status", nullable = false)
    @NotBlank
    @Size(min = 2, max = 20)
    private String status;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order")
    @Fetch(FetchMode.SUBSELECT)
    private List<OrderDetail> orderDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    public Order() {
    }

    public Order(LocalDateTime dateTime, String status) {
        this(null, dateTime, status);
    }

    public Order(Integer id, LocalDateTime dateTime, String status) {
        super(id);
        this.dateTime = dateTime;
        this.status = status;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "dateTime=" + dateTime +
                ", status='" + status + '\'' +
                ", id=" + id +
                '}';
    }
}
