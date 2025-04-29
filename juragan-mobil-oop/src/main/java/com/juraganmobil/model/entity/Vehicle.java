package com.juraganmobil.model.entity;
import com.juraganmobil.model.enums.VehicleType;


public abstract class Vehicle {
    private String licensePlate;
    private int year;
    private double price;
    private int seatCount;
    private VehicleType vehicleType;

    public Vehicle(String licensePlate, int year, double price, int seatCount, VehicleType vehicleType) {
        this.licensePlate = licensePlate;
        this.year = year;
        this.price = price;
        this.seatCount = seatCount;
        this.vehicleType = vehicleType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public double calculateTax() {
        return price * 0.01;
    }

    @Override
    public String toString() {
        return "License Plate: " + licensePlate + ", Type: " + vehicleType + ", Year: " + year +
                ", Price: " + price + ", Tax: " + calculateTax() + ", Seats: " + seatCount;
    }
}