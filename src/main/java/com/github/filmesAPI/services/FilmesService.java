package com.github.filmesAPI.services;

import com.github.filmesAPI.entities.models.FilmeModel;
import com.github.filmesAPI.exceptions.CreateFilmeException;
import com.github.filmesAPI.exceptions.DeleteFilmeException;
import com.github.filmesAPI.exceptions.UpdateFilmeException;
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

    public String createFilmes(FilmeModel data) throws CreateFilmeException {
        try{
            filmeRepository.save(data);
        }catch (Exception e){
            throw new CreateFilmeException("Erro ao cadastrar Filme, tente novamente!");
        }


        return "Criado com sucesso!";
    }

    public String deleteFilmes(Long id) throws DeleteFilmeException {
        try{
            FilmeModel filme = filmeRepository.getReferenceById(id);
            filmeRepository.deleteById((long) filme.getId());
        }catch (Exception e){
            throw new DeleteFilmeException("Erro ao deletar! Verifique se o id é válido e tente novamente");
        }
        return "Deletado com sucesso";

    }

    public String updateFilmes(FilmeModel filmeModel, Long id){
        try{
            FilmeModel filme = filmeRepository.getReferenceById(id);
            filme.updateValues(filmeModel);
            filmeRepository.save(filme);
        }catch (Exception e){
            throw new UpdateFilmeException("Erro ao atualizar o filme! Verifique se o id é válido e tente novamente");
        }
        return "Alterado com sucesso";

    }
}
