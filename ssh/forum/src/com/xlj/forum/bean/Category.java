package com.xlj.forum.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.persistence.OneToMany;

/**
 * ∞Ê√Ê¿‡±
 * @author Administrator
 *
 */
@Entity
@Table
public class Category extends BaseBean {
	private String name;
	
	@OneToMany(mappedBy="category")
	private List<Board> boards=new ArrayList<Board>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Board> getBoards() {
		return boards;
	}

	public void setBoards(List<Board> boards) {
		this.boards = boards;
	}
	
	
}
