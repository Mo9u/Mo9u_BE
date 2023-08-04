package com.Mo9u.Mo9u.web;

import com.Mo9u.Mo9u.service.SubDetailService;
import com.Mo9u.Mo9u.web.dto.subDetailResultDto;
import com.Mo9u.Mo9u.web.dto.subscribeDetailDto;
import com.Mo9u.Mo9u.web.dto.subscribeDto;
//import jdk.javadoc.internal.tool.Messager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@RequiredArgsConstructor
public class SubDetailController {
    @Autowired
    private SubDetailService subDetailService;

    public SubDetailController(SubDetailService subDetailService){
        this.subDetailService = subDetailService;
    }

    @GetMapping("/sub/{id}")
    public ResponseEntity<subDetailResultDto> getSubDetail(@PathVariable Long id){
        subscribeDetailDto subDto = subDetailService.getSubDetail(id);
        return ResponseEntity.status(HttpStatus.OK).body(subDetailResultDto.createResult(200, subDto));
    }
}
