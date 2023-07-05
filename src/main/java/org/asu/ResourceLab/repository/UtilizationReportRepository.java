package org.asu.ResourceLab.repository;

import org.asu.ResourceLab.model.UtilizationReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UtilizationReportRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    class UtilizationReportRowMapper implements RowMapper<UtilizationReport> {
        @Override
        public UtilizationReport mapRow(ResultSet rs, int rowNum) throws SQLException {
            UtilizationReport utilizationReport = new UtilizationReport();
            utilizationReport.setReportID(rs.getInt("ReportID"));
            utilizationReport.setResourceID(rs.getInt("ResourceID"));
            utilizationReport.setUserID(rs.getInt("UserID"));
            utilizationReport.setGeneratedDate(rs.getTimestamp("GeneratedDate"));
            utilizationReport.setUtilizationData(rs.getString("UtilizationData"));
            return utilizationReport;
        }
    }

    public UtilizationReport getReportById(int id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM UtilizationReport WHERE ReportID=?", new Object[]{id}, new UtilizationReportRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<UtilizationReport> getAllReports() {
        return jdbcTemplate.query("SELECT * FROM UtilizationReport", new UtilizationReportRowMapper());
    }

    public int deleteReport(int id) {
        return jdbcTemplate.update("DELETE FROM UtilizationReport WHERE ReportID=?", new Object[]{id});
    }

    public int createReport(UtilizationReport utilizationReport) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement("INSERT INTO UtilizationReport(ResourceID, UserID, GeneratedDate, UtilizationData) VALUES (?, ?, ?, ?)", new String[] {"ReportID"});
            ps.setInt(1, utilizationReport.getResourceID());
            ps.setInt(2, utilizationReport.getUserID());
            ps.setTimestamp(3, new java.sql.Timestamp(utilizationReport.getGeneratedDate().getTime()));
            ps.setString(4, utilizationReport.getUtilizationData());
            return ps;
        }, keyHolder);

        return keyHolder.getKey().intValue();
    }


    public int updateReport(UtilizationReport utilizationReport) {
        return jdbcTemplate.update("UPDATE UtilizationReport SET ResourceID=?, UserID=?, GeneratedDate=?, UtilizationData=? WHERE ReportID=?",
                new Object[]{utilizationReport.getResourceID(), utilizationReport.getUserID(), utilizationReport.getGeneratedDate(), utilizationReport.getUtilizationData(), utilizationReport.getReportID()});
    }
}
