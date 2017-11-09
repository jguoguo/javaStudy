package dangdang.entity;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	Map<Integer, Integer> books = new HashMap<Integer, Integer>();
	Map<Integer, Integer> removed = new HashMap<Integer, Integer>();
	
	
	
	public Cart() {
		super();
	}
	public Map<Integer, Integer> getBooks() {
		return books;
	}
	public void setBooks(Map<Integer, Integer> books) {
		this.books = books;
	}
	public Map<Integer, Integer> getRemoved() {
		return removed;
	}
	public void setRemoved(Map<Integer, Integer> removed) {
		this.removed = removed;
	}
	
	
}
