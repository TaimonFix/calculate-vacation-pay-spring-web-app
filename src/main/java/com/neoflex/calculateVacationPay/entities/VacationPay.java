package com.neoflex.calculateVacationPay.entities;

public abstract class VacationPay {
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
