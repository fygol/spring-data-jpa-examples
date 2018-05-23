package com.example.spring.data.jpa.bulkimport;

import java.util.List;

public interface CampaignMatchRepository {
    List<CampaignMatch> match(CampaignMatchParameters params);
}
