package com.micronaut;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface GenreRepository  extends CrudRepository<Genre,Long> {
}
