package com.example.SpringBoot_rest_JopApp.service;

import com.example.SpringBoot_rest_JopApp.model.JobPost;
import com.example.SpringBoot_rest_JopApp.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo jobRepo;

    public void addJob(JobPost job){
        jobRepo.addJob(job);
    }

    public List<JobPost> getAllJobs(){
        return jobRepo.getAllJobs();
    }

    public JobPost getJob(int id) {return jobRepo.getJob(id);}

    public boolean updateJob(JobPost job) {
        return jobRepo.updateJob(job);
    }

    public boolean deleteJob(int postId) {
        return jobRepo.deleteJob(postId);
    }
}
