package com.xlj.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Person {
	private List<Cards> list= new ArrayList<Cards>();
	private int flag = 0;

	public List<Cards> getList() {
		return list;
	}

	public void setList(List<Cards> list) {
		this.list = list;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public void add(Cards card) {
		list.add(card);
	}

	public int compare() {
		int[] a = new int[3];

		String[] b = new String[3];
		Map map = new HashMap();
		for (int i = 0; i < 3; i++) {
			a[i] = list.get(i).getNum();
			b[i] = list.get(i).getHuase();
			map.put(b[i] + a[i], a[i]);

		}

		// 排序
		sort(a, a.length);
		Set set = map.entrySet();
		for (int i = 0; i < 3; i++) {
			int j = 0;
			Iterator it = set.iterator();
			while (it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();
				if (entry.getValue().equals(a[i])) {
					j++;
					if (j == 2) {
						i = i + 1;
					}
					String huase = (String) entry.getKey();
					list.set(i, new Cards(huase.substring(0, 2), a[i]));
				}
			}
		}

		// 确定当前牌的类型
		if ((a[0] == a[1]) || (a[1] == a[2])) {
			if (a[0] == a[1] && a[0] == a[2]) {
				flag = 1;// 豹子
			} else {
				flag = 4;// 对子
			}
		} else if ((a[0] == (a[1] + 1)) && (a[1] == (a[2] + 1))) {
			if (b[0].equals(b[1]) && b[0].equals(b[2])) {
				flag = 2;// 同花顺
			} else {
				flag = 3;// 普通顺子
			}
		} else {
			flag = 5;// 普通
		}
		return flag;
	}

	// 排序
	public void sort(int a[], int num) {
		int temp = 0;
		for (int i = 0; i < num - 1; i++) {
			for (int j = 0; j < num - 1 - i; j++) {
				if (a[j] < a[j + 1]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}
}
