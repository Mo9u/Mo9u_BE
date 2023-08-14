package com.Mo9u.Mo9u.repository;

import com.Mo9u.Mo9u.domain.Subscribe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubDetailRepository extends JpaRepository<Subscribe, Integer> {
    Subscribe findById(Long id);
}
