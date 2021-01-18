package ru.gmyrkin.crud.dao;

import ru.gmyrkin.crud.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();
}
