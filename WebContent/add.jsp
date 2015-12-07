<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.hanains.guestbook.dao.GuestbookDao"%>
<%@page import="com.hanains.guestbook.vo.GuestbookVo"%>

<%
	request.setCharacterEncoding( "UTF-8" );
	
	String name = request.getParameter( "name" );
	String password = request.getParameter( "pass" );
	String message = request.getParameter( "content" );
	
	GuestbookVo vo = new GuestbookVo();
	vo.setName(name);
	vo.setPassword(password);
	vo.setMessage(message);
	
	GuestbookDao dao = new GuestbookDao();
	dao.insert(vo);
	
	response.sendRedirect( "/guestbook/index.jsp" );
%>