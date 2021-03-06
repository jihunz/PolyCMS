package kr.ac.kopo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.model.Board;
import kr.ac.kopo.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	final String PATH = "board/";
	
	@Autowired 
	BoardService service;
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Board> list = service.list();
		model.addAttribute("list", list);
		return PATH+"list";
	}
	
	// long이 아닌 Long(Wrapper Class)인 이유: mapper 호출 함수의 두번째 인자가 Object라서 스프링이 자동 완성시 인식 가능
	@GetMapping("/{boardId}")
	public String item(@PathVariable Long boardId, Model model) {
		Board item = service.item(boardId);
		model.addAttribute("item", item);
		return PATH+"item";
	}
	
	@GetMapping("/add")
	public String add() {
		return PATH+"add";
	}
	
	@PostMapping("/add")
	public String add(Board item) {
		service.add(item);
		return "redirect:list";
	}
	
	@GetMapping("/update/{boardId}")
	public String update(@PathVariable Long boardId, Model model) {
		Board item = service.item(boardId);
		model.addAttribute("item", item);
		return PATH+"update";
	}
	
	@PostMapping("/update/{boardId}")
	public String update(@PathVariable Long boardId, Board item) {
		item.setBoardId(boardId);
		service.update(item);
		return "redirect:../list";
	}
	
	@GetMapping("/delete/{boardId}")
	public String delete(@PathVariable Long boardId) {
		service.delete(boardId);
		return "redirect:../list";
	}
}
