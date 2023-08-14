package com.Mo9u.Mo9u.service;

import com.Mo9u.Mo9u.domain.*;
import com.Mo9u.Mo9u.repository.SubDetailRepository;
import com.Mo9u.Mo9u.repository.SubManageRepository;
import com.Mo9u.Mo9u.repository.UserRepository;
import com.Mo9u.Mo9u.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubManageService {

    private final SubManageRepository subManageRepository;
    private final SubDetailRepository subDetailRepository;
    private final UserRepository userRepository;


    // 구독리스트에 추가
    @Transactional
    public void addSubManage(SubManageRequestDto subManageDto, Long userId) {
        Subscribe subscribe = subDetailRepository.findById(subManageDto.getSubId());
        if (subscribe == null) {
            throw new IllegalArgumentException("구독이 없습니다");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("유저를 찾을 수 없습니다"));

        Sub_manage subManage = Sub_manage.builder()
                .subscribe(subscribe)
                .user(user)
                .creditDate(subManageDto.getCreditDate())
                .creditPrice(subManageDto.getCreditPrice())
                .build();

        subManageRepository.save(subManage);

    }


    //구독관리리스트 불러오기
    public List<SubManageResponseDto> getAll(Long userId) {
        List<SubManageResponseDto> result = new ArrayList<>();

        List<Sub_manage> subManages = userRepository.findById(userId).get().getManages();
        for (Sub_manage subManage : subManages) {
            SubManageResponseDto dto = SubManageResponseDto.builder()
                    .id(subManage.getId())
                    .subId(subManage.getSubscribe().getId())
                    .creditPrice(subManage.getCreditPrice())
                    .creditDate(subManage.getCreditDate())
                    .subName(subManage.getSubscribe().getName())
                    .subImage(subManage.getSubscribe().getMainImage())
                    .build();
            result.add(dto);
        }
        return result;
    }

    //구독 리스트 조회
    @Transactional
    public List<SubListDto> subIdName() {
        List<Subscribe> subscriptions = subDetailRepository.findAll();
        List<SubListDto> result = new ArrayList<>();

        for (Subscribe subscription : subscriptions) {
            SubListDto dto = new SubListDto();
            dto.setSubId(subscription.getId());
            dto.setName(subscription.getName());
            result.add(dto);
        }

        return result;
    }

    //구독관리리스트 삭제
    @Transactional
    public void deleteSubManage(Long subManageId) {
        subManageRepository.deleteById(subManageId);
    }
}
