package com.github.webisquid.repo;

import com.github.webisquid.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User,Long> {
}
