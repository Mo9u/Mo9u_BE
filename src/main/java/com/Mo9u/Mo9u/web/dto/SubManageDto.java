package com.Mo9u.Mo9u.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class SubManageDto {
        private Long subId;
        private LocalDate creditDate;
        private int creditPrice;

        @Builder
        public SubManageDto(Long subId, LocalDate creditDate, int creditPrice){
            this.subId = subId;
            this.creditDate = creditDate;
            this.creditPrice = creditPrice;
        }
}
