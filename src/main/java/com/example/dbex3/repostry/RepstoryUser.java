package com.example.dbex3.repostry;

import com.example.dbex3.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepstoryUser extends JpaRepository<User,Integer> {
}
