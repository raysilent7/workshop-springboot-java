package com.raysilent.workshopspringboot.resources;

import com.raysilent.workshopspringboot.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User maria = new User("1", "Maria Silva", "maria@gmail.com");
        User rayan = new User("2", "Rayan Garcia", "rayan@gmail.com");
        User livia = new User("3", "Livia Flores", "livia@gmail.com");
        User pedro = new User("4", "Pedro Valadares", "pevalada@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria, rayan, livia, pedro));
        return ResponseEntity.ok().body(list);
    }
}
