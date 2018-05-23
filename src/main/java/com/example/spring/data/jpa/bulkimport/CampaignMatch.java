package com.example.spring.data.jpa.bulkimport;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CampaignMatch {
    private Long platformId;
    private Long partnerId;
    private String externalId;
}
