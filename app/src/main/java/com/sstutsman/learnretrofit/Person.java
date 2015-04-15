package com.sstutsman.learnretrofit;

/**
 * Sam Stutsman on April, 2015.
 */
public class Person {

    // This is just a boring old object with accessors. Notice the nest object -- it matches perfectly the JSON structure
    private String name;
    private int age;
    private String phoneNumber;

    private Job job;

    private class Job {
        private String company;
        private String title;

        public String getCompany() {
            return company;
        }

        public String getTitle() {
            return title;
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCompany() {
        return job.getCompany();
    }

    public String getTitle() {
        return job.getTitle();
    }
}
