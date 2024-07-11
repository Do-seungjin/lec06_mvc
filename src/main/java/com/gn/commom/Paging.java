package com.gn.commom;

public class Paging {
	
	// 전체 게시글 개수
	private int totalData;
	// 전체 페이지 개수
	private int totalPage;
	// 페이징바 구성 요소들
	// 페이징 바의 크기
	private int pageBarSize = 5;
	// 페이징바 페이지 시작, 끝
	private int pageBarStart;
	private int pageBarEnd;
	
	// 현재 페이지
	private int nowPage=1;
	// 목록에 보여질 게시글 개수 설정
	private int numPerPage=10;
	// 쿼리에 사용할 Limit 값
	// Limit 10,10-> 10개건너뛰고 11페이지부터 10개까지 -> 다음페이지
	private int limitPageNo;
	
	// 이전, 다음 여부
	private boolean prev = true;
	private boolean next  = true;
	
	
	
}
