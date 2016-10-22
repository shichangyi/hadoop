package com.ec.haddop.demo3.job1;

import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import com.alibaba.fastjson.JSONObject;
import com.ec.haddop.demo3.entity.Student;


/**
 * mappery
 * @author shicy
 *
 */
public class Mapper1 extends Mapper<Object, Text, Text, IntWritable> {

	
	private IntWritable one = new IntWritable(1);
	public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
		//{"classId":2,"id":109960,"name":"����79","schoolId":32,"sex":1,"shuxue":96,"yingyu":52,"yuwen":72}
		
		String json = value.toString();
		Student stu = JSONObject.parseObject(json,Student.class);
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(stu.getId()).append(Job1.separator);
		sb.append(stu.getSchoolId()).append(Job1.separator);
		sb.append(stu.getClassId()).append(Job1.separator);
		sb.append(stu.getSex()).append(Job1.separator);
		
		sb.append(stu.getShuxue()).append(Job1.separator);
		sb.append(stu.getYuwen()).append(Job1.separator);
		sb.append(stu.getYingyu()).append(Job1.separator);
		
		Text key1 = new Text(sb.toString());
		context.write(key1, one);

	
	}

}