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
		//设置返回类型为图片
		response.setContentType("image/png");
		//获取数据集对象
		XYDataset dataset=createDataset();
		//创建图形对象
		JFreeChart jfreechart=ChartFactory.createTimeSeriesChart("时序图", "POLO历史价格", "价格", dataset,false,false,false);
		XYPlot xyplot=(XYPlot)jfreechart.getPlot();
		//获取折线显示对象
		XYLineAndShapeRenderer xyLineAndShapeRenderer=new XYLineAndShapeRenderer();
		//设置不显示折线
		xyLineAndShapeRenderer.setBaseShapesVisible(false);
		//设置折线的粗细
		xyLineAndShapeRenderer.setSeriesStroke(0, new BasicStroke(0.5f,1,1,5F,new float[]{5F,10F},0.0F));
		xyplot.setRenderer(xyLineAndShapeRenderer);
		//将图表以数据流的方式返回给客户端
		ChartUtilities.writeChartAsPNG(response.getOutputStream(), jfreechart, 500, 270);
	}

	private XYDataset createDataset() {
		//创建时序对象
		TimeSeries timeseries=new TimeSeries("JAVA");
		//初始化日期为1990年1月1日
		Day day=new Day(1,1,1990);
		double d=100000D;
		//添加1000条数据
		for(int i=0;i<4000;i++){
			try{
				d=(d+Math.random())-0.5d;
				//添加到时序对象
				timeseries.add(day,new Double(d));
				//之后的一天
				day=(Day)day.next();
			}catch(Exception e){
				
			}
		}
		return new TimeSeriesCollection(timeseries);
	}

}
