package uz.market.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.market.market.domain.MarketBase;


@Repository
public interface MarketBaseRepository extends JpaRepository<MarketBase, Long> {
    
}
