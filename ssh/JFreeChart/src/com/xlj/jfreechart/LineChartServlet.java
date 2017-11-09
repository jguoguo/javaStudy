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
		//设置返回类型为图片
		response.setContentType("image/png");
		//获取数据集对象
		CategoryDataset dataset=createDataset();
		//创建图形对象
		JFreeChart jfreechart=ChartFactory.createLineChart("08年图书销量", null, "销量", dataset,PlotOrientation.VERTICAL,false,true,false);
		//设置图表的子标题
		jfreechart.addSubtitle(new TextTitle("按月份"));
		//创建一个标题
		TextTitle texttitle=new TextTitle("日期："+new Date());
		//设置标题字体
		texttitle.setFont(new Font("黑体",0,10));
		//设置标题向下对齐
		texttitle.setHorizontalAlignment(HorizontalAlignment.RIGHT);
		//添加图表的子标题
		jfreechart.addSubtitle(texttitle);
		//设置图表的背景色为白色
		jfreechart.setBackgroundPaint(Color.white);
		//获取图表区域对象
		CategoryPlot categoryPlot=(CategoryPlot)jfreechart.getPlot();
		categoryPlot.setBackgroundPaint(Color.LIGHT_GRAY);
		categoryPlot.setRangeGridlinesVisible(false);
		//获取显示线条对象
		LineAndShapeRenderer lineAndShapeRenderer=(LineAndShapeRenderer)categoryPlot.getRenderer();
		lineAndShapeRenderer.setBaseShapesVisible(true);
		lineAndShapeRenderer.setDrawOutlines(true);
		lineAndShapeRenderer.setUseFillPaint(true);
		lineAndShapeRenderer.setBaseFillPaint(Color.white);
		//设置折线加粗
		lineAndShapeRenderer.setSeriesStroke(0, new BasicStroke(3F));
		lineAndShapeRenderer.setSeriesOutlineStroke(0, new BasicStroke(2.0F));
		
		//设置折线拐点
		lineAndShapeRenderer.setSeriesShape(0, new java.awt.geom.Ellipse2D.Double(-5D,-5D,10D,10D));
		
		//将图表以数据流的方式返回给客户端
		ChartUtilities.writeChartAsPNG(response.getOutputStream(), jfreechart, 500, 270);
	}

	private CategoryDataset createDataset() {
		DefaultCategoryDataset defaultdataset=new DefaultCategoryDataset();
		for(int i=1;i<12;i++){
			defaultdataset.addValue(DataUtils.getRandomData(), "JAVA", i+"月");
			defaultdataset.addValue(DataUtils.getRandomData(), "PHP", i+"月");
		}
		return defaultdataset;
	}

}
