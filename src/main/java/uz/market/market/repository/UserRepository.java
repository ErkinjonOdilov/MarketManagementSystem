package uz.market.market.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.market.market.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userUser);

    @Query("select u from User u where u.userName = :userName")
    User findByLogin(@Param("userName") String userName);

    boolean existsByUserName(String userName);


}
