package com.ec.haddop.demo3.job3;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import com.ec.haddop.demo3.entity.CrmDeatal;

/**
 * mappery
 * 
 * @author shicy
 *
 */
public class Mapper3 extends Mapper<Object, Text, Text, CrmDeatal> {

	// crmid corpid userid type times

	public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
		// 10000749 50005 1000531 0 59
		try{
			String arrgs[] = value.toString().split(Job3.separator);
			Long crmId = Long.parseLong(arrgs[0]);
			Long corpId = Long.parseLong(arrgs[1]);
			Long userId = Long.parseLong(arrgs[2]);
			Integer type = Integer.parseInt(arrgs[3]);
			Integer times = Integer.parseInt(arrgs[4]);
			CrmDeatal crmDeatal = new CrmDeatal(crmId, corpId, userId, type, times);
			String key1 = corpId + Job3.separator + userId + Job3.separator + crmId + Job3.separator + type; // 17_3
			context.write(new Text(key1), crmDeatal);
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("处理错误 : line = " + value.toString());
		}
		
	}

}