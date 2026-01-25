package com.example.SpringBoot_rest_JopApp.Controller;

import com.example.SpringBoot_rest_JopApp.model.JobPost;
import com.example.SpringBoot_rest_JopApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Retention;
import java.util.List;
//if we use @Controller by default it expect a view name in return which is not required in our app now so we will use  @RequestBody in the method returning Data
//else we can dircetly use @RestController
//@Controller
@RestController

//if you want to consume this data in frontend the user @CrossOrigin(origins = "http://localhost:3000")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("jobPosts")
//    @ResponseBody
    public List<JobPost> getAllJobPost(){
        return jobService.getAllJobs();
    }

    @GetMapping("jobPost/{postId}")
    public  JobPost getjobPost(@PathVariable("postId") int postId){
        return jobService.getJob(postId);
    }

    //here the PathVariable("postId") can be used the extract multiple values from the url.

    @PostMapping("addJob")
    public void addJob(@RequestBody JobPost job){
        jobService.addJob(job);
    }

    @PutMapping("addJob")
    public void updateJob(@RequestBody JobPost job){
         jobService.updateJob(job);
    }

    @DeleteMapping("jobPost/{postId}")
    public void deleteJob(@PathVariable int postId){
        jobService.deleteJob(postId);
    }

    @GetMapping("loadData")
    public  String LoadData(){
        jobService.loadData();
        return "sucess";
    }

    @GetMapping("jobPost/search/{keyword}")
    public List<JobPost> searchByKeyWord( @PathVariable("keyword") String keyword){
       return jobService.searchByKeyWord(keyword);
    }
}
