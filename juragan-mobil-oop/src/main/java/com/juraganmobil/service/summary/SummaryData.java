package com.juraganmobil.service.summary;

import com.juraganmobil.model.entity.Vehicle;

import java.util.List;

public interface SummaryData {
    double getTotalCarIncome();
    double getTotalPlaneIncome();
    double getTotalBoatIncome();
    double getTotalTax();
    int getTotalCarCount();
    int getTotalPlaneCount();
    int getTotalBoatCount();
    List<Vehicle> getAllData();
    double getSubTotalIncome();
}
