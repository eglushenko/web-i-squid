package com.github.webisquid.repo;

import com.github.webisquid.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
