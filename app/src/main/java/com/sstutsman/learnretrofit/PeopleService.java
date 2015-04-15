package com.sstutsman.learnretrofit;

import java.util.List;

import retrofit.http.GET;

/**
 * Sam Stutsman on April, 2015.
 */
public interface PeopleService {

    // This call will append "people/" to the endpoint. It must return a List of Persons
    // The GET annotation declares this as a HTTP GET request
    @GET("/people/")
    List<Person> getPeople();

}
