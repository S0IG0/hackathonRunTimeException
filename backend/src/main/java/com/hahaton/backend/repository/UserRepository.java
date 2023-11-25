package com.hahaton.backend.repository;

import com.hahaton.backend.model.role.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
