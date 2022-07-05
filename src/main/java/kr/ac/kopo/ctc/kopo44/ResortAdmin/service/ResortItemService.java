package kr.ac.kopo.ctc.kopo44.ResortAdmin.service;

import java.util.ArrayList;

import kr.ac.kopo.ctc.kopo44.ResortAdmin.domain.ResortItem;

public interface ResortItemService {
	
	ArrayList<ArrayList<String>> thirtyDays();
	
	//조회
	ResortItem readOne(String resv_date, String room);

	//입력
	boolean createOne(String name, String resv_date, String room, String addr, String telnum, String in_name, String comment, String write_date, String processing);

	//수정
	ResortItem updateOne(String name, String resv_date, String room, String addr, String telnum, String in_name, String comment, String write_date, String processing);
	
	//삭제
	boolean deleteOne(String resv_date, String room);
	}
