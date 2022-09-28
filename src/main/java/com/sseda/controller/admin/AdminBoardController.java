package com.sseda.controller.admin;

import java.lang.System.Logger;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sseda.dao.BoardDao;
import com.sseda.dto.Board;
import com.sseda.dto.Cre;
import com.sseda.dto.Page;
import com.sseda.service.AdminBoardService;
import com.sseda.service.BoardService;

@Controller
@RequestMapping(value="/admin/")
public class AdminBoardController {

	@Autowired
	AdminBoardService boardService;
	
	@RequestMapping(value="boardList", method= {RequestMethod.POST, RequestMethod.GET})
	public String list(Model model, Cre cri) {
		
		if(cri.getCpage() == 0) cri.setCpage(1);
		if(cri.getRow() == 0) cri.setRow(3);
		
		List<Board> board = boardService.list(cri);
	
		model.addAttribute("pageMaker", new Page(boardService.getTotalRec(cri), cri));
		model.addAttribute("board", board);
		
		return "admin/ad_board/boardList";
	}
	
}