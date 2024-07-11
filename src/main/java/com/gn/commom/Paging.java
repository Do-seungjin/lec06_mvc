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
	
	
	
	public int getTotalData() {
		return totalData;
	}
	public void setTotalData(int totalData) {
		this.totalData = totalData;
		calcPaging();
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageBarSize() {
		return pageBarSize;
	}
	public void setPageBarSize(int pageBarSize) {
		this.pageBarSize = pageBarSize;
	}
	public int getPageBarStart() {
		return pageBarStart;
	}
	public void setPageBarStart(int pageBarStart) {
		this.pageBarStart = pageBarStart;
	}
	public int getPageBarEnd() {
		return pageBarEnd;
	}
	public void setPageBarEnd(int pageBarEnd) {
		this.pageBarEnd = pageBarEnd;
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getNumPerPage() {
		return numPerPage;
	}
	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}
	public int getLimitPageNo() {
		return limitPageNo;
	}
	public void setLimitPageNo(int limitPageNo) {
		this.limitPageNo = limitPageNo;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	
	// 전체 게시글 개수를 set 해줬을때 동작할 메소드
	private void calcPaging() {
		// 2번 페이지(11~20) 조회를 원한다 -> limit 10,10 -> 10개뛰어넘고 10개본다
		// 3번 페이지(21~30) -> limit 20,10 -> 20개뛰어넘고 10개 본다
		limitPageNo = (nowPage-1)*numPerPage;
		
		// 전체 페이지 개수(26 -> 3개페이지)
		// 전체 데이터/페이지당게시글개수
		// 더블로 계산하면 소수점으로 결과가 나오고 이를 올림
		totalPage = (int)Math.ceil((double)totalData/numPerPage);
		
		// 5개씩끊었을때 해당 페이징바의 시작점 구하는방법
		// 3번페이지 -> 1번
		// 8번페이지 -> 6번
		pageBarStart = ((nowPage-1)/pageBarSize)*pageBarSize+1;
		pageBarEnd = pageBarStart + pageBarSize-1;
		if(pageBarEnd>totalPage)pageBarEnd = totalPage;
		
		// 이전(1번페이지에서만 없고 전부 다 있음)
		if(pageBarStart==1) prev = false;
		// 다음(페이지개수와 지금보고있는 페이지가 같을경우 다음은 없다)
		if(pageBarEnd >= totalPage) next = false;
		
		
		
		
		
		
		
		
		
		
	}
	
}
