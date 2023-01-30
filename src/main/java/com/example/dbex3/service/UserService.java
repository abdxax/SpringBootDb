package com.example.dbex3.service;

import com.example.dbex3.models.User;
import com.example.dbex3.repostry.RepstoryUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final RepstoryUser repstoryUser;

    public List<User> getAll(){
        return repstoryUser.findAll();
    }
    public User addUser(User user){
        return repstoryUser.save(user);
    }

    public Boolean upateUser(Integer id,User user){
        User oldUser=repstoryUser.getById(id);
        if(oldUser==null){
            return false;
        }
        oldUser.setName(user.getName());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        oldUser.setRole(user.getRole());
        oldUser.setAge(user.getAge());
        repstoryUser.save(oldUser);
        return true;
    }

    public Boolean delete(Integer id){
        User oldUser=repstoryUser.getById(id);
        if(oldUser==null){
            return false;
        }

        repstoryUser.delete(oldUser);
        return true;
    }
}
