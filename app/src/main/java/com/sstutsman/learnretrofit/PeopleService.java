package com.sstutsman.learnretrofit;

import java.util.List;

import retrofit.http.GET;

/**
 * Sam Stutsman on April, 2015.
 */
public interface PeopleService {

    @GET("/people/")
    List<Person> getPeople();

}
