package com.Mo9u.Mo9u.service;

import com.Mo9u.Mo9u.domain.How_exit;
import com.Mo9u.Mo9u.domain.How_sub;
import com.Mo9u.Mo9u.domain.Subscribe;
import com.Mo9u.Mo9u.repository.HowExitRepository;
import com.Mo9u.Mo9u.repository.HowSubRepository;
import com.Mo9u.Mo9u.repository.SubDetailRepository;
import com.Mo9u.Mo9u.web.dto.SubListResponseDto;
import com.Mo9u.Mo9u.web.dto.SubscribeDetailDto;
import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SubDetailService {
    private final SubDetailRepository subDetailRepository;
    private final HowSubRepository howSubRepository;
    private final HowExitRepository howExitRepository;

    @Transactional
    public SubscribeDetailDto getSubDetail(Long sub_id){
        Subscribe subscribe = subDetailRepository.findById(sub_id);

        List<How_sub> howSubs = howSubRepository.findBySubscribeId(sub_id);

        // 구독 방법 배열
        List<String> subContentList = howSubs.stream().map(How_sub::getHowExplain).collect(Collectors.toList());
        String[] subContents = subContentList.toArray(new String[subContentList.size()]);

        // 구독 사진 배열
        List<String> subImgList = howSubs.stream().map(How_sub::getHowImage).collect(Collectors.toList());
        String[] subImgs = subImgList.toArray(new String[subImgList.size()]);

        List<How_exit> howExits = howExitRepository.findBySubscribeId(sub_id);

        // 해지 방법 배열
        List<String> exitContentList = howExits.stream().map(How_exit::getHowExplain).collect(Collectors.toList());
        String[] exitContents = exitContentList.toArray(new String[exitContentList.size()]);

        // 해지 사진 배열
        List<String> exitImgList = howExits.stream().map(How_exit::getHowImage).collect(Collectors.toList());
        String[] exitImgs = exitImgList.toArray(new String[exitImgList.size()]);

        // 본문 split
        String[] newMainContent = subscribe.getMainContent().split("/");
        SubscribeDetailDto subDto = SubscribeDetailDto.builder()
                .id(subscribe.getId())
                .category(subscribe.getCategory())
                .mainImage(subscribe.getMainImage())
                .name(subscribe.getName())
                .simpleContent(subscribe.getSimpleContent())
                .mainContent(newMainContent)
                .maxPrice(subscribe.getMaxPrice())
                .avgPrice(subscribe.getAvgPrice())
                .minPrice(subscribe.getMinPrice())
                .link(subscribe.getLink())
                .howSubImg(subImgs)
                .howSubExplain(subContents)
                .howExitImg(exitImgs)
                .howExitExplain(exitContents)
                .build();
       return subDto;
    }

    public List<SubListResponseDto> getAll() {
        List<SubListResponseDto> result = new ArrayList<>();
        for (Subscribe s : subDetailRepository.findAll()) {
            SubListResponseDto sub = SubListResponseDto.builder()
                .id(s.getId())
                .category(s.getCategory())
                .mainImage(s.getMainImage())
                .name(s.getName())
                .simpleContent(s.getSimpleContent()).build();
            result.add(sub);
        }

        return result;
    }
}
