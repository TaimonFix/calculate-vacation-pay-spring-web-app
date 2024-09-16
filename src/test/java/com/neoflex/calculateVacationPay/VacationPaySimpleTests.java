package com.neoflex.calculateVacationPay;

import com.neoflex.calculateVacationPay.entities.VacationPaySimple;
import com.neoflex.calculateVacationPay.services.VacationPaySimpleService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class VacationPaySimpleTests {

	@Test
	void testFirst() {
		VacationPaySimple vacationPay = new VacationPaySimple(29400, 5);
		VacationPaySimpleService vacationPaySimpleService = new VacationPaySimpleService(vacationPay);
		assertEquals(5000, vacationPaySimpleService.calculateVacationPay());
	}

	@Test
	void testTwo() {
		VacationPaySimple vacationPay = new VacationPaySimple(50000, 12);
		VacationPaySimpleService vacationPaySimpleService = new VacationPaySimpleService(vacationPay);
		assertEquals(20408.16, vacationPaySimpleService.calculateVacationPay());
	}
}
