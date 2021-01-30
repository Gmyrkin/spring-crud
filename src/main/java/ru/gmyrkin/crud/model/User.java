package ru.gmyrkin.crud.model;

import ru.gmyrkin.crud.services.UserService;

import javax.persistence.*;

@Entity
@Table (name = "userstable")
public class User {
    @Id             // уникального поле для таблице
    @Column (name = "id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)// автоматич ID генерируется при создании
    private long id;
    @Column         // разделение на отдельные колонки
    private String name;
    @Column
    private String password;

    public User(long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }


    public Long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
