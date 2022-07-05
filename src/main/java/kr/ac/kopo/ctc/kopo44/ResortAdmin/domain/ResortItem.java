package kr.ac.kopo.ctc.kopo44.ResortAdmin.domain;

import java.util.Objects;

public class ResortItem {
	private String name;
	private String resv_date;
	private int room;
	private String addr;
	private String telnum;
	private String in_name;
	private String comment;
	private String write_date;
	private int processing;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getResv_date() {
		return resv_date;
	}
	public void setResv_date(String resv_date) {
		this.resv_date = resv_date;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTelnum() {
		return telnum;
	}
	public void setTelnum(String telnum) {
		this.telnum = telnum;
	}
	public String getIn_name() {
		return in_name;
	}
	public void setIn_name(String in_name) {
		this.in_name = in_name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getWrite_date() {
		return write_date;
	}
	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}
	public int getProcessing() {
		return processing;
	}
	public void setProcessing(int processing) {
		this.processing = processing;
	}
	@Override
	public int hashCode() {
		return Objects.hash(addr, comment, in_name, name, processing, resv_date, room, telnum, write_date);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResortItem other = (ResortItem) obj;
		return Objects.equals(addr, other.addr) && Objects.equals(comment, other.comment)
				&& Objects.equals(in_name, other.in_name) && Objects.equals(name, other.name)
				&& processing == other.processing && Objects.equals(resv_date, other.resv_date) && room == other.room
				&& Objects.equals(telnum, other.telnum) && Objects.equals(write_date, other.write_date);
	}
	@Override
	public String toString() {
		return "ResortItem [name=" + name + ", resv_date=" + resv_date + ", room=" + room + ", addr=" + addr
				+ ", telnum=" + telnum + ", in_name=" + in_name + ", comment=" + comment + ", write_date=" + write_date
				+ ", processing=" + processing + "]";
	}
	
	
}
