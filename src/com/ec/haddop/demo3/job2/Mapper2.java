package com.ec.haddop.demo3.job2;


import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * mappery
 * @author shicy
 *
 */
public class Mapper2 extends Mapper<Object, Text, Text, Text> {


	public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
		//100000_17_3_0_87_64_24_175_58
		String arrgs[] = value.toString().split(Job2.separator);
		String key1 = arrgs[1] + Job2.separator + arrgs[2]; //17_3
		context.write(new Text(key1), value);
	}

}