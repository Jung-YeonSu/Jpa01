package com.green.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleForm {
	private Long   id;
	private String title;
	private String content;
	
	public ArticleEntity toEntity() {
		ArticleEntity article = new ArticleEntity(id, title, content) ;		
		return article;
	}
}
