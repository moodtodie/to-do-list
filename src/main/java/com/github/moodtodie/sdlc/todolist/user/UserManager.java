package com.github.moodtodie.sdlc.todolist.user;

//import com.github.moodtodie.sdlc.todolist.model.UserEntity;
//import com.github.moodtodie.sdlc.todolist.model.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private final ArrayList<User> users = new ArrayList<>();
    private long availableUserId = 0;

//    private UserRepository repository;

    public UserManager(){
        //  get availableUserId form DB
        //  update users (ArrayList) using DB
    }

    public boolean addUser(String username, String password){
        for (User user: users) {
            if (user.username().equals(username))
                return false;
        }

        users.add(new User(availableUserId++, username, password));
        return true;
    }

    public boolean userExist(String username, String password){
        for (User user: users) {
            if (user.username().equals(username))
                if (user.password().equals(password))
                    return true;
                else
                    break;
        }
        return false;
    }

//    public List<UserEntity> getAll(){
//        return repository.findAll();
//    }
}
