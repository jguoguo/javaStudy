package com.xlj.jfreechart;

import java.util.Random;

public class DataUtils {
	private static Random random=new Random();
	private static final int MAX_NUMBER=100;
	public static int getRandomData(){
		return random.nextInt(MAX_NUMBER);
	}
}
