package org.asu.ResourceLab.repository;

import org.asu.ResourceLab.model.Maintenance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MaintenanceRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    class MaintenanceRowMapper implements RowMapper<Maintenance> {
        @Override
        public Maintenance mapRow(ResultSet rs, int rowNum) throws SQLException {
            Maintenance maintenance = new Maintenance();
            maintenance.setMaintenanceID(rs.getInt("MaintenanceID"));
            maintenance.setResourceID(rs.getInt("ResourceID"));
            maintenance.setUserID(rs.getInt("UserID"));
            maintenance.setMaintenanceDate(rs.getDate("MaintenanceDate"));
            maintenance.setMaintenanceDetails(rs.getString("MaintenanceDetails"));
            return maintenance;
        }
    }


    public Maintenance getMaintenanceById(int id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM Maintenance WHERE MaintenanceID=?", new Object[]{id}, new MaintenanceRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<Maintenance> getAllMaintenances() {
        return jdbcTemplate.query("SELECT * FROM Maintenance", new MaintenanceRowMapper());
    }

    public int deleteMaintenance(int id) {
        return jdbcTemplate.update("DELETE FROM Maintenance WHERE MaintenanceID=?", new Object[]{id});
    }

    public int createMaintenance(Maintenance maintenance) {
        return jdbcTemplate.update("INSERT INTO Maintenance(ResourceID, UserID, MaintenanceDate, MaintenanceDetails) VALUES (?, ?, ?, ?)",
                new Object[]{maintenance.getResourceID(), maintenance.getUserID(), maintenance.getMaintenanceDate(), maintenance.getMaintenanceDetails()});
    }

    public int updateMaintenance(Maintenance maintenance) {
        return jdbcTemplate.update("UPDATE Maintenance SET ResourceID=?, UserID=?, MaintenanceDate=?, MaintenanceDetails=? WHERE MaintenanceID=?",
                new Object[]{maintenance.getResourceID(), maintenance.getUserID(), maintenance.getMaintenanceDate(), maintenance.getMaintenanceDetails(), maintenance.getMaintenanceID()});
    }

}
