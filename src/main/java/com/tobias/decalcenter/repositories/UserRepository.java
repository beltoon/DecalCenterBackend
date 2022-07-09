package com.tobias.decalcenter.repositories;

import com.tobias.decalcenter.models.User;
import com.tobias.decalcenter.services.UserService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    UserService findByUsername(String username);
}