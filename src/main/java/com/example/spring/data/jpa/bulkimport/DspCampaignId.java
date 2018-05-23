package com.example.spring.data.jpa.bulkimport;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Composite id for {@link DspCampaign}.
 */
@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DspCampaignId implements Serializable {
    @Column(name = "dsp_partner_id", nullable = false)
    private Long dspPartnerId;

    @Column(name = "external_id", nullable = false)
    private String externalId;
}
