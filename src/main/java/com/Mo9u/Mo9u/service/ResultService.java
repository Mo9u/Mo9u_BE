package com.Mo9u.Mo9u.service;

import com.Mo9u.Mo9u.domain.Result_type;
import com.Mo9u.Mo9u.repository.ResultRepository;
import com.Mo9u.Mo9u.web.dto.ResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ResultService {

    private final ResultRepository resultRepository;

    public ResultDto getResult(Long id) {
        Result_type result = resultRepository.findById(id);

        if (result != null) {
            return ResultDto.builder()
                    .id(result.getSubscribe().getId())
                    .content(result.getContent())
                    .simpleContent(result.getSubscribe().getSimpleContent())
                    .name(result.getSubscribe().getName())
                    .mainImage(result.getSubscribe().getMainImage())
                    .build();
        } else {
            throw new RuntimeException("해당 ID의 테스트 결과를 찾을 수 없습니다.");
        }
    }
}
