package com.OuSoft.mobileCommerce.entity;


public class RequestEntity<T> {

	private RequestHead head;
	private T biz;
	
	public RequestHead getHead() {
		return head;
	}
	public void setHead(RequestHead head) {
		this.head = head;
	}
	public T getBiz() {
		return biz;
	}
	public void setBiz(T biz) {
		this.biz = biz;
	}
	
	
	
}
