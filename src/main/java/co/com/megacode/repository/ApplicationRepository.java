package co.com.megacode.repository;

import co.com.megacode.entity.ApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ApplicationRepository extends JpaRepository<ApplicationEntity, Long> {

    @Query("SELECT a FROM ApplicationEntity a WHERE a.name = :name")
    ApplicationEntity findApplicationByName(@Param("name")String name);

}
