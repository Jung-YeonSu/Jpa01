package com.green.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.green.dto.ArticleEntity;

public interface ArticleRepository 
	extends CrudRepository<ArticleEntity, Long>  {

	@Override
	ArrayList<ArticleEntity> findAll();
	
    // ArticleController 43 line 형변환 오류 해결 2번째 방법
    // 상속관계를 이용하여 List를 Iterable 로 UpCasting 하여 형변하지 않음
    // Iterable(I) <- Collection(C) <- List(I) <- ArrayList(C)
}
