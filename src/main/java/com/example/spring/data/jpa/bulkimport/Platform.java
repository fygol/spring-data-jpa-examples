package com.example.spring.data.jpa.bulkimport;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Platform entity.
 */
@Data
@ToString(exclude = {"campaignAllocation"})
@EqualsAndHashCode(exclude = {"campaignAllocation"}, callSuper = false)
@Table(name = "platform")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Platform extends BaseEntity<Long> {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "sf_id", length = 18)
    private String sfId;
    @Column(name = "csf_id")
    private Long csfId;
    @Column(name = "sf_subcampaign_id")
    private String sfSubcampaignId;
    @Column(name = "dsp")
    private String dsp;
    @Column(name = "name")
    private String name;
    @Column(name = "currency_iso", length = 3)
    private String currencyIsoCode;
    @Column(name = "net_budget")
    private BigDecimal mediaBudget;
    @Column(name = "flight_start_date")
    private LocalDate flightStartDate;
    @Column(name = "flight_end_date")
    private LocalDate flightEndDate;
    @Column(name = "scp_id", length = 80)
    private String scpId;
    @Column(name = "media_type")
    private String mediaType;
    @Column(name = "deleted")
    private boolean deleted = false;
    @Column(name = "csf_version")
    private Long csfVersion;
    @Column(name = "csf_last_modified_date")
    private LocalDateTime csfModificationDate;
    @Column(name = "sf_modification_date")
    private LocalDateTime sfModificationDate;
    @ManyToOne
    @JoinColumn(name = "campaign_allocation_id")
    private CampaignAllocation campaignAllocation;

//    @OneToMany(mappedBy = "platform", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
//    private List<Campaign> campaigns = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Status status = Status.NOT_CREATED;

    /**
     * Platform push status.
     */
    public enum Status {
        NOT_CREATED,
        IN_PROGRESS,
        CREATED
    }
}
