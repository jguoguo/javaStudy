package com.xlj.jfreechart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.CombinedDomainCategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class CombinedChartServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//���÷�������ΪͼƬ
		response.setContentType("image/png");
		//������һ�����ݼ�
		CategoryDataset categorydataset=createDataset();
		NumberAxis numberAxis=new NumberAxis("����");
		numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		LineAndShapeRenderer lineAndShapeRenderer=new LineAndShapeRenderer();
		CategoryPlot categoryplot=new CategoryPlot(categorydataset,null,numberAxis,lineAndShapeRenderer);
		categoryplot.setDomainGridlinesVisible(true);
		//������һ�����ݼ�
		CategoryDataset categorydataset1=createDataset();
		NumberAxis numberAxis1=new NumberAxis("����");
		BarRenderer barrenderer=new BarRenderer();
		barrenderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
		CategoryPlot categoryplot1=new CategoryPlot(categorydataset1,null,numberAxis1,barrenderer);
		categoryplot1.setDomainGridlinesVisible(true);
		
		//����������ݼ�
		CategoryAxis categroyAxis=new CategoryAxis();
		CombinedDomainCategoryPlot combinedDomainCategoryPlot=new CombinedDomainCategoryPlot(categroyAxis);
		combinedDomainCategoryPlot.add(categoryplot,2);
		combinedDomainCategoryPlot.add(categoryplot1,1);
		
		JFreeChart jfreechart=new JFreeChart("���ͼ",null,combinedDomainCategoryPlot,true);
		//��ͼ�����������ķ�ʽ���ظ��ͻ���
		ChartUtilities.writeChartAsPNG(response.getOutputStream(), jfreechart, 500, 270);
	}


	private CategoryDataset createDataset() {
		//ʱ��ά��
		String[] category1={"��һ����","�ڶ�����","��������","���ļ���"};
		//����ά��
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
