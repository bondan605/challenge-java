package com.juraganmobil.model.entity;

import java.util.Date;

public class OrderIncome extends Income {
    private double distance;
    private double baseFareVehicle;
    private double ratePerKilometerVehicle;

    public OrderIncome(Date transactionDate, double distance, double baseFareVehicle, double ratePerKilometerVehicle) {
        super(transactionDate, baseFareVehicle + (ratePerKilometerVehicle * distance));
        this.distance = distance;
        this.baseFareVehicle = baseFareVehicle;
        this.ratePerKilometerVehicle = ratePerKilometerVehicle;
    }

    public double getDistance() {
        return distance;
    }

    public double getBaseFareVehicle() {
        return baseFareVehicle;
    }

    public double getRatePerKilometerVehicle() {
        return ratePerKilometerVehicle;
    }

    @Override
    public String toString() {
        return super.toString() + ", Distance: " + distance + " KM, Base Fare: " + baseFareVehicle +
                ", Rate per KM: " + ratePerKilometerVehicle;
    }
}
