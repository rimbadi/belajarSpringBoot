package com.example.demo.services;

import com.example.demo.models.User;

import java.util.List;

public interface UserServices {
    public List<User> getAll();

    public User getByID(Integer id);

    public Integer findByEmail(String email);

    public Boolean save(User user);

    public Boolean delete(Integer id);
    public String log(String email, String password);
    public String getEmail(String email);
}
