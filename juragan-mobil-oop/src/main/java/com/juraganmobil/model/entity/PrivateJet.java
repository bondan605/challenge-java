package com.juraganmobil.model.entity;

import com.juraganmobil.model.enums.VehicleType;
import com.juraganmobil.model.interfaces.Rentable;

public class PrivateJet extends Vehicle implements Rentable {
    private double rentalRatePerHour;

    public PrivateJet(String licensePlate, int year, double price, int seatCount, double rentalRatePerHour) {
        super(licensePlate, year, price, seatCount, VehicleType.PRIVATE_JET);
        this.rentalRatePerHour = rentalRatePerHour;
    }

    public double getRentalRatePerHour() {
        return rentalRatePerHour;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.01;
    }

    @Override
    public double calculateRentalRate(double duration, String unit) {
        if (unit.equalsIgnoreCase("hour")) {
            return rentalRatePerHour * duration;
        } else {
            System.err.println("Unit waktu tidak valid untuk Private Jet. Harap gunakan 'hour'.");
            return 0.0;
        }
    }
}