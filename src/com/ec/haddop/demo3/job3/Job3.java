package com.ec.haddop.demo3.job3;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import com.ec.haddop.demo3.BaseJob;
import com.ec.haddop.demo3.entity.CrmDeatal;

public class Job3 implements BaseJob {
	
	//private String outputPath = "hdfs://192.168.150.129:9000/data/hadoop/word/output1";
	//private String inputPath = 	"hdfs://192.168.150.129:9000/data/hadoop/word/input";
	
	
	private String outputPath = "H:\\hadoop\\output\\output3";
	private String inputPath = 	"H:\\hadoop\\input\\input3";
	private Job job;
	
	public static final String separator = "\t";
	
	
	public static void main(String[] args) throws Exception {

		BaseJob job = new Job3();
		job.startJob();
		
		//System.out.println(doJob());

	}
	
	public Job3() throws IOException{
		initJob();
	}

	private void initJob() throws IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Configuration conf = new Configuration();
				
				//conf.set(name, value);
				
				
				job = Job.getInstance(conf, "job3");
				
				job.setJarByClass(Job3.class);// 
				
				// 处理类
				job.setMapperClass(Mapper3.class);//
				job.setReducerClass(Reducer3.class);// 
				
				// 设置输入输出类型
				job.setOutputKeyClass(Text.class);// 
				job.setOutputValueClass(NullWritable.class);// 
				job.setMapOutputKeyClass(Text.class);
				job.setMapOutputValueClass(CrmDeatal.class);
				
				
				//自定义分组
				job.setPartitionerClass(MyPartitioner.class);
				job.setNumReduceTasks(10);
				
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
