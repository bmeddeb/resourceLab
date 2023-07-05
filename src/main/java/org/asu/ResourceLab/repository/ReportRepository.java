package org.asu.ResourceLab.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class ReportRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    // Resource Utilization Report
    public List<Map<String, Object>> getResourceUtilizationReport() {
        return jdbcTemplate.queryForList("SELECT ResourceID, COUNT(*) as bookingCount FROM Booking GROUP BY ResourceID");
    }

    // User Activity Report
    public List<Map<String, Object>> getUserActivityReport() {
        return jdbcTemplate.queryForList("SELECT UserID, COUNT(*) as bookingCount FROM Booking GROUP BY UserID");
    }

    // Cancelled Bookings Report
    public List<Map<String, Object>> getCancelledBookingsReport() {
        return jdbcTemplate.queryForList("SELECT UserID, COUNT(*) as cancelledBookingCount FROM Booking WHERE Status = 'Cancelled' GROUP BY UserID");
    }

    // Resource Status Report
    public List<Map<String, Object>> getResourceStatusReport() {
        return jdbcTemplate.queryForList("SELECT ResourceID, COUNT(*) as maintenanceCount FROM Maintenance GROUP BY ResourceID");
    }

    // Peak Usage Report
    // Peak Usage Report
    public List<Map<String, Object>> getPeakUsageReport() {
        List<Map<String, Object>> peakUsageList = new ArrayList<>();
        Map<String, Object> peakUsageMap = jdbcTemplate.queryForMap("SELECT HOUR(BookingStartTime) as hour, COUNT(*) as bookingCount FROM Booking GROUP BY HOUR(BookingStartTime) ORDER BY bookingCount DESC LIMIT 1");
        peakUsageList.add(peakUsageMap);
        return peakUsageList;
    }

}
