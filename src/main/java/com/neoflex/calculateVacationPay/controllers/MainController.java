package com.neoflex.calculateVacationPay.controllers;

import com.neoflex.calculateVacationPay.entities.VacationPay;
import com.neoflex.calculateVacationPay.entities.VacationPayDateRange;
import com.neoflex.calculateVacationPay.entities.VacationPaySimple;
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
    public String calculateVacationPaySimple(@RequestParam double averageSalary, @RequestParam int vacationCount, Model model) {
        vacationPaySimpleService = new VacationPaySimpleService(new VacationPaySimple(averageSalary, vacationCount));
        model.addAttribute("vacationPay", vacationPaySimpleService.calculateVacationPay());
        model.addAttribute("averageSalary", averageSalary);
        model.addAttribute("vacationCount", vacationCount);

        return "calculate-simple";
    }

    @GetMapping("/calculateRange")
    public String calculateVacationPayDateRange(@RequestParam double averageSalary, @RequestParam LocalDate dateFrom, @RequestParam LocalDate dateTo,
                                                Model model) {
        VacationPayDateRange vacationPayDateRange = new VacationPayDateRange(averageSalary, dateFrom, dateTo);
        vacationPayDateRangeService = new VacationPayDateRangeService(vacationPayDateRange);
        model.addAttribute("vacationPay", vacationPayDateRangeService.calculateVacationPay());
        model.addAttribute("averageSalary", averageSalary);
        model.addAttribute("dateFrom", vacationPayDateRange.getDateFrom());
        model.addAttribute("dateTo", vacationPayDateRange.getDateTo());

        return "calculate-date-range";
    }
}
