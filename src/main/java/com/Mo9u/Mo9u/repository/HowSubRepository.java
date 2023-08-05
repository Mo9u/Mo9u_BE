package com.Mo9u.Mo9u.repository;

import com.Mo9u.Mo9u.domain.How_sub;
import com.Mo9u.Mo9u.domain.Subscribe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HowSubRepository extends JpaRepository<How_sub, Integer> {
    List<How_sub> findBySubscribeId(Long id);
}