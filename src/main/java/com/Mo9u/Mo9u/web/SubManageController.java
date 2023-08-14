package com.Mo9u.Mo9u.web;

import com.Mo9u.Mo9u.repository.UserRepository;
import com.Mo9u.Mo9u.service.SubManageService;
import com.Mo9u.Mo9u.service.UserService;
import com.Mo9u.Mo9u.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping ("/sub/manage")
public class SubManageController {

    private final SubManageService subManageService;

    // 추가
    @PostMapping
    public ResponseEntity<HttpResponseDto> addSubManage(@RequestBody SubManageRequestDto subManageDto) {
        subManageService.addSubManage(subManageDto, 1L);
        return ResponseEntity.status(HttpStatus.OK).body(new HttpResponseDto(200, "추가성공"));
    }


    //조회 (내 구독리스트 쫙~)
    @GetMapping("/list")
    public ResponseEntity<List> listSubManage() {
        List<SubManageResponseDto> subManageList = subManageService.getAll(1L);
        return ResponseEntity.status(HttpStatus.OK).body(subManageList);
    }


    //구독리스트 쫙 조회 (필리, 다다일상, 밀리의서재 ~~~)
    @GetMapping("/list/name")
        public ResponseEntity<List<SubListDto>> getAllSub() {
            List<SubListDto> subscriptions = subManageService.subIdName();
        return ResponseEntity.status(HttpStatus.OK).body(subscriptions);
    }


    //삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpResponseDto> deleteSubManage(@PathVariable Long id) {
        subManageService.deleteSubManage(id);
        return ResponseEntity.status(HttpStatus.OK).body(new HttpResponseDto(200, "삭제완료"));
    }
}
