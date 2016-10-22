package com.ec.haddop.demo3;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapred.jobcontrol.JobControl;
import org.apache.hadoop.mapreduce.lib.jobcontrol.ControlledJob;

import com.ec.haddop.demo3.job1.Job1;
import com.ec.haddop.demo3.job2.Job2;
import com.ec.haddop.demo3.job3.Job3;

public class Main {

	public static void main(String[] args) throws Exception {

		BaseJob job = new Job3();
		job.startJob();
		
		//System.out.println(doJob());

	}

	private static Integer doJob() throws Exception {
		// TODO Auto-generated method stub
		Job1 job1 = new Job1();
		Job2 job2 = new Job2();

		ControlledJob controlledJob1 = new ControlledJob(job1.getJob().getConfiguration());
		controlledJob1.setJob(job1.getJob());

		ControlledJob controlledJob2 = new ControlledJob(job2.getJob().getConfiguration());
		controlledJob1.setJob(job2.getJob());

		controlledJob2.addDependingJob(controlledJob1);

		JobControl jControl = new JobControl("studentJob");
		jControl.addJob(controlledJob1);
		jControl.addJob(controlledJob2);

		Thread jcThread = new Thread(jControl);
		jcThread.start();
		while (true) {
			if (jControl.allFinished()) {
				System.out.println(jControl.getSuccessfulJobList());
				jControl.stop();
				return 1;
			}
			if (jControl.getFailedJobList().size() > 0) {
				System.out.println(jControl.getFailedJobList());
				jControl.stop();
				return 1;
			}
		}
	}

}
