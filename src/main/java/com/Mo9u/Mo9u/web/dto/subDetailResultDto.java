package com.Mo9u.Mo9u.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class subDetailResultDto {
    private int code;
    private Object result;

    public static subDetailResultDto createResult(int code, subscribeDetailDto subDto){
        return new subDetailResultDto(code, subDto);
    }

    public static subDetailResultDto createResult(int code, BindingResult bindingResult){
        return new subDetailResultDto(code, subDetailResultDto.MessageField.of(bindingResult));
    }
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MessageField {
        private String message;

        public static subDetailResultDto.MessageField of(String message) {
            subDetailResultDto.MessageField messageField = new subDetailResultDto.MessageField();
            messageField.setMessage(message);
            return messageField;
        }


        public static List<MessageField> of(BindingResult bindingResult) {
            List<subDetailResultDto.MessageField> messageFields = bindingResult.getAllErrors().stream().map(error ->
                    new subDetailResultDto.MessageField(((FieldError) error).getDefaultMessage())).collect(Collectors.toList());
            return messageFields;
        }
    }
}
