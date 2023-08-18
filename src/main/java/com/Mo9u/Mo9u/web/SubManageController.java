package com.Mo9u.Mo9u.web;

import com.Mo9u.Mo9u.service.SubManageService;
import com.Mo9u.Mo9u.service.UserService;
import com.Mo9u.Mo9u.web.dto.HttpResponseDto;
import com.Mo9u.Mo9u.web.dto.SubManageRequestDto;
import com.Mo9u.Mo9u.web.dto.SubManageResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping ("/submanages")
public class SubManageController {

    private final SubManageService subManageService;
    private final UserService userService;

    //추가
    @PostMapping
    public ResponseEntity<HttpResponseDto> addSubManage(@RequestBody SubManageRequestDto subManageDto, Authentication auth) {
        String loginId = auth.getName();
        Long userId = userService.getUserIdByLoginId(loginId);

        List<SubManageResponseDto> subManageList = subManageService.getAll(userId);

        for (SubManageResponseDto existSub : subManageList) {
            if (existSub.getSubId().equals(subManageDto.getSubId())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(new HttpResponseDto(401, "이미 존재하는 구독서비스입니다"));
            }
        }

        subManageService.addSubManage(subManageDto, userService.getUserIdByLoginId(loginId));

        return ResponseEntity.status(HttpStatus.OK).body(new HttpResponseDto(200, "추가성공"));
    }


    //조회
    @GetMapping
    public ResponseEntity<HttpResponseDto> listSubManage(Authentication auth) {
        String loginId = auth.getName();
        Long userId = userService.getUserIdByLoginId(loginId);

        List<SubManageResponseDto> subManageList = subManageService.getAll(userId);

        if (subManageList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new HttpResponseDto(200, subManageList));
        } return ResponseEntity.status(HttpStatus.OK).body(new HttpResponseDto(200, subManageList));
    }

    //삭제
    @DeleteMapping("/{subManageId}")
    public ResponseEntity<HttpResponseDto> deleteSubManage(@PathVariable Long subManageId, Authentication auth) {
        String loginId = auth.getName();
        boolean result = subManageService.deleteSubManage(userService.getUserIdByLoginId(loginId),
            subManageId);
        if(result){
            return ResponseEntity.status(HttpStatus.OK).body(new HttpResponseDto(200, "삭제완료"));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
            .body(new HttpResponseDto(401, "해당 데이터의 삭제 권한이 없습니다"));
    }
}
