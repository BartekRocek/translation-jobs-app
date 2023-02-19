package pl.roclawski.bartek.app.translationjobs.controller;

import pl.roclawski.bartek.app.translationjobs.model.Job;
import pl.roclawski.bartek.app.translationjobs.service.JobService;

import java.util.List;

public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    // C - create
        public Job create(Job job) {
            return null;
        }
     // R - read
        public Job read(Integer id) {
            return null;
        }
    // U - update
        public Job update(Integer id, Job job) {
            return null;
        }
    // D - delete
        public void delete(Integer id) {
        }
    // L - list
        public List<Job> list() {
            return null;
        }
}
