package co.com.megacode.repository;

import co.com.megacode.entity.ImageEntity;
import co.com.megacode.entity.LabelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ImageRepository extends JpaRepository<ImageEntity, Long> {

    @Query("SELECT i FROM ImageEntity i INNER JOIN ApplicationEntity a ON a.id=:idApp INNER JOIN TypeImageEntity t ON t.id=1")
    List<ImageEntity> findImagesPrincipalPageByApp(@Param("idApp")Long idApplication);
}
