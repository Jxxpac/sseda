package com.sseda.service;

import java.util.List;
import java.util.Map;

import com.sseda.dto.Board;
import com.sseda.dto.Cre;

public interface AdminBoardService {

	public List<Board> list(Cre cri);

	public int getTotalRec(Cre cri);
	
	
}
