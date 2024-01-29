package com.github.filmesAPI.repository;

import com.github.filmesAPI.entities.models.FilmeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeRepository extends JpaRepository<FilmeModel, Long> {
}
