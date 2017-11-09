package com.xlj.forum.service.impl;

import com.xlj.forum.bean.Board;
import com.xlj.forum.service.IBoardService;

public class BoardServiceImpl<T extends Board> extends ServiceImpl<T> implements
		IBoardService<T> {

	@Override
	public void create(T board) {//创建版面，检查同名实体是否存在
		if(dao.createQuery(" from Board b where b.deleted=false and b.name=:name")
				.setParameter("name", board.getName().trim()).list().size()>0){
			throw new RuntimeException("版面 "+board.getName()+"已经存在");
		}
		dao.create(board);
	}

}
