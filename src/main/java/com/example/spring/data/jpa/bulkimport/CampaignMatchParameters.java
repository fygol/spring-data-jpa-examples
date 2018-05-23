package com.example.spring.data.jpa.bulkimport;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CampaignMatchParameters {
    private String sfDspCode;

    private String market;

    private Platform.Status status;

    private LocalDate platformStartDate;

    private int dateDiff;
}
