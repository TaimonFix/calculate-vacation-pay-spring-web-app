package com.neoflex.calculateVacationPay.entities;

public class VacationPaySimple extends VacationPay {

    private final int vacationCount;

    public VacationPaySimple(double averageSalary, int vacationCount) {
        super(averageSalary);
        this.vacationCount = vacationCount;
    }

    @Override
    public double calculateVacationPay() {
        double averageDailySalary = averageDailySalary(getAverageSalary());

        return Math.floor(averageDailySalary * vacationCount * 100) / 100;
    }

}
