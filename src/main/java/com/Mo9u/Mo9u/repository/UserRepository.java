package com.Mo9u.Mo9u.repository;

import com.Mo9u.Mo9u.domain.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByLoginId(String loginId);
}
