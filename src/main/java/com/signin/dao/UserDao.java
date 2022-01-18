package com.signin.dao;

import com.signin.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Component("userDao")
public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * @param userName User's user name.
     * @return User query info inside database, create and return User object
     */
    public User getUserByUserName(String userName){
        return jdbcTemplate.execute((Connection connection) -> {
            try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM Users WHERE user_name=? ")) {
                ps.setObject(1, userName);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return new User(
                                rs.getLong("id"),
                                rs.getString("user_name"),
                                rs.getString("password"),
                                rs.getString("first_name"),
                                rs.getString("second_name"),
                                rs.getString("gender"),
                                rs.getString("language"),
                                rs.getString("address"),
                                rs.getDate("birth_date"),
                                rs.getDate("reg_date"),
                                rs.getString("nation"),
                                rs.getString("phone_number")
                        );
                    }
                }
            }
            throw new RuntimeException("ERROR querying database.");
        });
    }

    /**
     * @param user get info the user and insert it into database.
     * @return void
     */
    public void insertNewUser(User user) {
        if (1 != jdbcTemplate.update(("INSERT INTO Users (user_name, password, first_name, second_name, gender, language ,address, birth_date, reg_date, nation, phone_number) VALUES(?,?,?,?,?,?,?,?,?,?,?)"),
                user.getUserName(),
                user.getPassword(),
                user.getFirst_name(),
                user.getSecond_name(),
                user.getGender(),
                user.getLanguage(),
                user.getAddress(),
                user.getBirth_date(),
                user.getReg_date(),
                user.getNation(),
                user.getPhone_number())){
            throw new RuntimeException("ERROR inserting user.");
        }
    }
}
