package com.example.demo.services;

import com.example.demo.models.User;
import com.example.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserServices{
    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getByID(Integer id) {
        return userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("User not found"));
    }

    @Override
    public Integer findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Boolean save(User user) {
        userRepository.save(user);
        return userRepository.findById(user.getId()).isPresent();
    }

    @Override
    public Boolean delete(Integer id) {
        userRepository.deleteById(id);
        return userRepository.findById(id).isPresent();
    }

    @Override
    public String log(String email, String password) {
        return userRepository.log(email, password);
    }

    @Override
    public String getEmail(String email) {
        return userRepository.getEmail(email);
    }
}
