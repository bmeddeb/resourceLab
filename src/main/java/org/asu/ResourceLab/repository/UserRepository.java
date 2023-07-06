package org.asu.ResourceLab.repository;

import org.asu.ResourceLab.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;




    class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            Integer userID = rs.getObject("UserID", Integer.class);
            user.setUserID(userID);
            user.setUserName(rs.getString("UserName"));
            user.setUserEmail(rs.getString("UserEmail"));
            user.setUserPassword(rs.getString("UserPassword"));
            user.setUserContact(rs.getString("UserContact"));
            user.setRole(rs.getString("Role"));
            return user;
        }
    }

    public User getUserByUsername (String username) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM User WHERE UserName=?", new Object[]{username}, new UserRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public int createUser(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getUserPassword());
        return jdbcTemplate.update("INSERT INTO User(UserName, UserEmail, UserPassword, UserContact, Role) VALUES (?, ?, ?, ?, ?)",
                new Object[]{user.getUserName(), user.getUserEmail(), encodedPassword, user.getUserContact(), user.getRole()});
    }

    public User getUserById(int id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM User WHERE UserID=?", new Object[]{id}, new UserRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<User> getAllUsers() {
        return jdbcTemplate.query("SELECT * FROM User WHERE Role != ?", new Object[]{"deleted"}, new UserRowMapper());
    }


    public int deleteUser(int id) {
        // Update the User's role to 'deleted' instead of deleting the record.
        return jdbcTemplate.update("UPDATE User SET Role = ? WHERE UserID = ?", new Object[]{"deleted", id});
    }



    public int updateUser(User user) {
        return jdbcTemplate.update("UPDATE User SET UserName=?, UserEmail=?, UserPassword=?, UserContact=?, Role=? WHERE UserID=?",
                new Object[]{user.getUserName(), user.getUserEmail(), user.getUserPassword(), user.getUserContact(), user.getRole(), user.getUserID()});
    }
}
