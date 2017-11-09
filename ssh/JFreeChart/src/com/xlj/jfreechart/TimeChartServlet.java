package com.xlj.jfreechart;

import java.awt.BasicStroke;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

public class TimeChartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//���÷�������ΪͼƬ
		response.setContentType("image/png");
		//��ȡ���ݼ�����
		XYDataset dataset=createDataset();
		//����ͼ�ζ���
		JFreeChart jfreechart=ChartFactory.createTimeSeriesChart("ʱ��ͼ", "POLO��ʷ�۸�", "�۸�", dataset,false,false,false);
		XYPlot xyplot=(XYPlot)jfreechart.getPlot();
		//��ȡ������ʾ����
		XYLineAndShapeRenderer xyLineAndShapeRenderer=new XYLineAndShapeRenderer();
		//���ò���ʾ����
		xyLineAndShapeRenderer.setBaseShapesVisible(false);
		//�������ߵĴ�ϸ
		xyLineAndShapeRenderer.setSeriesStroke(0, new BasicStroke(0.5f,1,1,5F,new float[]{5F,10F},0.0F));
		xyplot.setRenderer(xyLineAndShapeRenderer);
		//��ͼ�����������ķ�ʽ���ظ��ͻ���
		ChartUtilities.writeChartAsPNG(response.getOutputStream(), jfreechart, 500, 270);
	}

	private XYDataset createDataset() {
		//����ʱ�����
		TimeSeries timeseries=new TimeSeries("JAVA");
		//��ʼ������Ϊ1990��1��1��
		Day day=new Day(1,1,1990);
		double d=100000D;
		//���1000������
		for(int i=0;i<4000;i++){
			try{
				d=(d+Math.random())-0.5d;
				//��ӵ�ʱ�����
				timeseries.add(day,new Double(d));
				//֮���һ��
				day=(Day)day.next();
			}catch(Exception e){
				
			}
		}
		return new TimeSeriesCollection(timeseries);
	}

}
