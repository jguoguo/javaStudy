package com.xlj.forum.service.impl;

import com.xlj.forum.bean.Board;
import com.xlj.forum.service.IBoardService;

public class BoardServiceImpl<T extends Board> extends ServiceImpl<T> implements
		IBoardService<T> {

	@Override
	public void create(T board) {//�������棬���ͬ��ʵ���Ƿ����
		if(dao.createQuery(" from Board b where b.deleted=false and b.name=:name")
				.setParameter("name", board.getName().trim()).list().size()>0){
			throw new RuntimeException("���� "+board.getName()+"�Ѿ�����");
		}
		dao.create(board);
	}

}
