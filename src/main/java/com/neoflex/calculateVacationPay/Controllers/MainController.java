package com.neoflex.calculateVacationPay.Controllers;

import com.neoflex.calculateVacationPay.Entities.VacationPayDateRange;
import com.neoflex.calculateVacationPay.Entities.VacationPaySimple;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class MainController {


    @GetMapping("/index")
    public String homePage() {
        return "index";
    }

    @GetMapping("/calculate")
    public String calculateVacationPaySimple(@RequestParam double averageSalary, @RequestParam int vacationCount, Model model) {
        VacationPaySimple vacationPaySimple = new VacationPaySimple(averageSalary, vacationCount);
        model.addAttribute("vacationPay", vacationPaySimple.calculateVacationPay());
        model.addAttribute("averageSalary", averageSalary);
        model.addAttribute("vacationCount", vacationCount);


        return "calculate-simple";
    }

    @GetMapping("/calculateRange")
    public String calculateVacationPayDateRange(@RequestParam double averageSalary, @RequestParam LocalDate dateFrom, @RequestParam LocalDate dateTo,
                                                Model model) {
        VacationPayDateRange vacationPayDateRange = new VacationPayDateRange(averageSalary, dateFrom, dateTo);
        model.addAttribute("vacationPay", vacationPayDateRange.calculateVacationPay());
        model.addAttribute("averageSalary", averageSalary);
        model.addAttribute("dateFrom", vacationPayDateRange.getDateFrom());
        model.addAttribute("dateTo", vacationPayDateRange.getDateTo());

        return "calculate-date-range";
    }
}
