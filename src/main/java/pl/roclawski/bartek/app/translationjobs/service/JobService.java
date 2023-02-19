package pl.roclawski.bartek.app.translationjobs.service;

import pl.roclawski.bartek.app.translationjobs.model.Job;
import pl.roclawski.bartek.app.translationjobs.repository.JobRepository;

import java.util.List;

public class JobService {

    JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
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
