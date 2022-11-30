package uz.market.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.market.market.domain.PaymentList;


@Repository
public interface PaymentListRepository extends JpaRepository<PaymentList, Long> {
    
}
