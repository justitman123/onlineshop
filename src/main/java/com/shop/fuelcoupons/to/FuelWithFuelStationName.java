package com.shop.fuelcoupons.to;

import java.math.BigDecimal;

public class FuelWithFuelStationName extends BaseTo {

    private String fuelStationName;

    private String fuelName;

    private BigDecimal price;

    public FuelWithFuelStationName() {
    }

    public FuelWithFuelStationName(String fuelStationName, String fuelName, BigDecimal price) {
        this.fuelStationName = fuelStationName;
        this.fuelName = fuelName;
        this.price = price;
    }

    public FuelWithFuelStationName(Integer id, String fuelStationName, String fuelName, BigDecimal price) {
        super(id);
        this.fuelStationName = fuelStationName;
        this.fuelName = fuelName;
        this.price = price;
    }

    public String getFuelStationName() {
        return fuelStationName;
    }

    public String getFuelName() {
        return fuelName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "FuelWithFuelStationName{" +
                "fuelStationName='" + fuelStationName + '\'' +
                ", fuelName='" + fuelName + '\'' +
                ", price=" + price +
                '}';
    }
}
