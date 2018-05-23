package com.example.spring.data.jpa.bulkimport;

import com.example.spring.data.jpa.model.DspAttributeMapping;
import com.example.spring.data.jpa.model.DspAttributeMapping_;
import com.example.spring.data.jpa.model.DspAttribute_;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
@AllArgsConstructor
public class CampaignMatchRepositoryImpl implements CampaignMatchRepository {
    private EntityManager em;


    /*
       select
        p.id, c.dsp_partner_id, c.external_id
        from platform p
        inner join campaign_allocation a on p.campaign_allocation_id = a.id
        inner join (
            select * from dsp_campaign group by name having count(name) = 1  -- select rows with unique names
        ) as c on p.name = c.name
        left outer join campaign on c.external_id = campaign.external_id
        where
            p.dsp = 'TURN-Turn'
            and a.market = 'US'
            and p.status = 'NOT_CREATED'
            and p.flight_start_date >= '2018-01-01'
            and ABS(TIMESTAMPDIFF(DAY, p.flight_start_date, c.start_date)) <= 30
            and campaign.external_id is NULL -- filter out existent campaigns
        group by p.name
        having count(p.name) = 1 -- select rows with unique names
        order by p.id
        ;



     */
    @Override
    public List<CampaignMatch> match(CampaignMatchParameters params) {
        String sql = "select\n" +
                "        p.id, c.dsp_partner_id, c.external_id\n" +
                "        from platform p\n" +
                "        inner join campaign_allocation a on p.campaign_allocation_id = a.id\n" +
                "        inner join (\n" +
                "            select * from dsp_campaign group by name having count(name) = 1\n" +
                "        ) as c on p.name = c.name\n" +
                "        -- left outer join campaign on c.external_id = campaign.external_id\n" +
                "        where\n" +
                "            p.dsp = :sfDspCode\n" +
                "            and a.market = 'US'\n" +
                "            and p.status = 'NOT_CREATED'\n" +
                "            and p.flight_start_date >= '2018-01-01'\n" +
                "            and ABS(TIMESTAMPDIFF(DAY, p.flight_start_date, c.start_date)) <= 30\n" +
                "           -- and campaign.external_id is NULL\n" +
                "        group by p.name\n" +
                "        having count(p.name) = 1\n" +
                "        order by p.id";
        Query query = em.createNativeQuery(sql);
        query.setParameter("sfDspCode", params.getSfDspCode());

        List resultList = query.getResultList();

        return null;

//        CriteriaBuilder cb = em.getCriteriaBuilder();
////        CriteriaQuery<CampaignMatch> query = cb.createQuery(CampaignMatch.class);
//        CriteriaQuery<Long> query = cb.createQuery(Long.class);
//
//        Root<Platform> root = query.from(Platform.class);
//        Root<DspCampaign> dspCampaignRoot = query.from(DspCampaign.class);
//
//        query.multiselect(root.get(Platform_.id));
//        Join<Platform, CampaignAllocation> join = root.join(Platform_.campaignAllocation, JoinType.INNER);
//
//        // where
//        Predicate sfDspCode = cb.equal(root.get(Platform_.dsp), params.getSfDspCode());
//        Predicate market = cb.equal(join.get(CampaignAllocation_.market), params.getMarket());
//        Predicate status = cb.equal(root.get(Platform_.status), params.getStatus());
//        Predicate startDate = cb.greaterThanOrEqualTo(
//                root.get(Platform_.flightStartDate),
//                params.getPlatformStartDate()
//        );
////        Predicate dateDiff = cb.lessThanOrEqualTo(
////                root.get("DATE_FORMAT"),
////                params.getDateDiff()
////        );
////        cb.function("TIMESTAMPDIFF", Integer.class, root.get(Platform_.flightStartDate), );
//
//        Predicate where = cb.and(sfDspCode, market, status, startDate);
//        query.where(where);
//
//        em.createQuery(query).getResultList();
//
//        return null;
    }
}
