package co.com.megacode.repository;

import co.com.megacode.entity.TypeImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TypeImageRepository extends JpaRepository<TypeImageEntity, Long> {

    @Query("SELECT t FROM TypeImageEntity t WHERE t.nameType = :name")
    TypeImageEntity findTypeImageByName(@Param("name")String name);
}
