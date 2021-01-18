package ru.gmyrkin.crud.dao;

import org.springframework.stereotype.Repository;
import ru.gmyrkin.crud.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {


    @Override
    public List<User> getAll() {
        return List.of(
                new User("Dima","Zh",36)
        );
    }
}
