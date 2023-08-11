package com.Mo9u.Mo9u.repository;

import com.Mo9u.Mo9u.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
