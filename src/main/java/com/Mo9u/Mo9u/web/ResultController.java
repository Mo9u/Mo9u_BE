package com.Mo9u.Mo9u.web;

import com.Mo9u.Mo9u.service.ResultService;
import com.Mo9u.Mo9u.web.dto.ResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ResultController {
    @Autowired
    private final ResultService resultService;

    @GetMapping("/test/{id}")
    public ResponseEntity<ResultDto> getResult(@PathVariable Long id){
        ResultDto ResDto = resultService.getResult(id);
        return ResponseEntity.status(HttpStatus.OK).body(ResDto);

    }
}
