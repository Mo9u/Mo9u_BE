package com.Mo9u.Mo9u.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class SubManageDto {
        private Long id;
        private Long subId;
        private Long userId;
        private String name;
        private LocalDate creditDate;
        private int creditPrice;
        private String mainImage;

        @Builder
        public SubManageDto(Long id, Long subId, Long userId, String name, LocalDate creditDate, int creditPrice, String mainImage){
            this.id = id;
            this.subId = subId;
            this.userId = userId;
            this.name = name;
            this.creditDate = creditDate;
            this.creditPrice = creditPrice;
            this.mainImage = mainImage;
        }
}
