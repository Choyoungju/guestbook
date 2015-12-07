package com.hanains.guestbook.dao.test;

import java.util.List;

import com.hanains.guestbook.dao.GuestbookDao;
import com.hanains.guestbook.vo.GuestbookVo;



public class GuestbookTest {

	public static void main(String[] args){
		InsertTest();
		getListTest();
	}
	
	public static void getListTest(){
		GuestbookDao dao = new GuestbookDao(); 

		List<GuestbookVo> list = dao.getList();
		
		for(GuestbookVo vo : list){
			System.out.println(vo);
		}
	}
	
	public static void InsertTest(){
		GuestbookDao dao = new GuestbookDao();
		GuestbookVo vo = new GuestbookVo();
		
		vo.setName("일단 테스트");
		vo.setPassword("d");
		vo.setMessage("ㅋㅋㅋㅋ메시지");

		
		dao.insert(vo);
	}
	
}
