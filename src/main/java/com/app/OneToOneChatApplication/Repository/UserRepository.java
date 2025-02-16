package com.app.OneToOneChatApplication.Repository;

import com.app.OneToOneChatApplication.Entity.Status;
import com.app.OneToOneChatApplication.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    List<User> findAllByStatus(Status status);

}
