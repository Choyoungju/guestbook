<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>

<%@page import="com.hanains.guestbook.dao.GuestbookDao"%>
<%@page import="com.hanains.guestbook.vo.GuestbookVo"%>

<%
	String no = request.getParameter( "no" );
	String password = request.getParameter( "password" );
	
	GuestbookVo vo = new GuestbookVo();
	vo.setNo( Long.parseLong( no ) );
	vo.setPassword(password);
	
	GuestbookDao dao = new GuestbookDao();
	dao.delete(vo);
	
	response.sendRedirect( "/guestbook/index.jsp" );
%>