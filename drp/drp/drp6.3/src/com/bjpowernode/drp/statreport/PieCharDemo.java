package com.bjpowernode.drp.statreport;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class PieCharDemo {

	public static void main(String[] args) throws IOException{
		DefaultPieDataset data=getDataSet();
		JFreeChart chart=ChartFactory.createPieChart3D("ˮ������ͼ",data,true,false,false);
		
		//дͼ������ļ���������״ͼ����Դ��
		FileOutputStream fos_jpg = null;
		try {
			fos_jpg = new FileOutputStream("D:\\fruit.jpg");
			ChartUtilities.writeChartAsJPEG(fos_jpg,1,chart,400,300,null);
		} finally {
			try {
				fos_jpg.close();
			} catch (Exception e) {}
		}
	}
	private static DefaultPieDataset getDataSet(){
		DefaultPieDataset dataset=new DefaultPieDataset();
		dataset.setValue("ƻ��", 100);
		dataset.setValue("����", 200);
		dataset.setValue("����", 300);
		dataset.setValue("�㽶", 400);
		dataset.setValue("��֦", 500);
		return dataset;
	}
}
