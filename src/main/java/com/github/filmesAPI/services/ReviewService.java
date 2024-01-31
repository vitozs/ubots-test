package com.github.filmesAPI.services;

import com.github.filmesAPI.entities.DTO.ReviewDTO;
import com.github.filmesAPI.entities.models.FilmeModel;
import com.github.filmesAPI.entities.models.ReviewModel;
import com.github.filmesAPI.exceptions.CreateException;
import com.github.filmesAPI.exceptions.DeleteException;
import com.github.filmesAPI.repository.FilmeRepository;
import com.github.filmesAPI.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    FilmeRepository filmeRepository;

    public String createReview(ReviewDTO review, Long id){
        try{
            if(filmeRepository.existsById(id)){
                ReviewModel reviewModel = new ReviewModel();
                reviewModel.setDescricao(review.getDescricao());
                FilmeModel filmeModel = filmeRepository.getReferenceById(id);
                reviewModel.setFilme(filmeModel);
                reviewRepository.save(reviewModel);
            }else{
                throw new CreateException("Erro ao criar a avaliação! Verifique se o id está correto e tente novamente");
            }
        }catch (Exception e){
            return e.getMessage();
        }

        return "Avaliacao salva!";
    }

    public String updateReview(ReviewDTO review, Long id){
        try{
            if(reviewRepository.existsById(id)){
                ReviewModel reviewModel = reviewRepository.getReferenceById(id);
                reviewModel.setDescricao(review.getDescricao());
                reviewRepository.save(reviewModel);


            }
        }catch (Exception e){
            return e.getMessage();
        }
        return "Avaliacao alterada!";
    }

    public String deleteReview(Long id){
        try{
            if(reviewRepository.existsById(id)){
                reviewRepository.deleteById(id);
            }else{
                throw new DeleteException("Erro ao remover a avaliacao! Verifique se o id da mesma está correto");
            }
        }catch (Exception e){
            return e.getMessage();
        }
        return "Avaliacao removida!";
    }

}
