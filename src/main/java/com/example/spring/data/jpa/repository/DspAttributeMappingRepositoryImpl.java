package com.example.spring.data.jpa.repository;

import com.example.spring.data.jpa.model.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class DspAttributeMappingRepositoryImpl implements DspAttributeMappingRepositoryCustom {
    private EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<String> findDspHavingAllAttributes(List<DspAttribute> attributes) {
        if (attributes == null || attributes.isEmpty()) {
            throw new IllegalArgumentException("Attributes can't be empty");
        }

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<String> query = cb.createQuery(String.class);

        Root<DspAttributeMapping> root = query.from(DspAttributeMapping.class);
        root.join(DspAttributeMapping_.dspAttribute, JoinType.INNER);
        query.select(root.get(DspAttributeMapping_.dspCode));
        query.where( buildWherePredicate(root, cb, attributes) );
        query.groupBy(root.get(DspAttributeMapping_.dspCode));
        query.having(cb.equal(cb.count(root.get(DspAttributeMapping_.dspAttribute)), attributes.size()));

        return em.createQuery(query).getResultList();
    }

    private Predicate buildWherePredicate(Root<DspAttributeMapping> root,
                                          CriteriaBuilder cb,
                                          List<DspAttribute> attributes) {
        List<Predicate> predicates = new ArrayList<>();
        attributes.forEach(a -> {
            Predicate categoryPredicate = cb.equal(
                    root.get(DspAttributeMapping_.dspAttribute).get(DspAttribute_.category),
                    a.getCategory()
            );
            Predicate attributePredicate = cb.equal(
                    root.get(DspAttributeMapping_.dspAttribute).get(DspAttribute_.attribute),
                    a.getAttribute()
            );
            predicates.add( cb.and(categoryPredicate, attributePredicate) );
        });

        return cb.or(predicates.toArray(new Predicate[0]));
    }
}
