package com.github.filmesAPI.repository;

import com.github.filmesAPI.entities.models.FilmeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeRepository extends JpaRepository<FilmeModel, Long> {

    @Query(value = "SELECT * FROM filmes AS f WHERE NOT EXISTS (SELECT * FROM avaliacoes  r WHERE f.id = r.filme_id);",  nativeQuery=true)
    List<FilmeModel> filmesRecomendados();
}
