package com.Mo9u.Mo9u.service;

import com.Mo9u.Mo9u.domain.How_exit;
import com.Mo9u.Mo9u.domain.How_sub;
import com.Mo9u.Mo9u.domain.Result_type;
import com.Mo9u.Mo9u.domain.Subscribe;
import com.Mo9u.Mo9u.repository.ResultRepository;
import com.Mo9u.Mo9u.repository.SubDetailRepository;
import com.Mo9u.Mo9u.web.dto.ResultDto;
import com.Mo9u.Mo9u.web.dto.subscribeDetailDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ResultService {

    private final ResultRepository resultRepository;
    private final SubDetailRepository subDetailRepository;

    @Transactional(readOnly = true)
    public ResultDto getResult(Long id) {
        Result_type result = resultRepository.findBySubscribeId(id);

        if (result != null) {
            return ResultDto.builder()
                    .Id(result.getSubscribe().getId())
                    .content(result.getContent())
                    .intro(result.getIntro())
                    .name(result.getName())
                    .resImage(result.getResImage())
                    .build();
        } else {
            throw new RuntimeException("해당 ID의 테스트 결과를 찾을 수 없습니다.");
        }
    }
}
