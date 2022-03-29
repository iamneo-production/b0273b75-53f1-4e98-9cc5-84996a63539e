package com.examly.springapp;

public class JobService {
    public List<JobModel> getJobs(){
        return jobs;
    }
    public Jobs jobEditData(String id) {
        return jobs.stream().filter(t->t.getId().equals(id)).findFirst().get();
    }
   public void jobSave(Jobs job) {
       jobs.add(job);
       
   }
}
