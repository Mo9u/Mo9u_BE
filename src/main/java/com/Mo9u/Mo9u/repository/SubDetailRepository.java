package com.Mo9u.Mo9u.repository;

import com.Mo9u.Mo9u.domain.How_sub;
import com.Mo9u.Mo9u.domain.Subscribe;
import com.Mo9u.Mo9u.web.dto.subscribeDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubDetailRepository extends JpaRepository<Subscribe, Integer> {
    Subscribe findById(Long id);
}
