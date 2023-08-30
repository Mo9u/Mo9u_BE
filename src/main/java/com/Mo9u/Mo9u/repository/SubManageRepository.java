package com.Mo9u.Mo9u.repository;

import com.Mo9u.Mo9u.domain.Sub_manage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubManageRepository extends JpaRepository<Sub_manage, Long> {
    Optional<Sub_manage> findById(Long id);
}
