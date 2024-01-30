package com.github.filmesAPI.entities.models;

import com.github.filmesAPI.entities.DTO.FilmeDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@Table(name = "filmes")
public class FilmeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private String descricao;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "filme")
    private List<ReviewModel> avaliacoes;
    public void updateValues(FilmeDTO data){
        if(data.getTitulo() != null){
            this.titulo = data.getTitulo();

        }
        if(data.getDescricao() != null){
            this.descricao = data.getDescricao();
        }
    }
}
