package com.example.spring.data.jpa;

import com.example.spring.data.jpa.model.DspAttribute;
import com.example.spring.data.jpa.model.DspAttributeMapping;
import com.example.spring.data.jpa.repository.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DspAttributeMappingRepositoryTest {
    @Autowired
    DspAttributeRepository dspAttributeRepository;

    @Autowired
    DspAttributeMappingRepository dspAttributeMappingRepository;

    @Autowired
    EntityManager em;

    @Test
    public void testSearch() throws Exception {
        DspAttribute a1 = DspAttribute.builder().category("c1").attribute("a1").build();
        DspAttribute a2 = DspAttribute.builder().category("c1").attribute("a2").build();
        DspAttribute a3 = DspAttribute.builder().category("c2").attribute("a1").build();
        DspAttribute a4 = DspAttribute.builder().category("c2").attribute("a2").build();
        DspAttribute a5 = DspAttribute.builder().category("c2").attribute("a3").build();

        dspAttributeRepository.saveAll(Arrays.asList(a1, a2, a3, a4, a5));

        DspAttributeMapping m1 = DspAttributeMapping.builder()
                .dspAttribute(a1)
                .dspCode("DBM")
                .build();

        DspAttributeMapping m2 = DspAttributeMapping.builder()
                .dspAttribute(a1)
                .dspCode("TTD")
                .build();

        DspAttributeMapping m3 = DspAttributeMapping.builder()
                .dspAttribute(a2)
                .dspCode("DBM")
                .build();

        dspAttributeMappingRepository.saveAll(Arrays.asList(m1, m2, m3));

        List<DspAttribute> attributes = new ArrayList<>();
        attributes.add(DspAttribute.builder().category("c1").attribute("a1").build());
        attributes.add(DspAttribute.builder().category("c1").attribute("a2").build());
        attributes.add(DspAttribute.builder().category("c2").attribute("a3").build());
        List<String> dspCodes = dspAttributeMappingRepository.findDspHavingAllAttributes(attributes);
        System.out.println("dspCodes: " + dspCodes);
    }
}
