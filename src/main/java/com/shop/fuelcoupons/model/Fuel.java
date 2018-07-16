package com.shop.fuelcoupons.model;

import java.math.BigDecimal;

public class Fuel extends AbstractNamedEntity {

    private BigDecimal price;

    private String enable;

    private int fuelStationId;

    public Fuel() {
    }

    public Fuel(BigDecimal price, String enable) {
        this.price = price;
        this.enable = enable;
    }

    public Fuel(Integer id, String name, BigDecimal price, String enable) {
        super(id, name);
        this.price = price;
        this.enable = enable;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    public int getFuelStationId() {
        return fuelStationId;
    }

    public void setFuelStationId(int fuelStationId) {
        this.fuelStationId = fuelStationId;
    }

    @Override
    public String toString() {
        return "Fuel{" +
                "price=" + price +
                ", enable='" + enable + '\'' +
                ", fuelStationId=" + fuelStationId +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
