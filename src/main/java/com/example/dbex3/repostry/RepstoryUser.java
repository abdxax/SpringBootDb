package com.example.dbex3.repostry;

import com.example.dbex3.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepstoryUser extends JpaRepository<User,Integer> {
    User findByUsernameAndPassword(String userName,String password);
    User findByEmail(String email);
    List<User> findAllByRole(String role);
    //List<User> findByAgeAndAgeAfter(int age);
    @Query("select  u from User  u where u.age>=?1")
    List<User> findages(int age);
}
