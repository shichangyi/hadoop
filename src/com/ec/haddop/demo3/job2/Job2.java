package com.ec.haddop.demo3.job2;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import com.ec.haddop.demo3.BaseJob;

public class Job2 implements BaseJob {
	
	//private String outputPath = "hdfs://192.168.150.129:9000/data/hadoop/word/output1";
	//private String inputPath = 	"hdfs://192.168.150.129:9000/data/hadoop/word/input";
	
	
	private String outputPath = "H:\\hadoop\\word\\output";
	private String inputPath = 	"H:\\hadoop\\word\\output1";
	private Job job;
	
	public static final String separator = "_";
	
	
	public Job2() throws IOException{
		initJob();
	}

	private void initJob() throws IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Configuration conf = new Configuration();
				
				//conf.set(name, value);
				
				
				job = Job.getInstance(conf, "job2");
				
				job.setJarByClass(Job2.class);// 
				
				// 处理类
				job.setMapperClass(Mapper2.class);//
				job.setReducerClass(Reducer2.class);// 
				
				// 设置输入输出类型
				job.setOutputKeyClass(Text.class);// 
				job.setOutputValueClass(Text.class);// 
				
				// 设置数据 输入输出路径
				FileInputFormat.addInputPath(job, new Path(inputPath));//
				FileOutputFormat.setOutputPath(job, new Path(outputPath));//
				
				
	}

	@Override
	public void startJob() throws Exception{
		
		//启动程序
		System.out.println("开始执行");
		boolean  res = job.waitForCompletion(true);
		System.out.println("执行结束");
		System.exit(res? 0 : 1);//
		
		
	}

	public String getOutputPath() {
		return outputPath;
	}

	public void setOutputPath(String outputPath) {
		this.outputPath = outputPath;
	}

	public String getInputPath() {
		return inputPath;
	}

	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}
	
	
	
	
}
