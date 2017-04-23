package com.manivchuk.objects;

import javax.validation.constraints.Size;

/**
 * Created by Lenovo on 28.03.2017.
 */
public class User {
    @Size(min = 3, message = "Имя должно быть больше 6 знаков")
    private String name;

    @Size(min = 5, max = 10, message = "Пароль должен быть от 5 до 10 знаков")
    private String password;
    private boolean admin;

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
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
}
