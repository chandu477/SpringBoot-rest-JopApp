package com.example.SpringBoot_rest_JopApp.repository;

import com.example.SpringBoot_rest_JopApp.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public interface JobRepo  extends JpaRepository<JobPost,Integer> {
 public List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile,String postDesc);
}


//List<JobPost> jobs = new ArrayList<>();
//// Java Developer Job Post
//public JobRepo() {
//    jobs.add(new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2, List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")));
//    // Frontend Developer Job Post
//    jobs.add(new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React", 3, List.of("HTML", "CSS", "JavaScript", "React")));
//    // Data Scientist Job Post
//    jobs.add(new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4, List.of("Python", "Machine Learning", "Data Analysis")));
//    // Network Engineer Job Post
//    jobs.add(new JobPost(4, "Network Engineer", "Design and implement computer networks for efficient data communication", 5, List.of("Networking", "Cisco", "Routing", "Switching")));
//    // Mobile App Developer Job Post
//    jobs.add(new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3, List.of("iOS Development", "Android Development", "Mobile App")));
//}
//
//public List<JobPost> getAllJobs(){
//    return jobs;
//}
//
//public void addJob(JobPost job){
//    jobs.add(job);
//}

//public JobPost getJob(int id){
//    for (JobPost job : jobs) {
//        if (job.getPostId() == id) {
//            return job;
//        }
//    }
//    return null; // if not found
//}

//public boolean updateJob(JobPost updatedJob) {
//    for (JobPost job : jobs) {
//        if (job.getPostId() == updatedJob.getPostId()) {
//            job.setPostProfile(updatedJob.getPostProfile());
//            job.setPostDesc(updatedJob.getPostDesc());
//            job.setReqExperience(updatedJob.getReqExperience());
//            job.setPostTechStack(updatedJob.getPostTechStack());
//            return true; // update successful
//        }
//    }
//    return false; // job not found
//}

//public boolean deleteJob(int id) {
//    Iterator<JobPost> iterator = jobs.iterator();
//
//    while (iterator.hasNext()) {
//        JobPost job = iterator.next();
//        if (job.getPostId() == id) {
//            iterator.remove(); // safe removal
//            return true;
//        }
//    }
//    return false; // not found
//}