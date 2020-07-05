package com.example.algorithm.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class IntervalSchdeule {
    //找出最优日程安排
    public static void maxInter(List<Job> jobList){

        List<Job> jobSchedule = new ArrayList<>();

        int numJobs = jobList.size();
        //按照结束时间对所有job排序
        jobList.sort(new Comparator<Job>() {
            @Override
            public int compare(Job a, Job b) {
                return (a.getEnd()>b.getEnd())?1:(a.getEnd()==b.getEnd())?0:-1;
            }
        });
        Job[] jobs =new Job[jobList.size()];
        jobList.toArray(jobs);
        for (int i = 0; i < numJobs; i ++){
            //如果是第一个任务
            if (jobSchedule == null){
                jobSchedule.add(jobs[i]);
            }
            //如果不是第一个任务,判断是否时间冲突
            else{
                Job[] jobs1 = new Job[jobSchedule.size()];
                jobSchedule.toArray(jobs1);
                boolean flag = true;
                for (int n = 0; n < jobs1.length; n ++){
                    if (jobs1[n].getEnd()>jobs[i].getBegin()){
                        flag = false;
                        break;

                    }
                }
                if (flag){
                    jobSchedule.add(jobs[i]);
                }
            }
        }
        Job[] bestJob = new Job[jobSchedule.size()];
        jobSchedule.toArray(bestJob);
        for (int i = 0; i < bestJob.length; i ++){
            System.out.println("("+bestJob[i].getName()+","+bestJob[i].getBegin()+","+bestJob[i].getEnd()+")");
        }

    }

    public static void main(String[] args) {
        Job job = new Job("e", 8, 10);
        Job job1 = new Job("b", 2, 5);
        Job job2 = new Job("c", 4, 7);
        Job job3 = new Job("a", 1, 3);
        Job job4 = new Job("d", 6, 9);
        List<Job> jobs = new ArrayList<>();
        jobs.add(job);
        jobs.add(job1);
        jobs.add(job2);
        jobs.add(job3);
        jobs.add(job4);
        maxInter(jobs);

    }

}
class Job{
    private String name;
    private int begin;
    private int end;

    public Job(String name, int begin, int end) {
        this.name = name;
        this.begin = begin;
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}

