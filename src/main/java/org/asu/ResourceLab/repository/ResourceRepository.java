package org.asu.ResourceLab.repository;

import org.asu.ResourceLab.model.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ResourceRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    class ResourceRowMapper implements RowMapper<Resource> {
        @Override
        public Resource mapRow(ResultSet rs, int rowNum) throws SQLException {
            Resource resource = new Resource();
            resource.setResourceID(rs.getInt("ResourceID"));
            resource.setResourceName(rs.getString("ResourceName"));
            resource.setResourceDescription(rs.getString("ResourceDescription"));
            resource.setResourceStatus(rs.getString("ResourceStatus"));
            resource.setMaintenanceStatus(rs.getString("MaintenanceStatus"));
            return resource;
        }
    }

    public Resource getResourceById(int id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM Resource WHERE ResourceID=?", new Object[]{id}, new ResourceRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<Resource> getAllResources() {
        return jdbcTemplate.query("SELECT * FROM Resource", new ResourceRowMapper());
    }

    public int deleteResource(int id) {
        return jdbcTemplate.update("DELETE FROM Resource WHERE ResourceID=?", new Object[]{id});
    }

    public int createResource(Resource resource) {
        return jdbcTemplate.update("INSERT INTO Resource(ResourceName, ResourceDescription, ResourceStatus, MaintenanceStatus) VALUES (?, ?, ?, ?)",
                new Object[]{resource.getResourceName(), resource.getResourceDescription(), resource.getResourceStatus(), resource.getMaintenanceStatus()});
    }

    public int updateResource(Resource resource) {
        return jdbcTemplate.update("UPDATE Resource SET ResourceName=?, ResourceDescription=?, ResourceStatus=?, MaintenanceStatus=? WHERE ResourceID=?",
                new Object[]{resource.getResourceName(), resource.getResourceDescription(), resource.getResourceStatus(), resource.getMaintenanceStatus(), resource.getResourceID()});
    }
}
