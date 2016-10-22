package com.ec.haddop.demo3.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


import com.ec.haddop.demo3.entity.CrmDeatal;

/**
 * 构造数据的类
 * @author Administrator
 *
 */
public class MakeCrmDeatal {

	private Map<Long, Long> userInfo = null;
	private Map<Long, Long> crmInfo = null;

	private Long all = 1000l;
	private List<Long> listUserId = null;

	public MakeCrmDeatal() {
		// 初始化1000个用户
		userInfo = new HashMap<Long, Long>();
		crmInfo = new HashMap<Long, Long>();
		listUserId = new ArrayList<>();
		for (Long userId = 0l; userId < all; userId++) {
			Long corp = (long) (getRandomInt() % 10 + 50000);
			userInfo.put(userId + 1000000, corp);
			listUserId.add(userId + 1000000);
		}
	}

	private static final String LINE = System.getProperty("line.separator");

	private Random rd = new Random();

	public static void main(String[] args) {
		long bg = System.currentTimeMillis();
		MakeCrmDeatal mk = new MakeCrmDeatal();
		mk.buuildCrmDeatal(100000);
		System.out.println(LINE);
		long end = System.currentTimeMillis();
		System.out.println("times = " + (end - bg));
	}

	public void buuildCrmDeatal(int num) {
		BufferedWriter br = null;
		try {
			
			File file = new File("H:\\hadoop\\input\\input3");
			if(!file.exists()){
				file.mkdirs();
			}
			
			
			FileWriter fw = new FileWriter("H:\\hadoop\\input\\input3\\data.txt");
			br = new BufferedWriter(fw);
			
			String head = "crmid\tcorpid\tuserid\ttype\ttimes";
			br.append(head).append(LINE);
			for (int i = 0; i < num; i++) {
				CrmDeatal entity = buuildCrmDeatal();
				br.append(entity.getUserfulData()).append(LINE);
				if (i % 10000 == 0) {
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

	private CrmDeatal buuildCrmDeatal() {
		// TODO Auto-generated method stub
		Long crmId = (long) (getRandomInt() % 1000 + 10000000);
		
		Long userId = crmInfo.get(crmId);
		if(userId==null){
			userId = listUserId.get(getRandomInt() % listUserId.size());
			crmInfo.put(crmId, userId);
		}
		
		Long corpId = userInfo.get(userId);
		
		Integer type = getRandomInt() % 2;
		Integer times = getRandomInt() % 60 + 10;
		CrmDeatal entity = new CrmDeatal(crmId, corpId, userId, type, times);

		return entity;
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
