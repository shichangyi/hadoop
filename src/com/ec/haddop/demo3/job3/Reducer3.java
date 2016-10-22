package com.ec.haddop.demo3.job3;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import com.ec.haddop.demo3.entity.CrmDeatal;

/**
 * mapper
 * 
 * @author Administrator
 *
 */
public class Reducer3 extends Reducer<Text, CrmDeatal, Text, NullWritable> {
	public void reduce(Text key, Iterable<CrmDeatal> values, Context context) throws IOException, InterruptedException {
		//分数
		//String key1 = corpId + Job3.separator + userId + Job3.separator + crmId + Job3.separator + type; // 17_3
		//统计每个用户，每一种类型的通话时长
		Integer sum = 0;
		while(values.iterator().hasNext()){
			CrmDeatal crmDeatal = values.iterator().next();
			sum += crmDeatal.getTimes();
		}
		context.write(new Text(key.toString() + Job3.separator + sum),null);
	}
}