package com.qa.cinema.service;

import com.qa.cinema.domain.Listing;
import com.qa.cinema.repo.MovieRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepo repo;

    private ModelMapper mapper;
    @Autowired
    public MovieService(MovieRepo repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public Listing readMovie(Long id) {
        return repo.findById(id).get();
    }

    public List<Listing> readAllMovies() {
        return repo.findAll();
    }

}
