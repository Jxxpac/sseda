package com.sseda.dao;

import java.util.List;

import com.sseda.dto.Board;
import com.sseda.dto.Cre;

public interface AdminBoardDao {

	public List<Board> boardList(Cre cri);
}
