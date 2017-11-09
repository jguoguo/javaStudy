package com.xlj.jfreechart;

import java.awt.Color;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleInsets;

public class AreaChartServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//���÷�������ΪͼƬ
		response.setContentType("image/png");
		//��ȡ���ݼ�����
		CategoryDataset dataset=createDataset();
		//����ͼ�ζ���
		JFreeChart jfreechart=ChartFactory.createAreaChart("08��ͼ���������а�", "������", "����", dataset,PlotOrientation.VERTICAL,true,true,false);
		//��ȡͼ���������
		CategoryPlot categoryPlot=(CategoryPlot)jfreechart.getPlot();
		//����ǰ��ɫΪ50%͸��
		categoryPlot.setForegroundAlpha(0.5f);
		//����X��ƫ����
		categoryPlot.setAxisOffset(new RectangleInsets(5D,5D,5D,5D));
		//���ñ���ɫΪǳ��ɫ
		categoryPlot.setBackgroundPaint(Color.LIGHT_GRAY);
		//������ʾ������
		categoryPlot.setDomainGridlinesVisible(true);
		//����������Ϊ��ɫ
		categoryPlot.setDomainGridlinePaint(Color.white);
		//������ʾ�߽���
		categoryPlot.setRangeGridlinesVisible(true);
		//������ʾ�߽���Ϊ��ɫ
		categoryPlot.setRangeGridlinePaint(Color.white);
		//���X�����
		CategoryAxis categoryaxis=categoryPlot.getDomainAxis();
		//����X���ǩλ��Ϊ45���
		categoryaxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
		//������X��Ĳ���Ϊ0
		categoryaxis.setLowerMargin(0.0D);
		categoryaxis.setUpperMargin(0.0D);
		
		//��ͼ�����������ķ�ʽ���ظ��ͻ���
		ChartUtilities.writeChartAsPNG(response.getOutputStream(), jfreechart, 500, 270);
		
	}


	private CategoryDataset createDataset() {
		//ʱ��ά��
		String[] category1={"��һ����","�ڶ�����","��������","���ļ���"};
		String[] category2={"java","C/C++","PHP"}; 
		DefaultCategoryDataset defaultdataset=new DefaultCategoryDataset();
		for(int i=0;i<category1.length;i++){
			String category=category1[i];
			for(int j=0;j<category2.length;j++){
				String cat=category2[j];
				//ģ���������
				defaultdataset.addValue(DataUtils.getRandomData(), cat, category);
			}
		}
		return defaultdataset;
	}

}
