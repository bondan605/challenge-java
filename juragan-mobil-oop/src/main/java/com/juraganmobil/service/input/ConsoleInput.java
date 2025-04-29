package com.juraganmobil.service.input;

import com.juraganmobil.model.entity.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConsoleInput implements DataInput {
    private List<Vehicle> vehicles = new ArrayList<>();
    private List<Income> incomes = new ArrayList<>();

    public ConsoleInput() {
        // Hardcoded vehicle data
        SUV suv1 = new SUV("D 1001 UM", 2010, 350000000.0, 4, 500000.0);
        SUV suv2 = new SUV("D 1002 UM", 2010, 350000000.0, 4, 500000.0);
        SUV suv3 = new SUV("D 1003 UM", 2015, 350000000.0, 5, 500000.0);
        SUV suv4 = new SUV("D 1004 UM", 2015, 350000000.0, 5, 500000.0);
        Taxi taxi1 = new Taxi("D 11 UK", 2002, 175000000.0, 4, 0, 4500.0);
        Taxi taxi2 = new Taxi("D 12 UK", 2015, 225000000.0, 4, 0, 4500.0);
        Taxi taxi3 = new Taxi("D 13 UK", 2020, 275000000.0, 4, 0, 4500.0);
        PrivateJet jet1 = new PrivateJet("ID8089", 2015, 150000000000.0, 12, 55_000_000.0);
        PrivateJet jet2 = new PrivateJet("ID8099", 2018, 175000000000.0, 15, 75_000_000.0);
        Boat boat1 = new Boat("Boat18", 2020, 2000000000.0, 12, 10_000_000.0);

        vehicles.addAll(List.of(suv1, suv2, suv3, suv4, taxi1, taxi2, taxi3, jet1, jet2, boat1));

        // Hardcoded income data
        incomes.add(new RentalIncome(new Date(2023 - 1900, 9, 1), 1, "day", suv1.getRentalRatePerDay(), 0, 150_000));
        incomes.add(new RentalIncome(new Date(2023 - 1900, 11, 1), 1, "day", suv2.getRentalRatePerDay(), 0, 150_000));
        incomes.add(new RentalIncome(new Date(2023 - 1900, 11, 12), 1, "day", suv3.getRentalRatePerDay(), 0, 150_000));
        incomes.add(new RentalIncome(new Date(2023 - 1900, 12, 1), 1, "day", suv4.getRentalRatePerDay(), 0, 150_000));
        incomes.add(new OrderIncome(new Date(2023 - 1900, 11, 12), 45.0, taxi1.getBaseFare(), taxi1.getRatePerKilometer()));
        incomes.add(new OrderIncome(new Date(2023 - 1900, 12, 13), 75.0, taxi2.getBaseFare(), taxi2.getRatePerKilometer()));
        incomes.add(new OrderIncome(new Date(2023 - 1900, 1, 13), 90.0, taxi3.getBaseFare(), taxi3.getRatePerKilometer()));
        incomes.add(new RentalIncome(new Date(2022 - 1900, 11, 23), 1, "hour", jet1.getRentalRatePerHour(), 0.0, 0.0));
        incomes.add(new RentalIncome(new Date(2022 - 1900, 11, 25), 1, "hour", jet2.getRentalRatePerHour(), 0.0, 0.0));
        incomes.add(new RentalIncome(new Date(2022 - 1900, 11, 25), 1, "hour", boat1.getRentalRatePerHour(), 0.0, 0.0));
    }

    @Override
    public Vehicle inputVehicle() {
        return null;
    }

    @Override
    public Income inputIncome(Vehicle vehicle) {
        return null;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicles;
    }

    @Override
    public List<Income> getAllIncomes() {
        return incomes;
    }
}
