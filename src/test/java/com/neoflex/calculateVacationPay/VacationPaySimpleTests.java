package com.neoflex.calculateVacationPay;

import com.neoflex.calculateVacationPay.Entities.VacationPaySimple;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class VacationPaySimpleTests {

	@Test
	void testFirst() {
		VacationPaySimple vacationPay = new VacationPaySimple(29400, 5);
		assertEquals(5000, vacationPay.calculateVacationPay());
	}

	@Test
	void testTwo() {
		VacationPaySimple vacationPay = new VacationPaySimple(50000, 12);
		assertEquals(20408.16, vacationPay.calculateVacationPay());
	}
}
