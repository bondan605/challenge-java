package com.juraganmobil.model.entity;

import java.util.Date;

public class RentalIncome extends Income {
    private double rentalDuration;
    private String rentalUnit;
    private double rentalRateVehicle; // Harga sewa dari Vehicle (per jam atau per hari)
    private double orderPerHour;
    private double driverFee;

    public RentalIncome(Date transactionDate, double rentalDuration, String rentalUnit, double rentalRateVehicle, double orderPerHour, double driverFee) {
        super(transactionDate, (rentalRateVehicle * (rentalUnit.equalsIgnoreCase("day") ? rentalDuration : (rentalUnit.equalsIgnoreCase("hour") ? rentalDuration : 0))) + (orderPerHour > 0 ? orderPerHour : 0) + (driverFee > 0 ? driverFee : 0));
        this.rentalDuration = rentalDuration;
        this.rentalUnit = rentalUnit;
        this.rentalRateVehicle = rentalRateVehicle;
        this.orderPerHour = orderPerHour;
        this.driverFee = driverFee;
    }

    public double getRentalDuration() {
        return rentalDuration;
    }

    public String getRentalUnit() {
        return rentalUnit;
    }

    public double getRentalRateVehicle() {
        return rentalRateVehicle;
    }

    public double getOrderPerHour() {
        return orderPerHour;
    }

    public double getDriverFee() {
        return driverFee;
    }

    @Override
    public String toString() {
        return super.toString() + ", Rent: " + rentalRateVehicle + "/" + rentalUnit + " * " + rentalDuration +
                ", Order Per Hours: " + orderPerHour + ", Driver: " + driverFee;
    }
}
