package com.example.codingchallenge.repository;

import com.example.codingchallenge.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserModelRepository extends JpaRepository<UserModel,Long> {
    Optional<UserModel> findByEmail(String email);
    Optional<UserModel> findByEmailAndPassword(String email,String password);
    List<UserModel> findAll();
}
