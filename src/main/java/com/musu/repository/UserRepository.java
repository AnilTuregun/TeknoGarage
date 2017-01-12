package com.musu.repository;

import com.musu.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);


    @Query("DELETE FROM User u WHERE u.username =:id")
    int deleteUser(@Param("id") int id);
        }
