package com.signin;

import com.signin.entity.User;
import com.signin.services.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Date;


public class App {


    public static void main(String[] args) {

    }
    public static void insertNewUser(String userName, String password,String first_name, String second_name, String gender, String language,String address,
                                     Date birth_date, Date reg_date, String nation, String phone_number){
        try{
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
            UserService userService = context.getBean(UserService.class);
            userService.insertNewUser(userName, password, first_name,second_name,gender, language,address,
                    birth_date, reg_date,nation,phone_number);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static User getUser(String userName){
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
            UserService userService = context.getBean(UserService.class);
            return userService.getUserByUserName(userName);
    }
}
