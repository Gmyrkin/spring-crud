package ru.gmyrkin.crud.services;

import org.springframework.stereotype.Service;
import ru.gmyrkin.crud.dao.UserDao;
import ru.gmyrkin.crud.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User add(User user) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public User edit(User user) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }
}
