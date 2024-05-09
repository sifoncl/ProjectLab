package org.example.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class OAKDto {
    private Integer id;

    private Integer userId;

    private Integer rbc;

    private Integer wbc;

    private Integer trombocitis;

    private Double hb;

    private Double hematocritis;

    private Double cp;

    private Double reticulocitis;

    private Double soe;

    private Double palochkoydernieGranulociti;

    private Double segmentoydernieGranulociti;

    private Double eosinofiles;

    private Double basofiles;

    private Double limfocities;

    private Double monocities;

    private Double metolmielocites;

    private Double mielocities;

    private String getMatirial;

    private String addedResult;
}
