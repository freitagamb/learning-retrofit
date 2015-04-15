package com.sstutsman.learnretrofit;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;


public class MainActivity extends ActionBarActivity {

    private List<Person> people;

    private TextView tvDownload;
    private RecyclerView recyclerPeople;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDownload = (TextView) findViewById(R.id.tv_download);
        recyclerPeople = (RecyclerView) findViewById(R.id.recycler_download);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerPeople.setLayoutManager(layoutManager);

        tvDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PeopleTask().execute();
            }
        });
    }

    private class PeopleTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            people = Api.get().getPeople();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            recyclerPeople.setAdapter(new PeopleAdapter(people));
            super.onPostExecute(aVoid);
        }
    }
}