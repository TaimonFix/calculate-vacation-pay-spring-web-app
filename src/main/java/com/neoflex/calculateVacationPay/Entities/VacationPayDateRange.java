package com.neoflex.calculateVacationPay.Entities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class VacationPayDateRange extends VacationPay{

    private LocalDate dateFrom;
    private LocalDate dateTo;
    private long vacationCount;

    public VacationPayDateRange(double averageSalary, LocalDate dateFrom, LocalDate dateTo) {
        super(averageSalary);
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.vacationCount = ChronoUnit.DAYS.between(dateFrom,  dateTo);
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    private final LocalDate[] arrayOfHolidays = {LocalDate.of(0, 1, 1), LocalDate.of(0, 1, 2),
                                            LocalDate.of(0, 1, 3),      LocalDate.of(0, 1, 4),
                                            LocalDate.of(0, 1, 5),      LocalDate.of(0, 1, 6),
                                            LocalDate.of(0, 1, 7),      LocalDate.of(0, 1, 8),
                                            LocalDate.of(0, 2, 23),     LocalDate.of(0, 3, 8),
                                            LocalDate.of(0, 5, 1),      LocalDate.of(0, 5, 9),
                                            LocalDate.of(0, 6, 12),     LocalDate.of(0, 11, 4)};
    public long calculateVacationCount() {

        if (vacationCount == 0) {
            return 1;
        } else {
        if (vacationCount < 0) {
            LocalDate dateTMP;
            dateTMP = dateFrom;
            dateFrom = dateTo;
            dateTo = dateTMP;
            vacationCount = Math.abs(vacationCount) + 1;
        }

        vacationCount++;

        for(LocalDate dateHoliday: arrayOfHolidays) {
            for (int i = dateFrom.getYear(); i <= dateTo.getYear(); i++) {
                dateHoliday = LocalDate.of(i, dateHoliday.getMonth(), dateHoliday.getDayOfMonth());
                if (ChronoUnit.DAYS.between(dateFrom, dateHoliday) >= 0 && ChronoUnit.DAYS.between( dateTo, dateHoliday) <= 0) {
                    vacationCount--;
                }
            }
        }
        return vacationCount;
        }
    }

    @Override
    public double calculateVacationPay() {
        double averageDailySalary = averageDailySalary(getAverageSalary());
        long vacationCount = calculateVacationCount();

        return Math.floor(averageDailySalary * vacationCount * 100) / 100 ;
    }

    public static void main(String[] args) {
        VacationPayDateRange vacationPayDateRange = new VacationPayDateRange(29400, LocalDate.of(2021, 1, 1), LocalDate.of(2021, 12, 31));
        System.out.println(vacationPayDateRange.calculateVacationPay());
    }

}
