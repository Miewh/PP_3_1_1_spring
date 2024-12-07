package web.PP_3_1_1_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.PP_3_1_1_spring.dao.UserDao;
import web.PP_3_1_1_spring.model.User;

import java.util.List;

@Service
public class UserService {

    public final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }
    @Transactional
    public void addUser(User user) {
        userDao.save(user);
    }
    @Transactional
    public void updateUser(User user) {
        userDao.update(user);
    }
    @Transactional
    public void deleteUserById(Long id) {
        userDao.delete(id);
    }
    @Transactional
    public User getUserById(Long id) {
        return userDao.findById(id);
    }
    @Transactional
    public List<User> getAllUsers() {
        return userDao.findAll();
    }
}
