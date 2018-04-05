package com.example.spring.data.jpa.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "dsp_attribute")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DspAttribute {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "media_type")
    private String mediaType;

    @Column(name = "category")
    private String category;

    @Column(name = "attribute")
    private String attribute;
}
