package kr.ac.kopo.ctc.kopo44.ResortAdmin.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import kr.ac.kopo.ctc.kopo44.ResortAdmin.dao.ResortItemDao;
import kr.ac.kopo.ctc.kopo44.ResortAdmin.dao.ResortItemDaoImpl;
import kr.ac.kopo.ctc.kopo44.ResortAdmin.domain.ResortItem;

public class ResortItemServiceImpl implements ResortItemService{
	ResortItemDao resortItemDao = new ResortItemDaoImpl();
	
	public ArrayList<ArrayList<String>> thirtyDays() {
		ArrayList<ArrayList<String>> dayArr = new ArrayList<ArrayList<String>>(30);
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");

		for (int i=0; i <30; i++){
		   dayArr[i].add(dformat.format(cal.getTime()));
		   cal.add(cal.DATE,+1);	
		}
		
		
		
		return dayArr;
		
	}

	@Override
	public ResortItem readOne(String strResv_date, String strRoom) {
		int room = Integer.parseInt(strRoom);
		ResortItem replyItem = resortItemDao.readOne(strResv_date, room);

		return replyItem;
	}

	@Override
	public boolean createOne(String name, String resv_date, String room, String addr, String telnum, String in_name,
			String comment, String write_date, String processing) {
		
		return false;
	}

	@Override
	public ResortItem updateOne(String name, String resv_date, String strRoom, String addr, String telnum, String in_name,
			String comment, String write_date, String strProcessing) {

		ResortItemDao resortItemDao = new ResortItemDaoImpl();
		ResortItem resortItem = new ResortItem();

		int room = Integer.parseInt(strRoom);
		int processing = Integer.parseInt(strProcessing);
		
		resortItem.setName(name);
		resortItem.setResv_date(resv_date);
		resortItem.setRoom(room);
		resortItem.setAddr(addr);
		resortItem.setTelnum(telnum);
		resortItem.setIn_name(in_name);
		resortItem.setComment(comment);
		resortItem.setWrite_date(write_date);
		resortItem.setProcessing(processing);
		
		 resortItemDao.createOne(resortItem);
		
		return resortItem;
	}

	@Override
	public boolean deleteOne(String resv_date, String strRoom) {
		int deter = 0;
		//파트 삭제 결과 판단용2
		int deter2 = 0;
		boolean result = false;
		int room = Integer.parseInt(strRoom);
		ResortItemDao resortItemDao = new ResortItemDaoImpl();
				
		deter = resortItemDao.deleteOne(resv_date, room);
		
		if(deter == 1) {
			result = true;
		}
		
		return result;
	}
}
