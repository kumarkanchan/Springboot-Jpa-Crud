package com.springboot.jpa.dao;

import com.springboot.jpa.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    public List<User> findByName(String name);
}
