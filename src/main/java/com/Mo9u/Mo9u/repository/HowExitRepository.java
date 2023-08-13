package com.Mo9u.Mo9u.repository;

import com.Mo9u.Mo9u.domain.How_exit;
import com.Mo9u.Mo9u.domain.How_sub;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HowExitRepository extends JpaRepository<How_exit, Integer> {
    List<How_exit> findBySubscribeId(Long id);
}