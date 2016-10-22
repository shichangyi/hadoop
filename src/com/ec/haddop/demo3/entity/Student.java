package com.ec.haddop.demo3.entity;

public class Student {
	private Integer id;
	private String name;
	private Integer sex = 0; // 男:0,女:1
	private Integer schoolId;
	private Integer classId;
	
	private Integer yuwen;
	private Integer shuxue;
	private Integer yingyu;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public Integer getYuwen() {
		return yuwen;
	}
	public void setYuwen(Integer yuwen) {
		this.yuwen = yuwen;
	}
	public Integer getShuxue() {
		return shuxue;
	}
	public void setShuxue(Integer shuxue) {
		this.shuxue = shuxue;
	}
	public Integer getYingyu() {
		return yingyu;
	}
	public void setYingyu(Integer yingyu) {
		this.yingyu = yingyu;
	}

	
	
}
