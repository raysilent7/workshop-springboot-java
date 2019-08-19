package com.raysilent.workshopspringboot.repository;

import com.raysilent.workshopspringboot.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{'title': { $regex: ?0, $options: 'i' } }")
    List<Post> searchTitle(String text);

    @Query("{ $and: [ {date: {$gte: ?1} }, { date: { $lte: ?2} } ," +
            " { $or: [ {'title': { $regex: ?0, $options: 'i' } }, " +
            "{'body': { $regex: ?0, $options: 'i' } }, " +
            "{'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Post> findByAny(String text, Date minDate, Date maxDate);

    List<Post> findByTitleContainingIgnoreCase(String text);
}
