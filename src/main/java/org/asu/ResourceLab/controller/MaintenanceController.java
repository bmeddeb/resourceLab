package org.asu.ResourceLab.controller;

import org.asu.ResourceLab.model.Maintenance;
import org.asu.ResourceLab.repository.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/maintenance")
public class MaintenanceController {

    private final MaintenanceRepository maintenanceRepository;

    @Autowired
    public MaintenanceController(MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }

    @GetMapping
    public String list(Model model) {
        List<Maintenance> maintenances = maintenanceRepository.getAllMaintenances();
        model.addAttribute("maintenances", maintenances);
        return "maintenance/list";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable int id, Model model) {
        Maintenance maintenance = maintenanceRepository.getMaintenanceById(id);
        model.addAttribute("maintenance", maintenance);
        return "maintenance/view";
    }

    @GetMapping("/new")
    public String newMaintenance(Model model) {
        model.addAttribute("maintenance", new Maintenance());
        return "maintenance/new";
    }

    @PostMapping
    public String create(@ModelAttribute Maintenance maintenance) {
        maintenanceRepository.createMaintenance(maintenance);
        return "redirect:/maintenance";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        Maintenance maintenance = maintenanceRepository.getMaintenanceById(id);
        model.addAttribute("maintenance", maintenance);
        return "maintenance/edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable int id, @ModelAttribute Maintenance maintenance) {
        maintenance.setMaintenanceID(id);
        maintenanceRepository.updateMaintenance(maintenance);
        return "redirect:/maintenance";
    }
}
