package com.neoflex.calculateVacationPay;

import com.neoflex.calculateVacationPay.entities.VacationPayDateRange;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
class VacationPayDateRangeTests {

    @Test
    void testOne() {
        VacationPayDateRange vacationPayDateRange = new VacationPayDateRange(29400, LocalDate.of(2023, 1, 1),
                LocalDate.of(2023, 12, 31));

        assertEquals(351, vacationPayDateRange.calculateVacationCount());
    }

    @Test
    void testTwo() {
        VacationPayDateRange vacationPayDateRange = new VacationPayDateRange(29400, LocalDate.of(2020, 1, 1),
                LocalDate.of(2020, 12, 31));
        assertEquals(352, vacationPayDateRange.calculateVacationCount());
    }

    @Test
    void testThree() {
        VacationPayDateRange vacationPayDateRange = new VacationPayDateRange(29400, LocalDate.of(2023, 1, 9),
                LocalDate.of(2023, 1, 20));
        assertEquals(12, vacationPayDateRange.calculateVacationCount());
    }

    @Test
    void testFour() {
        VacationPayDateRange vacationPayDateRange = new VacationPayDateRange(29400, LocalDate.of(2023, 1, 9),
                LocalDate.of(2023, 1, 20));
        assertEquals(12, vacationPayDateRange.calculateVacationCount());
    }

    @Test
    void testFive() {
        VacationPayDateRange vacationPayDateRange = new VacationPayDateRange(29400, LocalDate.of(2023, 1, 1),
                LocalDate.of(2023, 12, 31));
        assertEquals(351000, vacationPayDateRange.calculateVacationPay());
    }

    @Test
    void testSix() {
        VacationPayDateRange vacationPayDateRange = new VacationPayDateRange(50000, LocalDate.of(2023, 1, 1),
                LocalDate.of(2023, 1, 31));
        assertEquals(39115.64, vacationPayDateRange.calculateVacationPay());
    }

}
