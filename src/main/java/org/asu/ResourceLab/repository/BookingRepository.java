package org.asu.ResourceLab.repository;

import org.asu.ResourceLab.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookingRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    class BookingRowMapper implements RowMapper<Booking> {
        @Override
        public Booking mapRow(ResultSet rs, int rowNum) throws SQLException {
            Booking booking = new Booking();
            booking.setBookingID(rs.getInt("BookingID"));
            booking.setUserID(rs.getInt("UserID"));
            booking.setResourceID(rs.getInt("ResourceID"));
            booking.setBookingDate(rs.getTimestamp("BookingDate"));
            booking.setBookingStartTime(rs.getTimestamp("BookingStartTime"));
            booking.setBookingEndTime(rs.getTimestamp("BookingEndTime"));
            return booking;
        }
    }

    public Booking getBookingById(int id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM Booking WHERE BookingID=?", new Object[]{id}, new BookingRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<Booking> getAllBookings() {
        return jdbcTemplate.query("SELECT * FROM Booking", new BookingRowMapper());
    }

    public int deleteBooking(int id) {
        return jdbcTemplate.update("DELETE FROM Booking WHERE BookingID=?", new Object[]{id});
    }

    public int createBooking(Booking booking) {
        return jdbcTemplate.update("INSERT INTO Booking(UserID, ResourceID, BookingDate, BookingStartTime, BookingEndTime) VALUES (?, ?, ?, ?, ?)",
                new Object[]{booking.getUserID(), booking.getResourceID(), booking.getBookingDate(), booking.getBookingStartTime(), booking.getBookingEndTime()});
    }

    public int updateBooking(Booking booking) {
        return jdbcTemplate.update("UPDATE Booking SET UserID=?, ResourceID=?, BookingDate=?, BookingStartTime=?, BookingEndTime=? WHERE BookingID=?",
                new Object[]{booking.getUserID(), booking.getResourceID(), booking.getBookingDate(), booking.getBookingStartTime(), booking.getBookingEndTime(), booking.getBookingID()});
    }
}
