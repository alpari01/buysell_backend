package ee.taltech.iti0302.repository;

import ee.taltech.iti0302.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductCriteriaRepository {

    public static final int PAGE_SIZE = 10;
    private final EntityManager entityManager;

    public List<Product> search(ProductFilter filter) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Product> productQuery = cb.createQuery(Product.class);
        Root<Product> root = productQuery.from(Product.class);

        List<Predicate> predicateList = new ArrayList<>();
        if (filter.getName() != null) predicateList.add(cb.like(root.get("name"), filter.getName() + "%"));

        productQuery.select(root).where(cb.and(predicateList.toArray(new Predicate[0])));
        if (filter.getOrder().equals("ASC")) productQuery.orderBy(cb.asc(root.get(filter.getOrderBy())));
        else productQuery.orderBy(cb.desc(root.get(filter.getOrderBy())));

        TypedQuery<Product> entityManagedQuery = entityManager.createQuery(productQuery);
        entityManagedQuery.setFirstResult(filter.getFirstResult());
        entityManagedQuery.setMaxResults(PAGE_SIZE);

        return entityManagedQuery.getResultList();
    }

    public Long searchCount(ProductFilter filter) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Long> criteriaQueryCount = cb.createQuery(Long.class);
        Root<Product> root = criteriaQueryCount.from(Product.class);

        List<Predicate> predicateList = new ArrayList<>();
        if (filter.getName() != null) predicateList.add(cb.like(root.get("name"), filter.getName() + "%"));

        criteriaQueryCount.where(cb.and(predicateList.toArray(new Predicate[0])));
        criteriaQueryCount.select(cb.count(root));

        return entityManager.createQuery(criteriaQueryCount).getSingleResult();
    }
}
