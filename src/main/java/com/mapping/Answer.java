package com.mapping;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Answer {
	@Id
	@Column(name="answer_id")
	private int answerId;
	private String answer;
	
	@ManyToOne
	private Question q;
	
	public Question getQ() {
		return q;
	}
	
	public void setQ(Question q) {
		this.q = q;
	}
	
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Answer(int answerId, String answer) {
		super();
		this.answerId = answerId;
		this.answer = answer;
	}
	
	public int getAnswerId() {
		return answerId;
	}
	
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	
	public String getAnswer() {
		return answer;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
}
