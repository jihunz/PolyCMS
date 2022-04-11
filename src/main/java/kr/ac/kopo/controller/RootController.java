package kr.ac.kopo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.support.RequestContextUtils;

import kr.ac.kopo.model.Board;
import kr.ac.kopo.model.Member;
import kr.ac.kopo.service.BoardService;
import kr.ac.kopo.service.MemberService;

@Controller
public class RootController {
	
	@Autowired
	MemberService ms;
	
	@Autowired
	BoardService bs;
	
	@RequestMapping("/")
	public String index(Model model) {
		List<Board> list = bs.list();
		
		model.addAttribute("list", list);
		
		return "index";
	}
	
	@GetMapping("/login")
	public String login(Model model, HttpSession session) {
		String msg = (String) session.getAttribute("msg");
		
		if(msg != null) {
			session.removeAttribute("msg");
			model.addAttribute("msg", msg);
		}
		
		return "login";
	}
	
	@PostMapping("/login")
	public String login(Member item, HttpSession session) {
		
		if(ms.login(item)) {
			session.setAttribute("member", item);
			
			String target = (String) session.getAttribute("target");
			session.removeAttribute(target);
			
			// 요청에 쿼리스트링이 포함되지 않은 경우도 처리
			return "redirect:" + (target == null ? "/" : target);
		}
		
		session.setAttribute("msg", "로그인 실패");
		return "redirect:login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/";
	}
}
