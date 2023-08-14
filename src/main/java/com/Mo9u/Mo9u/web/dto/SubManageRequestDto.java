package com.Mo9u.Mo9u.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class SubManageRequestDto {
        private Long subId;
    private LocalDate creditDate;
    private int creditPrice;

        @Builder
        public SubManageRequestDto(Long subId, LocalDate creditDate, int creditPrice){
            this.subId = subId;
            this.creditDate = creditDate;
            this.creditPrice = creditPrice;
        }
}
