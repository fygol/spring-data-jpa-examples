package com.example.spring.data.jpa.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "dsp_attribute_mapping")
@ToString(exclude = "dspAttribute")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DspAttributeMapping {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "attribute_id", nullable = false)
    private DspAttribute dspAttribute;

    @Column(name = "dsp_code")
    private String dspCode;
}
