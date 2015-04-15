package com.sstutsman.learnretrofit;


import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Sam Stutsman on March, 2015.
 */
public class Api {

    private static final String ENDPOINT = "http://private-8ceb6-learnretofitpeople.apiary-mock.com/people/";
    private static PeopleService peopleService;

    private Api() {
    }

    public static PeopleService get() {
        if (peopleService == null) {
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();

            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(ENDPOINT)
                    .setConverter(new GsonConverter(gson))
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .build();

            peopleService = restAdapter.create(PeopleService.class);
        }

        return peopleService;
    }
}
