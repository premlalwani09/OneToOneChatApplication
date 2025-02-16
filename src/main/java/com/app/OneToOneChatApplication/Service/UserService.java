package com.app.OneToOneChatApplication.Service;

import com.app.OneToOneChatApplication.Entity.Status;
import com.app.OneToOneChatApplication.Entity.User;
import com.app.OneToOneChatApplication.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;


    public void saveUser(User user){

        user.setStatus(Status.ONLINE);
        repository.save(user);
    }

    public void disconnect(User user){

        var storedUser = repository.findById(user.getNickName()).orElse(null);

        if (storedUser != null){
            storedUser.setStatus(Status.OFFLINE);
            repository.save(storedUser);
        }
    }

    public List<User> findConnectedUsers(){

        return repository.findAllByStatus(Status.ONLINE);
    }


}
