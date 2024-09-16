package com.neoflex.calculateVacationPay.controllers;

import com.neoflex.calculateVacationPay.entities.VacationPayDateRange;
import com.neoflex.calculateVacationPay.entities.VacationPaySimple;
import com.neoflex.calculateVacationPay.exceptions.IllegalDateRangeException;
import com.neoflex.calculateVacationPay.exceptions.MissingParameterException;
import com.neoflex.calculateVacationPay.services.VacationPayDateRangeService;
import com.neoflex.calculateVacationPay.services.VacationPaySimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.LocalDate;

@Controller
public class MainController {

    private VacationPaySimpleService vacationPaySimpleService;
    private VacationPayDateRangeService vacationPayDateRangeService;

    @Autowired
    public void setVacationPaySimpleService(VacationPaySimpleService vacationPaySimpleService) {
        this.vacationPaySimpleService = vacationPaySimpleService;
    }

    @Autowired
    public void setVacationPayDateRangeService(VacationPayDateRangeService vacationPayDateRangeService) {
        this.vacationPayDateRangeService = vacationPayDateRangeService;
    }

    @GetMapping("/index")
    public String homePage() {
        return "index";
    }

    @GetMapping("/calculate")
    public String calculateVacationPaySimple(@RequestParam(required = false) Double averageSalary,
                                             @RequestParam(required = false) Integer vacationCount,
                                             Model model) {
        try {
            if (averageSalary == null) {
                throw new MissingParameterException("Введите среднюю зарплату.");
            }
            if (vacationCount == null) {
                throw new MissingParameterException("Введите количество дней отпуска.");
            }
            vacationPaySimpleService = new VacationPaySimpleService(new VacationPaySimple(averageSalary, vacationCount));
            model.addAttribute("vacationPay", vacationPaySimpleService.calculateVacationPay());
            model.addAttribute("averageSalary", averageSalary);
            model.addAttribute("vacationCount", vacationCount);
        } catch (MissingParameterException e) {
            System.out.println(e);
            model.addAttribute("exception", e);
        }

        return "calculate-simple";
    }

    @GetMapping("/calculate/range")
    public String calculateVacationPayDateRange(@RequestParam(required = false) Double averageSalary,
                                                @RequestParam(required = false) LocalDate dateFrom,
                                                @RequestParam(required = false) LocalDate dateTo,
                                                Model model) {
        try {
            if (averageSalary == null) {
                throw new MissingParameterException("Введите среднюю зарплату.");
            }
            if (dateFrom == null) {
                throw new MissingParameterException("Введите дату начала отпуска.");
            }
            if (dateTo == null) {
                throw new MissingParameterException("Введите дату окончания отпуска.");
            }
            if (dateFrom.isAfter(dateTo)) {
                throw new IllegalDateRangeException("Начальная дата позже конечной.");
            }

            VacationPayDateRange vacationPayDateRange = new VacationPayDateRange(averageSalary, dateFrom, dateTo);
            vacationPayDateRangeService = new VacationPayDateRangeService(vacationPayDateRange);
            model.addAttribute("vacationPay", vacationPayDateRangeService.calculateVacationPay());
            model.addAttribute("averageSalary", averageSalary);
            model.addAttribute("dateFrom", vacationPayDateRange.getDateFrom());
            model.addAttribute("dateTo", vacationPayDateRange.getDateTo());
        } catch (IllegalDateRangeException | MissingParameterException e) {
            System.out.println(e);
            model.addAttribute("exception", e);
        }

        return "calculate-date-range";
    }
}
