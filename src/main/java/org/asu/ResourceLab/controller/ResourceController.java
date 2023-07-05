package org.asu.ResourceLab.controller;


import org.asu.ResourceLab.model.Resource;
import org.asu.ResourceLab.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/resource-management")
public class ResourceController {

    @Autowired
    private ResourceRepository resourceRepository;

    @GetMapping
    public String viewAllResources(Model model) {
        model.addAttribute("resources", resourceRepository.getAllResources());
        return "resource-management/list";
    }

    @GetMapping("/new")
    public String viewCreateResourceForm(Model model) {
        model.addAttribute("resource", new Resource());
        return "resource-management/form";
    }

    @GetMapping("/edit/{id}")
    public String viewEditResourceForm(@PathVariable int id, Model model) {
        Resource resource = resourceRepository.getResourceById(id);
        model.addAttribute("resource", resource);
        return "resource-management/form";
    }

    @PostMapping("/save")
    public String saveResource(@ModelAttribute Resource resource, RedirectAttributes redirectAttributes) {
        if (resource.getResourceID() == 0) {
            resourceRepository.createResource(resource);
            redirectAttributes.addFlashAttribute("successMessage", "Resource created successfully");
        } else {
            resourceRepository.updateResource(resource);
            redirectAttributes.addFlashAttribute("successMessage", "Resource updated successfully");
        }
        return "redirect:/resource-management";
    }

    @GetMapping("/delete/{id}")
    public String viewDeleteResourceConfirmation(@PathVariable int id, Model model) {
        Resource resource = resourceRepository.getResourceById(id);
        model.addAttribute("resource", resource);
        return "resource-management/delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteResource(@PathVariable int id) {
        resourceRepository.deleteResource(id);
        return "redirect:/resource-management";
    }
}
