package com.example.spring.data.jpa.repository;

import com.example.spring.data.jpa.model.*;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.*;

public class Specs {
    public static Specification<DspAttribute> hasAnyOfAttributes(Set<DspAttribute> attributes) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            attributes.forEach(a -> {
                Predicate p1 = cb.equal(root.get(DspAttribute_.mediaType), a.getMediaType());
                Predicate p2 = cb.equal(root.get(DspAttribute_.category), a.getCategory());
                Predicate p3 = cb.equal(root.get(DspAttribute_.attribute), a.getAttribute());

                Predicate andPredicate = cb.and(p1, p2, p3);
                predicates.add(andPredicate);
            });

            return cb.or( predicates.toArray(new Predicate[0]) );
        };
    }

    public static Specification<DspAttribute> groupBy() {
//        SELECT c.currency, SUM(c.population)
//        FROM Country c
//        WHERE 'Europe' MEMBER OF c.continents
//        GROUP BY c.currency
//        HAVING COUNT(c) > 1

//        CriteriaQuery<Country> q = cb.createQuery(Country.class);
//        Root<Country> c = q.from(Country.class);
//        q.multiselect(c.get("currency"), cb.sum(c.get("population")));
//        q.where(cb.isMember("Europe", c.get("continents")));
//        q.groupBy(c.get("currency"));
//        g.having(cb.gt(cb.count(c), 1));

//        select * from dsp_attribute_mapping m
//        inner join dsp_attribute a on m.attribute_id = a.id
//        where
//        a.category='c1' and a.attribute='a1'
//        or
//        a.category='c1' and a.attribute='a2'
//        or
//        a.category='c1' and a.attribute='a3'
//        group by m.dsp_code
//        having count(m.attribute_id) = 3;


        return (root, query, cb) -> {
            query.multiselect(root.get("dspCode"), cb.count(root.get("dspAttribute")));
            query.groupBy(root.get("dspCode"));
            query.having( cb.equal( cb.count(root.get("dspAttribute")), 2) );

            return null;
        };
    }
}
