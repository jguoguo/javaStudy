package com.xlj.jfreechart;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.HorizontalAlignment;

public class LineChartServlet extends HttpServlet {

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
		JFreeChart jfreechart=ChartFactory.createLineChart("08��ͼ������", null, "����", dataset,PlotOrientation.VERTICAL,false,true,false);
		//����ͼ����ӱ���
		jfreechart.addSubtitle(new TextTitle("���·�"));
		//����һ������
		TextTitle texttitle=new TextTitle("���ڣ�"+new Date());
		//���ñ�������
		texttitle.setFont(new Font("����",0,10));
		//���ñ������¶���
		texttitle.setHorizontalAlignment(HorizontalAlignment.RIGHT);
		//���ͼ����ӱ���
		jfreechart.addSubtitle(texttitle);
		//����ͼ��ı���ɫΪ��ɫ
		jfreechart.setBackgroundPaint(Color.white);
		//��ȡͼ���������
		CategoryPlot categoryPlot=(CategoryPlot)jfreechart.getPlot();
		categoryPlot.setBackgroundPaint(Color.LIGHT_GRAY);
		categoryPlot.setRangeGridlinesVisible(false);
		//��ȡ��ʾ��������
		LineAndShapeRenderer lineAndShapeRenderer=(LineAndShapeRenderer)categoryPlot.getRenderer();
		lineAndShapeRenderer.setBaseShapesVisible(true);
		lineAndShapeRenderer.setDrawOutlines(true);
		lineAndShapeRenderer.setUseFillPaint(true);
		lineAndShapeRenderer.setBaseFillPaint(Color.white);
		//�������߼Ӵ�
		lineAndShapeRenderer.setSeriesStroke(0, new BasicStroke(3F));
		lineAndShapeRenderer.setSeriesOutlineStroke(0, new BasicStroke(2.0F));
		
		//�������߹յ�
		lineAndShapeRenderer.setSeriesShape(0, new java.awt.geom.Ellipse2D.Double(-5D,-5D,10D,10D));
		
		//��ͼ�����������ķ�ʽ���ظ��ͻ���
		ChartUtilities.writeChartAsPNG(response.getOutputStream(), jfreechart, 500, 270);
	}

	private CategoryDataset createDataset() {
		DefaultCategoryDataset defaultdataset=new DefaultCategoryDataset();
		for(int i=1;i<12;i++){
			defaultdataset.addValue(DataUtils.getRandomData(), "JAVA", i+"��");
			defaultdataset.addValue(DataUtils.getRandomData(), "PHP", i+"��");
		}
		return defaultdataset;
	}

}
