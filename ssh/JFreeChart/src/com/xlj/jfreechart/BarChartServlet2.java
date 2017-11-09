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
		//设置返回类型为图片
		response.setContentType("image/png");
		//获取数据集对象
		IntervalXYDataset dataset=createDataset();
		//创建图形对象
		JFreeChart jfreechart=ChartFactory.createXYBarChart("08年图书销量排行榜", null, false,"销量", dataset,PlotOrientation.VERTICAL,true,false,false);
		//设置背景为白色
		jfreechart.setBackgroundPaint(Color.white);
		//获得图表区域对象
		XYPlot xyplot=(XYPlot)jfreechart.getPlot();
		//设置区域对象背景为灰色
		xyplot.setBackgroundPaint(Color.LIGHT_GRAY);
		//设置区域对象网格线调为白色
		xyplot.setDomainGridlinePaint(Color.white);
		//获取显示图形对象
		XYBarRenderer xybarRenderer=(XYBarRenderer)xyplot.getRenderer();
		//设置不显示边框线
		xybarRenderer.setDrawBarOutline(false);
		//将图表以数据流的方式返回给客户端
		ChartUtilities.writeChartAsPNG(response.getOutputStream(), jfreechart, 500, 270);
	}

	private IntervalXYDataset createDataset() {
		//创建基本数据
		XYSeries xySeries=new XYSeries("JAVA");
		XYSeries xySeries1=new XYSeries("PHP");
		for(int i=1;i<12;i++){
			//添加数据
			xySeries.add(i,DataUtils.getRandomData());
			xySeries1.add(i,DataUtils.getRandomData());
		}
		XYSeriesCollection xyseriesCollection=new XYSeriesCollection();
		xyseriesCollection.addSeries(xySeries);
		xyseriesCollection.addSeries(xySeries1);
		return new XYBarDataset(xyseriesCollection,0.90000D);
	}

}
