package com.github.filmesAPI.services;

import com.github.filmesAPI.entities.DTO.FilmeDTO;
import com.github.filmesAPI.entities.models.FilmeModel;
import com.github.filmesAPI.exceptions.CreateException;
import com.github.filmesAPI.exceptions.DeleteException;
import com.github.filmesAPI.exceptions.UpdateException;
import com.github.filmesAPI.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmesService {

    @Autowired
    FilmeRepository filmeRepository;
    public Iterable<FilmeModel> getFilmes(){
        return filmeRepository.findAll();
    }

    public List<FilmeModel> getFilmeRecomendado(){
        return filmeRepository.filmesRecomendados();
    }

    public String createFilmes(FilmeDTO data) throws CreateException {
        try{
            FilmeModel filmeModel = new FilmeModel();
            filmeModel.updateValues(data);
            filmeRepository.save(filmeModel);
        }catch (Exception e){
            throw new CreateException("Erro ao cadastrar Filme, tente novamente!");
        }


        return "Criado com sucesso!";
    }

    public String deleteFilmes(Long id) throws DeleteException {
        try{
            if(filmeRepository.existsById(id)){
                filmeRepository.deleteById(id);
            }else{
                throw new DeleteException("Erro ao deletar! Verifique se o id é válido e tente novamente");
            }
        }catch (Exception e){
            return e.getMessage();
        }
        return "Deletado com sucesso";

    }

    public String updateFilmes(FilmeDTO filmeModel, Long id){
        try{
            if(filmeRepository.existsById(id)){
                FilmeModel filme = filmeRepository.getReferenceById(id);
                filme.updateValues(filmeModel);
                filmeRepository.save(filme);
            }else{
                throw new UpdateException("Erro ao atualizar o filme! Verifique se o id é válido e tente novamente");
            }

        }catch (Exception e){
            return e.getMessage();
        }
        return "Alterado com sucesso";

    }
}
