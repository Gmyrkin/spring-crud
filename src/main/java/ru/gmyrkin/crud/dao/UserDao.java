package ru.gmyrkin.crud.dao;

import ru.gmyrkin.crud.model.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);
    void updateUser (User user);
    User getUserId (long id); // поиск по ID
    List<User> getAllUsers ();
    void deleteUser (User user);

}
