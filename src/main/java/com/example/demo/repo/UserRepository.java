package com.example.demo.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.User;

public interface UserRepository extends JpaRepository< User, Integer>{
    @Query(value = "SELECT u.iduser FROM User u WHERE u.email = ?1", nativeQuery = true)
    public Integer findByEmail(String email);

    @Query(value = "SELECT u.email, u.password FROM User u WHERE u.email=?1 && u.password = ?2", nativeQuery = true)
    public String log(String email, String password);

    @Query(value = "SELECT u.email FROM User u WHERE u.email=?1", nativeQuery = true)
    public String getEmail(String email);
}
