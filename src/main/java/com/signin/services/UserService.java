package com.signin.services;

import com.signin.dao.UserDao;
import com.signin.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
@Transactional
@Component("userService")
public class UserService {
    @Autowired
    UserDao userDao;
    public void insertNewUser(String userName, String password,String first_name, String second_name, String gender, String language, String address,
                              Date birth_date, Date reg_date, String nation, String phone_number){
        User user = new User(userName, password,first_name,second_name,gender,language,address,birth_date,reg_date,nation,phone_number);
        userDao.insertNewUser(user);
    }

    public User getUserByUserName(String userName){
        return userDao.getUserByUserName(userName);
    }
}
