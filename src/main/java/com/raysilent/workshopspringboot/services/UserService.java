package com.raysilent.workshopspringboot.services;

import com.raysilent.workshopspringboot.domain.User;
import com.raysilent.workshopspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }
}
