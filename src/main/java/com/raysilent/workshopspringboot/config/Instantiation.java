package com.raysilent.workshopspringboot.config;

import com.raysilent.workshopspringboot.domain.Post;
import com.raysilent.workshopspringboot.domain.User;
import com.raysilent.workshopspringboot.dto.AuthorDto;
import com.raysilent.workshopspringboot.dto.CommentDto;
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

        userRepository.saveAll(Arrays.asList(mariana, rayan, livia));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem!", "Vou viajar para Sao Paulo, abracos!", new AuthorDto(mariana));
        Post post2 = new Post(null, sdf.parse("11/04/2019"), "Bom dia!", "Acordei feliz hoje!", new AuthorDto(mariana));

        CommentDto c1 = new CommentDto("Boa viagem, maninha!", sdf.parse("21/03/2018"), new AuthorDto(rayan));
        CommentDto c2 = new CommentDto("Aproveite bastante!", sdf.parse("21/03/2018"), new AuthorDto(livia));
        CommentDto c3 = new CommentDto("Que otimo, fico mt feliz, maninha!", sdf.parse("11/04/2019"), new AuthorDto(rayan));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        mariana.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(mariana);
    }
}
