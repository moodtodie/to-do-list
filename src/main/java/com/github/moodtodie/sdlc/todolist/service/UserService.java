package com.github.moodtodie.sdlc.todolist.service;

import com.github.moodtodie.sdlc.todolist.model.UserEntity;
import com.github.moodtodie.sdlc.todolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
  @Autowired
  UserRepository repository;

  public boolean addUser(String username, String password) {
    if (!findUser(username).isExist())
      return false;
    repository.save(new UserEntity(username, password));
    return true;
  }

  public UserEntity findUser(String username) {
    return repository.findByUsername(username).get();
  }

  public Iterable<UserEntity> getAll() {
    return repository.findAll();
  }

  @Override
  public User loadUserByUsername(String username) throws UsernameNotFoundException {
    var userFromDb = repository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("No user found with this email address."));
    List<GrantedAuthority> authorities = new java.util.ArrayList<>(Collections.emptyList());

    authorities.add((GrantedAuthority) userFromDb::getRole);

    return new User(userFromDb.getUsername(), userFromDb.getPassword(), authorities);
  }
}
