package com.alex.bootiful.security.repository;

import com.alex.bootiful.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * qinke-coupons com.alex.bootiful.security.repository.UserRepository
 *
 * @author Alex bob(https://github.com/vnobo)
 * @date Created by 2019/4/23
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
