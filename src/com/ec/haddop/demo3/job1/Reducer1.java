package com.ec.haddop.demo3.job1;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * mapper
 * @author Administrator
 *
 */
public class Reducer1 extends Reducer<Text, IntWritable, Text, IntWritable> {

	private IntWritable one = new IntWritable(1);
	public void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {
		
		//{"classId":2,"id":109960,"name":"����79","schoolId":32,"sex":1,"shuxue":96,"yingyu":52,"yuwen":72}
		//id_SchoolId_ClassId_Sex_Shuxue_Yuwen_Yingyu
		
		//统计一个学生的平均成绩，总成绩
		String arrgs[] = key.toString().split(Job1.separator);
		
		Integer sum = Integer.valueOf(arrgs[4]) +Integer.valueOf(arrgs[5]) + Integer.valueOf(arrgs[6]);
		String key1 = key.toString() + Job1.separator +sum + Job1.separator + (sum/3);
		
		context.write(new Text(key1), null);
		
		
		
		
	}
}