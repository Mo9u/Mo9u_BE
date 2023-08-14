package com.Mo9u.Mo9u.web;

import com.Mo9u.Mo9u.service.SubService;
import com.Mo9u.Mo9u.web.dto.HttpResponseDto;
import com.Mo9u.Mo9u.web.dto.ResultDto;
import com.Mo9u.Mo9u.web.dto.SubListResponseDto;
import com.Mo9u.Mo9u.web.dto.SubscribeDetailDto;
import java.util.List;

import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/sub")
public class SubController {

    private final SubService subDetailService;

    @GetMapping("/{id}")
    public ResponseEntity<HttpResponseDto> getSubDetail(@PathVariable Long id){
        SubscribeDetailDto subDto = subDetailService.getSubDetail(id);

        if(subDto == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new HttpResponseDto(400, "잘못된 sub ID 입니다."));
        }
        return ResponseEntity.status(HttpStatus.OK).body(new HttpResponseDto(200, subDto));
    }

    @GetMapping("/list")
    public ResponseEntity<List> getSubList(){
        List<SubListResponseDto> subList = subDetailService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(subList);
    }
}
