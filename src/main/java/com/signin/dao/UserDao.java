package com.signin.dao;

import com.signin.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Component("userDao")
public class UserDao {
    @Autowired
    HibernateTemplate hibernateTemplate;

    @Autowired
    PlatformTransactionManager transactionManager;
    /**
     * @param userName User's user name.
     * @return User query info inside database, create and return User object
     */
    public User getUserByUserName(String userName){
        User example = new User();
        example.setUserName(userName);
        return hibernateTemplate.findByExample(example).get(0);
    }

    /**
     * @param user get info the user and insert it into database.
     * @return void
     */
    @Transactional
    public void insertNewUser(User user) {
        hibernateTemplate.save(user);
    }
}
