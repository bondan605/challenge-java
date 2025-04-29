package com.juraganmobil;


import com.juraganmobil.model.entity.Income;
import com.juraganmobil.model.entity.Vehicle;
import com.juraganmobil.service.input.ConsoleInput;
import com.juraganmobil.service.input.DataInput;
import com.juraganmobil.service.output.ConsoleOutput;
import com.juraganmobil.service.output.ConsoleOutputter;
import com.juraganmobil.service.summary.DataSummary;

import java.util.List;

public class Main {
    public static DataInput dataInput = new ConsoleInput();
    public static void main(String[] args) {
        ConsoleOutput consoleOutput = new ConsoleOutputter();

        List<Vehicle> allVehicles = dataInput.getAllVehicles();
        List<Income> allIncomes = ((ConsoleInput) dataInput).getAllIncomes();

        DataSummary dataSummary = new DataSummary(allVehicles, allIncomes);

        consoleOutput.displaySummary(dataSummary);
    }
}