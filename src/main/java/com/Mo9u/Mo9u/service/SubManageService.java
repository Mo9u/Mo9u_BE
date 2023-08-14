package com.Mo9u.Mo9u.service;

import com.Mo9u.Mo9u.domain.*;
import com.Mo9u.Mo9u.repository.SubDetailRepository;
import com.Mo9u.Mo9u.repository.SubManageRepository;
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
    //private final UserRepository userRepository;

    @Transactional
    public Long addSubManage(SubManageDto subManageDto) {
        Subscribe subscribe = subDetailRepository.findByName(subManageDto.getName());

        /*
        UserLoginDto userLoginDto = UserLoginDto.builder()
                .id(subManageDto.getUserId()) // Use the getId() method
                .build();
        */

        Sub_manage subManage = Sub_manage.builder()
                .subId(subscribe) // Set the subscription ID
                .creditDate(subManageDto.getCreditDate())
                .creditPrice(subManageDto.getCreditPrice())
                .build();

        Sub_manage savedSubManage = subManageRepository.save(subManage);

        return savedSubManage.getId();
    }


    //구독관리리스트 불러오기
    public List<SubManageDto> getAll() {
        List<SubManageDto> result = new ArrayList<>();
        for (Sub_manage s : subManageRepository.findAll()) {
            SubManageDto sub = SubManageDto.builder()
                    .id(s.getId())
                    .subId(s.getSubId().getId())
                    .userId(s.getUserId().getId())
                    .name(s.getSubId().getName())
                    .creditDate(s.getCreditDate())
                    .creditPrice(s.getCreditPrice())
                    .mainImage(s.getSubId().getMainImage()).build();
            result.add(sub);
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
