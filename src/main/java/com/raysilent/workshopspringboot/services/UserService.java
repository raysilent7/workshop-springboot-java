package com.raysilent.workshopspringboot.services;

import com.raysilent.workshopspringboot.domain.User;
import com.raysilent.workshopspringboot.dto.UserDto;
import com.raysilent.workshopspringboot.repository.UserRepository;
import com.raysilent.workshopspringboot.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj) {
        return repo.insert(obj);
    }

    public User fromDTO(UserDto objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }

    public void delete(String id) {
        findById(id);
        repo.deleteById(id);
    }
}
