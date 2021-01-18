package ru.gmyrkin.crud.services;

import ru.gmyrkin.crud.model.User;

import java.util.List;

public interface UserService {
    User add (User user); // чтоб изм. сразу отправлялись на страницу
    void delete (long id);
    User edit (User user);
    List<User> getAll ();

}
