package com.raysilent.workshopspringboot.config;

import com.raysilent.workshopspringboot.domain.Post;
import com.raysilent.workshopspringboot.domain.User;
import com.raysilent.workshopspringboot.repository.PostRepository;
import com.raysilent.workshopspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User mariana = new User(null, "Mariana Garcia", "mariangel@gmail.com");
        User rayan = new User(null, "Rayan Garcia", "rayan@gmail.com");
        User livia = new User(null, "Livia Flores", "liviafofinha@gmail.com");

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem!", "Vou viajar para Sao Paulo, abracos!", mariana);
        Post post2 = new Post(null, sdf.parse("11/04/2019"), "Bom dia!", "Acordei feliz hoje!", mariana);

        userRepository.saveAll(Arrays.asList(mariana, rayan, livia));
        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
