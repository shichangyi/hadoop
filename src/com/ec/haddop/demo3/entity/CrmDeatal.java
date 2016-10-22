package com.ec.haddop.demo3.entity;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

/**
 * 客户
 * @author Administrator
 *
 */
public class CrmDeatal implements WritableComparable<CrmDeatal> {
	private Long crmId;
	private Long corpId;
	private Long userId;
	private Integer type;//联系类型, 1:电话
	private Integer times;//联系时间
	
	
	
	public CrmDeatal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CrmDeatal(Long crmId, Long corpId, Long userId, Integer type, Integer times) {
		super();
		this.crmId = crmId;
		this.corpId = corpId;
		this.userId = userId;
		this.type = type;
		this.times = times;
	}
	
	
	
	@Override
	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeLong(crmId);
		out.writeLong(corpId);
		out.writeLong(userId);
		out.writeInt(type);
		out.writeInt(times);
		
	}
	@Override
	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		crmId = in.readLong();
		corpId = in.readLong();
		userId = in.readLong();
		type = in.readInt();
		times = in.readInt();
	}
	@Override
	public int compareTo(CrmDeatal o) {
		// TODO Auto-generated method stub
		if(this.crmId == o.getCrmId()){
			return 0;
		}
		return this.crmId < o.getCrmId() ? -1 : 1;
	}
	
	
	
	
	
	
	public Long getCrmId() {
		return crmId;
	}
	public void setCrmId(Long crmId) {
		this.crmId = crmId;
	}
	public Long getCorpId() {
		return corpId;
	}
	public void setCorpId(Long corpId) {
		this.corpId = corpId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getTimes() {
		return times;
	}
	public void setTimes(Integer times) {
		this.times = times;
	}
	@Override
	public String toString() {
		return "CrmDeatal [crmId=" + crmId + ", corpId=" + corpId + ", userId=" + userId + ", type=" + type + ", times="
				+ times + "]";
	}
	public CharSequence getUserfulData() {
		// TODO Auto-generated method stub
		return String.format("%s\t%s\t%s\t%s\t%s", crmId,corpId,userId,type,times);
	}
	
	
	
	
	
	
	
}
