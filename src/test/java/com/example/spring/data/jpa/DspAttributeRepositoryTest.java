package com.example.spring.data.jpa;

import com.example.spring.data.jpa.model.DspAttribute;
import com.example.spring.data.jpa.repository.DspAttributeRepository;
import com.example.spring.data.jpa.repository.Specs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DspAttributeRepositoryTest {
    @Autowired
    DspAttributeRepository repo;

    @Test
    public void testFindBySpec() throws Exception {
        DspAttribute a1 = DspAttribute.builder()
                .mediaType("m1")
                .category("c1")
                .attribute("a1")
                .build();
        DspAttribute a2 = DspAttribute.builder()
                .mediaType("m1")
                .category("c1")
                .attribute("a2")
                .build();
        DspAttribute a3 = DspAttribute.builder()
                .mediaType("m1")
                .category("c1")
                .attribute("a3")
                .build();

        repo.saveAll(Arrays.asList(a1, a2, a3));

        Set<DspAttribute> attrs = new HashSet<>();
        attrs.add(a1);
        attrs.add(a2);

        Specification<DspAttribute> spec = Specification.where(Specs.hasAnyOfAttributes(attrs));

        List<DspAttribute> result = repo.findAll(spec);
        System.out.println(result);
    }
}
