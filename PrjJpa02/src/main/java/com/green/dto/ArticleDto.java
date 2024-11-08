package com.green.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDto {
	// Field
	private String title;
	private String content;
	
	public ArticleEntity toEntity() {
		ArticleEntity article = new ArticleEntity(null, title, content) ;		
		return article;
	}
}
