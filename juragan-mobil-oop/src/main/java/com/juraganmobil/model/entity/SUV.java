package com.juraganmobil.model.entity;

import com.juraganmobil.model.enums.VehicleType;
import com.juraganmobil.model.interfaces.Rentable;

public class SUV extends Vehicle implements Rentable {
    private double rentalRatePerDay;

    public SUV(String licensePlate, int year, double price, int seatCount, double rentalRatePerDay) {
        super(licensePlate, year, price, seatCount, VehicleType.SUV);
        this.rentalRatePerDay = rentalRatePerDay;
    }

    public double getRentalRatePerDay() {
        return rentalRatePerDay;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.01;
    }

    @Override
    public double calculateRentalRate(double duration, String unit) {
        if (unit.equalsIgnoreCase("day")) {
            return rentalRatePerDay * duration;
        } else {
            System.err.println("Unit waktu tidak valid untuk SUV. Harap gunakan 'day'.");
            return 0.0;
        }
    }
}