package com.juraganmobil.service.output;

import com.juraganmobil.Main;
import com.juraganmobil.model.entity.Income;
import com.juraganmobil.model.entity.OrderIncome;
import com.juraganmobil.model.entity.RentalIncome;
import com.juraganmobil.model.entity.Vehicle;
import com.juraganmobil.service.input.ConsoleInput;
import com.juraganmobil.service.summary.SummaryData;

import java.text.SimpleDateFormat;
import java.util.List;

public class ConsoleOutputter implements ConsoleOutput {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void displayVehicleDetails(Vehicle vehicle) {
        System.out.printf("%-15s %-12s %-5d %-15.2f %-10.2f %-5d",
                vehicle.getLicensePlate(),
                vehicle.getVehicleType(),
                vehicle.getYear(),
                vehicle.getPrice(),
                vehicle.calculateTax(),
                vehicle.getSeatCount());
    }

    @Override
    public void displayIncomeDetails(Income income) {
        if (income instanceof RentalIncome) {
            RentalIncome rentalIncome = (RentalIncome) income;
            System.out.printf(" %-15s %-15.2f %-15.2f %-15.2f %-15.2f%n",
                    dateFormat.format(rentalIncome.getTransactionDate()),
                    rentalIncome.getRentalRateVehicle() * rentalIncome.getRentalDuration(), // Menampilkan total rental
                    rentalIncome.getOrderPerHour(),
                    rentalIncome.getDriverFee(),
                    income.getTotal());
        } else if (income instanceof OrderIncome) {
            OrderIncome orderIncome = (OrderIncome) income;
            System.out.printf(" %-15s %-15.2f KM %-15.2f/KM %-15.2f%n",
                    dateFormat.format(orderIncome.getTransactionDate()),
                    orderIncome.getDistance(),
                    orderIncome.getRatePerKilometerVehicle(),
                    income.getTotal());
        } else {
            System.out.printf(" %-15s %-15.2f%n",
                    dateFormat.format(income.getTransactionDate()),
                    income.getTotal());
        }
    }

    @Override
    public void displaySummary(SummaryData summaryData) {
        System.out.println("\n--- Vehicle and Transaction Details ---");
        System.out.printf("%-15s %-12s %-5s %-15s %-10s %-5s %-15s %-15s %-15s %-15s %-15s%n",
                "LicensePlate", "VehicleType", "Year", "Price", "Tax", "Seat", "TransactionDate", "Rent", "OrderPerHours", "Driver", "Total");

        List<Vehicle> vehicles = summaryData.getAllData();
        List<Income> incomes = ((ConsoleInput) Main.dataInput).getAllIncomes();

        for (int i = 0; i < vehicles.size(); i++) {
            displayVehicleDetails(vehicles.get(i));
            if (i < incomes.size()) {
                displayIncomeDetails(incomes.get(i));
            } else {
                System.out.println(" No income data for this vehicle.");
            }
        }

        System.out.println("\n--- Summary ---");
        System.out.println("Subtotal Income: " + String.format("%.2f", summaryData.getSubTotalIncome()));
        System.out.println("Total Car Income: " + String.format("%.2f", summaryData.getTotalCarIncome()));
        System.out.println("Total Plane Income: " + String.format("%.2f", summaryData.getTotalPlaneIncome()));
        System.out.println("Total Boat Income: " + String.format("%.2f", summaryData.getTotalBoatIncome()));
        System.out.println("Total Tax: " + String.format("%.2f", summaryData.getTotalTax()));
        System.out.println("Total Cars: " + summaryData.getTotalCarCount());
        System.out.println("Total Planes: " + summaryData.getTotalPlaneCount());
        System.out.println("Total Boats: " + summaryData.getTotalBoatCount());
    }
}