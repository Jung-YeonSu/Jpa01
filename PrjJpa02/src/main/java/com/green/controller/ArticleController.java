package com.green.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.dto.ArticleDto;
import com.green.dto.ArticleEntity;
import com.green.repository.ArticleRepository;

@Controller
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private ArticleRepository articleRepository;
	
	@GetMapping("/WriteForm")
	public String writeForm () {
		return "article/writeForm";
	}
	
	@PostMapping("/Write")
	public String write(ArticleDto articleDto) {
		System.out.println(articleDto); //ArticleDto(title=..., content=...)
		// h2 db Article 저장
		// Article Entity 에 값을 넣어서 save 
		ArticleEntity article = articleDto.toEntity();
		ArticleEntity saved = articleRepository.save( article ); // Insert
		// save(insert) 된 후에 결과를 돌려준다.
		System.out.println(saved);
		return "redirect:/article/List"; // GET
	}
	
	@GetMapping("/List")
	public String list(Model model) {
		
		List<ArticleEntity> articleList =  articleRepository.findAll();
		System.out.println("전체목록 : " + articleList);
		model.addAttribute("articleList",articleList);
		return "article/list";
	}
}
