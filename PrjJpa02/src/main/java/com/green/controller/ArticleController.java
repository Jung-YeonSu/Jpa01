package com.green.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.dto.ArticleDto;
import com.green.dto.ArticleEntity;
import com.green.dto.ArticleForm;
import com.green.repository.ArticleRepository;
import org.springframework.web.bind.annotation.RequestParam;


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
		//System.out.println(articleDto); //ArticleDto(title=..., content=...)
		// h2 db Article 저장
		// Article Entity 에 값을 넣어서 save 
		ArticleEntity article = articleDto.toEntity();
		ArticleEntity saved = articleRepository.save( article ); // Insert
		// save(insert) 된 후에 결과를 돌려준다.
		return "redirect:/article/List"; // GET
	}
	
	@GetMapping("/List")
	public String list(Model model) {
		Long totCount = articleRepository.count();
		List<ArticleEntity> articleList =  articleRepository.findAll();
		model.addAttribute("articleList",articleList);
		model.addAttribute("totCount",totCount);
		return "article/list";
	}
	
	// article/3    : GET 방식 : PathVariable -> payload 없음
	// article?id=3 : GET 방식 : RequestParam -> payload 있음
	@GetMapping("/{id}")
	public String view(Model model, @PathVariable (value = "id") Long id) {
		// Type mismatch 해결 방법 2가지
		// 1번 Optional 객체로 캐스팅 후 get()
		/*Optional<ArticleEntity> articleOpt =  articleRepository.findById(id);
		ArticleEntity article = articleOpt.get();*/
		
		// 2번 결과가 조회되지 않음. (결과 : null) orElse(null)
		ArticleEntity article = articleRepository.findById(id).orElse(null);
		model.addAttribute("article",article);
		return "article/view";
	}
	
	@GetMapping("/UpdateForm/{id}")
	public String updateForm(@PathVariable (value="id") Long id, Model model) {
		ArticleEntity article = articleRepository.findById(id).orElse(null);
		model.addAttribute("article",article);
		return "article/updateForm";
	}
	
	@PostMapping("/Update")
	public String update(ArticleForm articleForm) {
		articleRepository.save(articleForm.toEntity());
		return "redirect:/article/List";
	}
	
	@GetMapping("/Delete/{id}")
	public String update(@PathVariable (value="id") Long id) {
		// delete() 는 Entity 인자가 필요함
		// Article article = new Article(id,null,null) 이런식으로
		// 필요한 인자만 가지는 생성자 만들어서 "= new Article(id)" 이런식도 가능

		articleRepository.deleteById(id);
		return "redirect:/article/List";
	}
	
	
}
