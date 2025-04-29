package com.juraganmobil.service.input;

import com.juraganmobil.model.entity.Income;
import com.juraganmobil.model.entity.Vehicle;

import java.util.List;

public interface DataInput {
    Vehicle inputVehicle();
    Income inputIncome(Vehicle vehicle);
    List<Vehicle> getAllVehicles();
    List<Income> getAllIncomes();
}
