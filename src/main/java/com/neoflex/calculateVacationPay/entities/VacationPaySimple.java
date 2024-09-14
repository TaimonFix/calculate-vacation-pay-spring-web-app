package com.neoflex.calculateVacationPay.entities;

public class VacationPaySimple extends VacationPay {

    private final int vacationCount;

    public VacationPaySimple(double averageSalary, int vacationCount) {
        super(averageSalary);
        this.vacationCount = vacationCount;
    }

    public int getVacationCount() {
        return vacationCount;
    }
}
