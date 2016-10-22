package com.ec.haddop.demo3.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import com.alibaba.fastjson.JSONObject;
import com.ec.haddop.demo3.entity.Student;


public class MakeData {

	private Integer[] schoolIds = { 11, 12, 14, 17, 32 };
	private Integer[] classIds = { 1, 2, 3, 4, 5 };

	private String[] names = { "张三", "李四", "王二", "麻子", "刘华" };
	
	private static final String LINE = System.getProperty("line.separator");

	private Random rd = new Random();

	public static void main(String[] args) {
		long bg = System.currentTimeMillis();
		MakeData mk = new MakeData();
		mk.buildStudent(10000);
		System.out.println(LINE);
		long end = System.currentTimeMillis();
		System.out.println("times = " + (end - bg));
	}

	public void buildStudent(int num) {
		BufferedWriter br = null;
		try {
			FileWriter fw = new FileWriter("H:\\hadoop\\word\\input\\stus.txt");
			
			br = new BufferedWriter(fw);
			for (int i = 0; i < num; i++) {
				Student student = getStudent(i);
				br.append(JSONObject.toJSONString(student)).append(LINE);
				if(i%10000==0){
					br.flush();
				}
			}
			
			br.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	private Student getStudent(int i) {
		// TODO Auto-generated method stub

		Integer index1 = getRandomInt();
		Integer index2 = getRandomInt();
		Integer index3 = getRandomInt();
		Integer index4 = getRandomInt();

		Student student = new Student();

		student.setId(100000 + i);
		student.setName(names[index1 % 5] + index3 % 100);
		student.setSex((index4 % 2));
		student.setSchoolId(schoolIds[index3 % 5]);
		student.setClassId(classIds[index2 % 5]);

		student.setYingyu(getRandomInt() % 150);
		student.setShuxue(getRandomInt() % 150);
		student.setYuwen(getRandomInt() % 150);

		return student;
	}

	private Integer getRandomInt() {
		// TODO Auto-generated method stub
		Integer res = rd.nextInt();
		if (res <= 0) {
			res = -res + 1;
		}
		return res;
	}

}
