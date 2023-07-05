package org.asu.ResourceLab.controller;


import org.asu.ResourceLab.model.Resource;
import org.asu.ResourceLab.model.User;
import org.asu.ResourceLab.model.UtilizationReport;
import org.asu.ResourceLab.repository.ReportRepository;
import org.asu.ResourceLab.repository.ResourceRepository;
import org.asu.ResourceLab.repository.UserRepository;
import org.asu.ResourceLab.repository.UtilizationReportRepository;
import org.asu.ResourceLab.service.DataTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private UtilizationReportRepository utilizationReportRepository;


    @Autowired
    private DataTypeService dataTypeService;
    private LocalDateTime generatedDate;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ResourceRepository resourceRepository;


    public static java.util.Date asDate (LocalDateTime localDateTime) {
        return java.util.Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    @GetMapping
    public String viewReportListPage (Model model) {
        List<UtilizationReport> reportList = utilizationReportRepository.getAllReports();
        model.addAttribute("reports", reportList);
        return "reports/list";
    }

    @GetMapping("/{id}")
    public String viewReportDetailPage (@PathVariable int id, Model model) {
        UtilizationReport existingReport = utilizationReportRepository.getReportById(id);
        String dataType = dataTypeService.getDataType(existingReport.getUtilizationData());
        model.addAttribute("report", existingReport);
        model.addAttribute("dataType", dataType);
        return "reports/detail";
    }

    @PostMapping("/save")
    public String saveReport (@ModelAttribute("report") UtilizationReport report) {
        if (report.getReportID() == null) {
            report.setGeneratedDate(asDate(LocalDateTime.now()));
            utilizationReportRepository.createReport(report);
        } else {
            report.setGeneratedDate(asDate(LocalDateTime.now()));
            utilizationReportRepository.updateReport(report);
        }
        return "redirect:/reports";
    }

    @GetMapping("/delete/{id}")
    public String deleteReport (@PathVariable int id) {
        utilizationReportRepository.deleteReport(id);
        return "redirect:/reports";
    }

    @GetMapping("/create")
    public String createReportPage(Model model) {
        UtilizationReport report = new UtilizationReport();
        List<User> users = userRepository.getAllUsers();
        List<Resource> resources = resourceRepository.getAllResources();
        model.addAttribute("report", report);
        model.addAttribute("users", users);
        model.addAttribute("resources", resources);
        if(!users.isEmpty()) {
            User user = users.get(0);
            model.addAttribute("userID", user.getUserID());
        }

        if(!resources.isEmpty()) {
            Resource resource = resources.get(0);
            model.addAttribute("resourceID", resource.getResourceID());
        }
        return "reports/create";
    }
}
