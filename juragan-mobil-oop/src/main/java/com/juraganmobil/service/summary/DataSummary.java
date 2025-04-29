package com.juraganmobil.service.summary;

import com.juraganmobil.model.entity.Income;
import com.juraganmobil.model.entity.Vehicle;
import com.juraganmobil.model.enums.VehicleType;

import java.util.List;

public class DataSummary implements SummaryData {
    private List<Vehicle> vehicles;
    private List<Income> incomes;

    public DataSummary(List<Vehicle> vehicles, List<Income> incomes) {
        this.vehicles = vehicles;
        this.incomes = incomes;
    }

    @Override
    public double getTotalCarIncome() {
        double suvIncome = incomes.stream()
                .filter(income -> vehicles.stream().anyMatch(v -> v.getVehicleType() == VehicleType.SUV && getVehicleIncomeIndex(v) == incomes.indexOf(income)))
                .mapToDouble(Income::getTotal)
                .sum();
        double taxiIncome = incomes.stream()
                .filter(income -> vehicles.stream().anyMatch(v -> v.getVehicleType() == VehicleType.TAXI && getVehicleIncomeIndex(v) == incomes.indexOf(income)))
                .mapToDouble(Income::getTotal)
                .sum();
        return suvIncome + taxiIncome;
    }

    @Override
    public double getTotalPlaneIncome() {
        return incomes.stream()
                .filter(income -> vehicles.stream().anyMatch(v -> v.getVehicleType() == VehicleType.PRIVATE_JET && getVehicleIncomeIndex(v) == incomes.indexOf(income)))
                .mapToDouble(Income::getTotal)
                .sum();
    }

    @Override
    public double getTotalBoatIncome() {
        return incomes.stream()
                .filter(income -> vehicles.stream().anyMatch(v -> v.getVehicleType() == VehicleType.BOAT && getVehicleIncomeIndex(v) == incomes.indexOf(income)))
                .mapToDouble(Income::getTotal)
                .sum();
    }

    @Override
    public double getTotalTax() {
        return vehicles.stream().mapToDouble(Vehicle::calculateTax).sum();
    }

    @Override
    public int getTotalCarCount() {
        return (int) vehicles.stream().filter(v -> v.getVehicleType() == VehicleType.SUV || v.getVehicleType() == VehicleType.TAXI).count();
    }

    @Override
    public int getTotalPlaneCount() {
        return (int) vehicles.stream().filter(v -> v.getVehicleType() == VehicleType.PRIVATE_JET).count();
    }

    @Override
    public int getTotalBoatCount() {
        return (int) vehicles.stream().filter(v -> v.getVehicleType() == VehicleType.BOAT).count();
    }

    @Override
    public List<Vehicle> getAllData() {
        return vehicles;
    }

    public double getSubTotalIncome() {
        return incomes.stream().mapToDouble(Income::getTotal).sum();
    }

    private int getVehicleIncomeIndex(Vehicle vehicle) {
        return vehicles.indexOf(vehicle);
    }
}
