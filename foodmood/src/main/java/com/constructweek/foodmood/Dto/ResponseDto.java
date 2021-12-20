package com.constructweek.foodmood.Dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class ResponseDto {
    private String response;
    public ResponseDto(String response) {
        this.response = response;
    }
}
