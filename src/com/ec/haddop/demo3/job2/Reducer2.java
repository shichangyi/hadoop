package com.ec.haddop.demo3.job2;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * mapper
 * 
 * @author Administrator
 *
 */
public class Reducer2 extends Reducer<Text, Text, Text, Text> {
	public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

		// 统计一个班的 男生人数，女生人数，各科总分，各科平均分
		Integer cnt = 0;
		Integer mm = 0;//妹纸数量
		Integer yuewen = 0;
		Integer shuxue = 0;
		Integer yingyu = 0;
		while (values.iterator().hasNext()) {
			////// 100000_17_3_0_87_64_24_175_58
			Text stuText = values.iterator().next();
			String arrgs[] = stuText.toString().split(Job2.separator);
			mm += Integer.valueOf(arrgs[3]);
			yuewen += Integer.valueOf(arrgs[4]);
			shuxue += Integer.valueOf(arrgs[5]);
			yingyu += Integer.valueOf(arrgs[6]);
			cnt++;
		}

		//总分
		Integer all = yuewen + shuxue + yingyu;
		//平均分
		Integer ave = cnt == 0 ? 0 : all / cnt;
		//男生人数
		Integer gg = cnt - mm;
		
		StringBuffer sb = new StringBuffer();
		//key
		sb.append(key.toString()).append(Job2.separator);
		//人数
		sb.append(cnt).append(Job2.separator);
		sb.append(mm).append(Job2.separator);
		sb.append(gg).append(Job2.separator);
		
		//分数
		sb.append(yuewen).append(Job2.separator);
		sb.append(shuxue).append(Job2.separator);
		sb.append(yingyu).append(Job2.separator);
		sb.append(ave).append(Job2.separator);
		sb.append(all).append(Job2.separator);
		
		
		context.write(new Text(sb.toString()),null);

	}
}