package com.example.spring.data.jpa.bulkimport;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * Base data of external campaign in DSP.
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dsp_campaign")
@EqualsAndHashCode(callSuper = false)
public class DspCampaign {
    @EmbeddedId
    private DspCampaignId id;

    @Column(name = "market", length = 2, nullable = false)
    private String market;

    @Column(name = "external_advertiser_id", nullable = false)
    private String externalAdvertiserId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "start_date")
    private Instant startDate;

    @Column(name = "end_date")
    private Instant endDate;

    @Column(name = "budget_cap")
    private BigDecimal budgetCap;
}
