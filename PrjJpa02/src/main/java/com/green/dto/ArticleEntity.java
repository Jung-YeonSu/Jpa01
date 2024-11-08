package com.green.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

// 실제 데이터베이스의 table 구조를 만든다 : Create table 명령을 실행

@Entity
public class ArticleEntity {
	// primary key   : @id
	// 번호 자동증가 : @GeneratedValue
	
	@Id
	@GeneratedValue
	private Long   id;
	@Column
	private String title;
	@Column
	private String content;

	public ArticleEntity() {

	}

	// 생성자
	public ArticleEntity(Long id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}

	// toString
	@Override
	public String toString() {
		return "ArticleEntity [id=" + id + ", title=" + title + ", content=" + content + "]";
	}
	
	
	
	
	
}
