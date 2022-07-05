package kr.ac.kopo.ctc.kopo44.ResortAdmin.dao;

import kr.ac.kopo.ctc.kopo44.ResortAdmin.domain.ResortItem;

public interface ResortItemDao {
	final static String TABLE_NAME = "resortResv";
	final static String COLUMN_NAME = "name"; //예약자 명
	final static String COLUMN_RESV_DATE = "resv_date"; //예약일
	final static String COLUMN_ROOM = "room"; //예약방 1:vip 2:일반 3:합리
	final static String COLUMN_ADDR = "addr"; //주소
	final static String COLUMN_TELNUM = "telnum"; //연락처
	final static String COLUMN_IN_NAME = "in_name"; //입금자명
	final static String COLUMN_COMMENT = "comment"; //남기실 말
	final static String COLUMN_DATE = "write_date"; //예약한(이 글을 쓴 날짜)
	final static String COLUMN_PROCESSING = "processing"; //현재 진행 1:예약완료 2:입금완료(확약) 3:환불요청...
	
	//Create
	int createOne(ResortItem resortItem);
	
	//Read
	ResortItem readOne(String resv_date, int room);
	
	//Update
	ResortItem updateOne(ResortItem resortItem);
	
	//Read
	int deleteOne(String resv_date, int room);
}
