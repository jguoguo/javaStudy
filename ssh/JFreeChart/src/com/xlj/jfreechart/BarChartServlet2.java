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
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYBarDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class BarChartServlet2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//���÷�������ΪͼƬ
		response.setContentType("image/png");
		//��ȡ���ݼ�����
		IntervalXYDataset dataset=createDataset();
		//����ͼ�ζ���
		JFreeChart jfreechart=ChartFactory.createXYBarChart("08��ͼ���������а�", null, false,"����", dataset,PlotOrientation.VERTICAL,true,false,false);
		//���ñ���Ϊ��ɫ
		jfreechart.setBackgroundPaint(Color.white);
		//���ͼ���������
		XYPlot xyplot=(XYPlot)jfreechart.getPlot();
		//����������󱳾�Ϊ��ɫ
		xyplot.setBackgroundPaint(Color.LIGHT_GRAY);
		//����������������ߵ�Ϊ��ɫ
		xyplot.setDomainGridlinePaint(Color.white);
		//��ȡ��ʾͼ�ζ���
		XYBarRenderer xybarRenderer=(XYBarRenderer)xyplot.getRenderer();
		//���ò���ʾ�߿���
		xybarRenderer.setDrawBarOutline(false);
		//��ͼ�����������ķ�ʽ���ظ��ͻ���
		ChartUtilities.writeChartAsPNG(response.getOutputStream(), jfreechart, 500, 270);
	}

	private IntervalXYDataset createDataset() {
		//������������
		XYSeries xySeries=new XYSeries("JAVA");
		XYSeries xySeries1=new XYSeries("PHP");
		for(int i=1;i<12;i++){
			//�������
			xySeries.add(i,DataUtils.getRandomData());
			xySeries1.add(i,DataUtils.getRandomData());
		}
		XYSeriesCollection xyseriesCollection=new XYSeriesCollection();
		xyseriesCollection.addSeries(xySeries);
		xyseriesCollection.addSeries(xySeries1);
		return new XYBarDataset(xyseriesCollection,0.90000D);
	}

}
