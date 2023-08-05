package com.Mo9u.Mo9u.web;

import com.Mo9u.Mo9u.service.SubDetailService;
import com.Mo9u.Mo9u.web.dto.SubListResponseDto;
import com.Mo9u.Mo9u.web.dto.subDetailResultDto;
import com.Mo9u.Mo9u.web.dto.subscribeDetailDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/sub")
public class SubController {
    @Autowired
    private final SubDetailService subDetailService;

    @GetMapping("/{id}")
    public ResponseEntity<subDetailResultDto> getSubDetail(@PathVariable Long id){
        subscribeDetailDto subDto = subDetailService.getSubDetail(id);
        return ResponseEntity.status(HttpStatus.OK).body(subDetailResultDto.createResult(200, subDto));
    }

    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @GetMapping("/list")
    public ResponseEntity<List> getSubList(){
        List<SubListResponseDto> subList = subDetailService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(subList);
    }
}
