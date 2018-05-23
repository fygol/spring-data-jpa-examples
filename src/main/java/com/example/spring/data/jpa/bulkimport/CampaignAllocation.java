package com.example.spring.data.jpa.bulkimport;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

/**
 * Campaign allocation entity.
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "platforms")
@Table(name = "campaign_allocation")
@EqualsAndHashCode(callSuper = false)
public class CampaignAllocation extends BaseEntity<Long> {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "csf_id")
    private Long csfId;
    @Column(name = "sf_id")
    private String sfId;
    @Column(name = "cuid")
    private String cuid;
    @Column(name = "name")
    private String name;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;
    @Column(name = "sf_account_id")
    private String sfAccountId;
    @Column(name = "market")
    private String market;
    @Column(name = "gross_budget")
    private BigDecimal grossBudget;
    @Column(name = "media_budget")
    private BigDecimal mediaBudget;
    @Column(name = "inventory_budget")
    private BigDecimal inventoryBudget;
    @Column(name = "data_budget")
    private BigDecimal dataBudget;
    @Column(name = "cadreon_fee_percent")
    private BigDecimal cadreonFeePercent;
    @Column(name = "gross_budget_percent")
    private Integer grossBudgetPercent;
    @Column(name = "media_type")
    private String mediaType;
    @Column(name = "approval_status")
    private String approvalStatus;
    @Column(name = "cost_model")
    private String costModel;
    @Column(name = "deleted")
    private boolean deleted = false;
    @Column(name = "csf_version")
    private Long csfVersion;
    @Column(name = "csf_last_modified_date")
    private LocalDateTime csfModificationDate;

//    @ManyToOne
//    @JoinColumn(name = "insertion_order_id")
//    private InsertionOrder insertionOrder;

    @OneToMany(mappedBy = "campaignAllocation", cascade = ALL)
    private List<Platform> platforms = new ArrayList<>();
}
