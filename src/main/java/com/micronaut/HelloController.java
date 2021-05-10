package com.micronaut;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;

@Controller("/hello")
public class HelloController {

    @Inject
    BookRepository bookRepository;

    @Get
    @Produces(MediaType.TEXT_PLAIN)
    public String hola()
    {
        return "Hi, profe";
    }

    @Get("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book getLibro(@PathVariable int id)
    {
        var bookOpt= bookRepository.findById((long) id);
        if (bookOpt.isEmpty())
            return null;
        return bookOpt.get();

    }
    @Post
    @Produces(MediaType.APPLICATION_JSON)
    public Book addLibro(@Body @Valid Book book)
    {
        bookRepository.save(book);
        return book;
    }
}
