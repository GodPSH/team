package edu.study.controller;



import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.study.service.BoardService;
import edu.study.vo.BoardVO;
import edu.study.vo.SarchVO;

/**
 * Handles requests for the application home page.
 */
@RequestMapping(value="/board")
@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws Exception 
	 */
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String list(Locale locale, Model model,SarchVO vo) throws Exception {
		
		List<BoardVO> list = boardService.list(vo); 
		
		model.addAttribute("list",list);
		
		return "board/list";
	}
	@RequestMapping(value = "/view.do", method = RequestMethod.GET)
	public String view(Locale locale, Model model,int bidx) throws Exception {// 알아서 파싱해서 가져온다.
		
		System.out.println(bidx);
		
		BoardVO vo = boardService.detail(bidx);
		
		model.addAttribute("vo",vo);
		
		return "board/view";
	}
	@RequestMapping(value = "/modify.do", method = RequestMethod.GET)
	public String modify(Locale locale, Model model,int bidx) throws Exception {// 알아서 파싱해서 가져온다.
		
		System.out.println(bidx);
		
		BoardVO vo = boardService.detail(bidx);
		
		model.addAttribute("vo",vo);
		
		return "board/modify";
	}
	@RequestMapping(value = "/modify.do", method = RequestMethod.POST)
	public String modify(Locale locale, Model model, BoardVO vo) throws Exception {// 알아서 파싱해서 가져온다.
		
		boardService.update(vo);
		
		return "redirect:view.do?bidx="+vo.getBidx();
	}
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public String delete(Locale locale, Model model, int bidx) throws Exception {// 알아서 파싱해서 가져온다.
		
		boardService.delete(bidx);
		
		return "redirect:list.do";
	}
	@RequestMapping(value = "/register.do", method = RequestMethod.GET)
	public String register(Locale locale, Model model) throws Exception {// 알아서 파싱해서 가져온다.
		
		
		return "board/register";
	}
	@RequestMapping(value = "/register.do", method = RequestMethod.POST)
	public String register(Locale locale, Model model,BoardVO vo) throws Exception {// 알아서 파싱해서 가져온다.
		
		boardService.insert(vo);
		return "redirect:view.do?bidx="+vo.getBidx();
	}
}
