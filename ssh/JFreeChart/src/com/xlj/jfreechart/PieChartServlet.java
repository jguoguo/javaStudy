package com.xlj.jfreechart;

import java.awt.Font;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.ChartUtilities;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class PieChartServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置返回类型为图片
		response.setContentType("image/png");
		//获取数据集对象
		PieDataset dataset=createPieDataset();
		//创建图形对象
		JFreeChart jfreechart=ChartFactory.createPieChart3D("08年图书销量排行榜", dataset,true,true,false);
		//获取图标区域对象
		PiePlot pieplot=(PiePlot)jfreechart.getPlot();
		//设置标签字体
		pieplot.setLabelFont(new Font("宋体",0,12));
		//设置图表区域无数据时的默认显示文字
		pieplot.setNoDataMessage("没有销售数据");
		//设置图形区域不是圆形，由于是3D的饼形图，建议设置为false
		pieplot.setCircular(false);
		//设置图表区域文字与图表区域的间隔距离，0.02表示2%
		pieplot.setLabelGap(0.02D);
		ChartUtilities.writeChartAsPNG(response.getOutputStream(), jfreechart, 500, 270);
		
	}

	private PieDataset createPieDataset() {
		//创建饼形图数据集对象
		DefaultPieDataset defaultPieDataset=new DefaultPieDataset();
		//分别设置图形区域的说明和数据
		defaultPieDataset.setValue("JAVA", DataUtils.getRandomData());
		defaultPieDataset.setValue("C/C++", DataUtils.getRandomData());
		defaultPieDataset.setValue("PHP", DataUtils.getRandomData());
		defaultPieDataset.setValue("JavaScript", DataUtils.getRandomData());
		
		defaultPieDataset.setValue("Ajax", DataUtils.getRandomData());
		return defaultPieDataset;
	}
	
}
