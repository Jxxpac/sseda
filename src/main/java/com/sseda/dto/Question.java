package com.sseda.dto;

public class Question {
	private String seqno;
	private String title;
	private String content;
	private String wdate;
	private String id;
	private String category;
	private String answerProc;
	private String no;
	private QuestionFile file;
	
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getSeqno() {
		return seqno;
	}
	public void setSeqno(String seqno) {
		this.seqno = seqno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getAnswerProc() {
		return answerProc;
	}
	public void setAnswerProc(String answerProc) {
		this.answerProc = answerProc;
	}
	public QuestionFile getFile() {
		return file;
	}
	public void setFile(QuestionFile file) {
		this.file = file;
	}
	
	
}
