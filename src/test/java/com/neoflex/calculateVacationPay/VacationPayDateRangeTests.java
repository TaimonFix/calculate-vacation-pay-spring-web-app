package com.neoflex.calculateVacationPay;

import com.neoflex.calculateVacationPay.entities.VacationPayDateRange;
import com.neoflex.calculateVacationPay.services.VacationPayDateRangeService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
class VacationPayDateRangeTests {

    @Test
    void testOne() {
        VacationPayDateRange vacationPayDateRange = new VacationPayDateRange(29400, LocalDate.of(2023, 1, 1),
                LocalDate.of(2023, 12, 31));

        assertEquals(351, vacationPayDateRange.getVacationCount());
    }

    @Test
    void testTwo() {
        VacationPayDateRange vacationPayDateRange = new VacationPayDateRange(29400, LocalDate.of(2020, 1, 1),
                LocalDate.of(2020, 12, 31));
        assertEquals(352, vacationPayDateRange.getVacationCount());
    }

    @Test
    void testThree() {
        VacationPayDateRange vacationPayDateRange = new VacationPayDateRange(29400, LocalDate.of(2023, 1, 9),
                LocalDate.of(2023, 1, 20));
        assertEquals(12, vacationPayDateRange.getVacationCount());
    }

    @Test
    void testFour() {
        VacationPayDateRange vacationPayDateRange = new VacationPayDateRange(29400, LocalDate.of(2023, 1, 9),
                LocalDate.of(2023, 1, 20));
        assertEquals(12, vacationPayDateRange.getVacationCount());
    }

    @Test
    void testFive() {
        VacationPayDateRange vacationPayDateRange = new VacationPayDateRange(29400, LocalDate.of(2023, 1, 1),
                LocalDate.of(2023, 12, 31));
        VacationPayDateRangeService vacationPayDateRangeService = new VacationPayDateRangeService(vacationPayDateRange);
        assertEquals(351000, vacationPayDateRangeService.calculateVacationPay());
    }

    @Test
    void testSix() {
        VacationPayDateRange vacationPayDateRange = new VacationPayDateRange(50000, LocalDate.of(2023, 1, 1),
                LocalDate.of(2023, 1, 31));
        VacationPayDateRangeService vacationPayDateRangeService = new VacationPayDateRangeService(vacationPayDateRange);
        assertEquals(39115.64, vacationPayDateRangeService.calculateVacationPay());
    }

}
