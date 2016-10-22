package com.ec.haddop.demo3.job3;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

import com.ec.haddop.demo3.entity.CrmDeatal;

/**
 * 自定义分组
 * @author Administrator
 *
 */
public class MyPartitioner extends Partitioner<Text, CrmDeatal> {

	@Override
	public int getPartition(Text key, CrmDeatal value, int partitions) {
		// TODO Auto-generated method stub
		//String key1 = corpId + Job3.separator + userId + Job3.separator + crmId + Job3.separator + type; // 17_3
		String arrgs[] = key.toString().split(Job3.separator);
		Long corpId = Long.valueOf(arrgs[0]);
		return (int) (corpId % partitions);
	}

}
