package com.neoflex.calculateVacationPay.services;

import com.neoflex.calculateVacationPay.entities.VacationPayDateRange;
import org.springframework.stereotype.Service;

@Service
public class VacationPayDateRangeService {

    private VacationPayDateRange vacationPayDateRange;

    public VacationPayDateRangeService() { }

    public VacationPayDateRangeService(VacationPayDateRange vacationPayDateRange) {
        this.vacationPayDateRange = vacationPayDateRange;
    }

        public double calculateVacationPay() {
        double averageDailySalary = vacationPayDateRange.averageDailySalary(
                                    vacationPayDateRange.getAverageSalary());

        long vacationCount = vacationPayDateRange.getVacationCount();

        return Math.floor(averageDailySalary * vacationCount * 100) / 100 ;
    }
}
