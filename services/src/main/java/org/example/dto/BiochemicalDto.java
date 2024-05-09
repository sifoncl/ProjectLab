package org.example.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Builder
public class BiochemicalDto {
    private Integer id;

    private Integer userId;

    private Double alt;

    private Double ast;

    private Double creatinin;

    private Double mochevina;

    private Double bilirubinObsh;

    private Double bilirubinPriamoi;

    private Double bilirubinNepriamoi;

    private Double cholesterin;

    private Double glucose;

    private String getMatirial;

    private String addedResult;
}
