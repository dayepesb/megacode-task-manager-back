package co.com.megacode.repository;

import co.com.megacode.entity.LabelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabelRepository extends JpaRepository<LabelEntity,Long> {

    @Query("select l from LabelEntity l INNER JOIN ApplicationEntity a ON a.id=:idApp")
    List<LabelEntity> findAllLabelsByIdApp(@Param("idApp")Long idApp);
}
