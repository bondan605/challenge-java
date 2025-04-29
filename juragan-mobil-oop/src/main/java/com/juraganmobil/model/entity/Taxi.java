package com.juraganmobil.model.entity;

import com.juraganmobil.model.enums.VehicleType;
import com.juraganmobil.model.interfaces.Orderable;

public class Taxi extends Vehicle implements Orderable {
    private double baseFare;
    private double ratePerKilometer;

    public Taxi(String licensePlate, int year, double price, int seatCount, double baseFare, double ratePerKilometer) {
        super(licensePlate, year, price, seatCount, VehicleType.TAXI);
        this.baseFare = baseFare;
        this.ratePerKilometer = ratePerKilometer;
    }

    public double getBaseFare() {
        return baseFare;
    }

    public double getRatePerKilometer() {
        return ratePerKilometer;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.01;
    }

    @Override
    public double calculateOrderRate(double distance) {
        return baseFare + (ratePerKilometer * distance);
    }
}