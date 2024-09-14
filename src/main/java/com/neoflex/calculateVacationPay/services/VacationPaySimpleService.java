package com.neoflex.calculateVacationPay.services;

import com.neoflex.calculateVacationPay.entities.VacationPaySimple;
import org.springframework.stereotype.Service;

@Service
public class VacationPaySimpleService {
    private VacationPaySimple vacationPaySimple;

    public VacationPaySimpleService() { }

    public VacationPaySimpleService(VacationPaySimple vacationPaySimple) {
        this.vacationPaySimple = vacationPaySimple;
    }

    public double calculateVacationPay() {
        double averageDailySalary = vacationPaySimple.averageDailySalary(vacationPaySimple.getAverageSalary());

        return Math.floor(averageDailySalary * vacationPaySimple.getVacationCount() * 100) / 100;
    }
}
