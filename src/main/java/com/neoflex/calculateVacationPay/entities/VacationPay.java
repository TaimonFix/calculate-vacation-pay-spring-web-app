package com.neoflex.calculateVacationPay.entities;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public abstract class VacationPay {
    @NotEmpty(message = "Введите среднюю зарплату.")
    private final double averageSalary;

    public VacationPay(double averageSalary) {
        this.averageSalary = averageSalary;
    }

    public double getAverageSalary() {
        return averageSalary;
    }

    public double averageDailySalary(double averageSalary) {
        return averageSalary / 29.4;
    }
}
