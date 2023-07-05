package org.asu.ResourceLab.controller;

import java.util.List;

import org.asu.ResourceLab.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.asu.ResourceLab.model.Booking;


@Controller
@RequestMapping("/booking-management")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping
    public String viewBookingListPage(Model model) {
        List<Booking> bookingList = bookingRepository.getAllBookings();
        model.addAttribute("bookings", bookingList);
        return "booking/list";
    }

    @GetMapping("/new")
    public String viewCreateBookingPage(Model model) {
        Booking booking = new Booking();
        model.addAttribute("booking", booking);
        return "booking/form";
    }

    @GetMapping("/edit/{id}")
    public String viewEditBookingPage(@PathVariable int id, Model model) {
        Booking existingBooking = bookingRepository.getBookingById(id);
        model.addAttribute("booking", existingBooking);
        return "booking/form";
    }

    @PostMapping("/save")
    public String saveBooking(@ModelAttribute("booking") Booking booking) {
        if (booking.getBookingID() == 0) {
            bookingRepository.createBooking(booking);
        } else {
            bookingRepository.updateBooking(booking);
        }
        return "redirect:/booking-management";
    }

    @GetMapping("/cancel/{id}")
    public String cancelBooking(@PathVariable int id) {
        bookingRepository.cancelBooking(id);
        return "redirect:/booking-management";
    }
}
