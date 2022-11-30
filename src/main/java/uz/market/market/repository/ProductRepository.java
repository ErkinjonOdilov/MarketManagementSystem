package uz.market.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.market.market.domain.Product;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Long> {

    Product findByCode(String code);
}
