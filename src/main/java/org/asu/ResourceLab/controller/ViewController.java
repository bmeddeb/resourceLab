package org.asu.ResourceLab.controller;
import org.asu.ResourceLab.model.Maintenance;
import org.asu.ResourceLab.repository.BookingRepository;
import org.asu.ResourceLab.repository.MaintenanceRepository;
import org.asu.ResourceLab.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class ViewController {

    @Autowired
    private ReportRepository reportRepository;

    @GetMapping("/view/userActivity")
    public String getUserActivity (Model model) {
        List<Map<String, Object>> userActivityReport = reportRepository.getUserActivityReport();
        model.addAttribute("report", userActivityReport);
        return "view/userActivity";
    }

    @GetMapping("/view/resourceUtilization")
    public String getResourceUtilization (Model model) {
        List<Map<String, Object>> resourceUtilizationReport = reportRepository.getResourceUtilizationReport();
        model.addAttribute("report", resourceUtilizationReport);
        return "view/resourceUtilization";
    }
}