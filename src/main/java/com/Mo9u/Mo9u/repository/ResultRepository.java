package com.Mo9u.Mo9u.repository;

import com.Mo9u.Mo9u.domain.Result_type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result_type, Integer> {
    Result_type findBySubscribeId(Long id);
}
