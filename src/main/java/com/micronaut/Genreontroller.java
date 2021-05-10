package com.micronaut;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;

@Controller("/genre")
public class Genreontroller {

    @Inject
    GenreRepository genreRepository;

    @Get
    @Produces(MediaType.TEXT_PLAIN)
    public String hola()
    {
        return "Hi, profe";
    }

    @Get("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Genre getLGenre(@PathVariable int id)
    {
        var bookOpt= genreRepository.findById((long) id);
        if (bookOpt.isEmpty())
            return null;
        return bookOpt.get();

    }
    @Post
    @Produces(MediaType.APPLICATION_JSON)
    public Genre addGenero(@Body @Valid Genre genre)
    {
        genreRepository.save(genre);
        return genre;
    }
}
