package com.example.spring.data.jpa;

import com.example.spring.data.jpa.bulkimport.CampaignMatchParameters;
import com.example.spring.data.jpa.bulkimport.CampaignMatchRepository;
import com.example.spring.data.jpa.bulkimport.Platform;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CampaignMatchRepositoryTest {

    @Autowired
    private CampaignMatchRepository repo;

    @Test
    public void name() {
        assertThat(repo).isNotNull();

        repo.match(CampaignMatchParameters.builder()
                .sfDspCode("TURN-Turn")
                .market("US")
                .status(Platform.Status.NOT_CREATED)
                .build());
    }
}
