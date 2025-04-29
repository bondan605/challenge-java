package com.juraganmobil.service.output;

import com.juraganmobil.model.entity.Income;
import com.juraganmobil.model.entity.Vehicle;
import com.juraganmobil.service.summary.SummaryData;

public interface ConsoleOutput {
    void displayVehicleDetails(Vehicle vehicle);
    void displayIncomeDetails(Income income);
    void displaySummary(SummaryData summaryData);
}
