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

		//设置返回类型为图片
		response.setContentType("image/png");
		//获取数据集对象
		CategoryDataset dataset=createDataset();
		//创建图形对象
		JFreeChart jfreechart=ChartFactory.createAreaChart("08年图书销量排行榜", "按季度", "销量", dataset,PlotOrientation.VERTICAL,true,true,false);
		//获取图标区域对象
		CategoryPlot categoryPlot=(CategoryPlot)jfreechart.getPlot();
		//设置前景色为50%透明
		categoryPlot.setForegroundAlpha(0.5f);
		//设置X轴偏移量
		categoryPlot.setAxisOffset(new RectangleInsets(5D,5D,5D,5D));
		//设置背景色为浅灰色
		categoryPlot.setBackgroundPaint(Color.LIGHT_GRAY);
		//设置显示网格线
		categoryPlot.setDomainGridlinesVisible(true);
		//设置网格线为白色
		categoryPlot.setDomainGridlinePaint(Color.white);
		//设置显示边界线
		categoryPlot.setRangeGridlinesVisible(true);
		//设置显示边界线为白色
		categoryPlot.setRangeGridlinePaint(Color.white);
		//获得X轴对象
		CategoryAxis categoryaxis=categoryPlot.getDomainAxis();
		//设置X轴标签位置为45°角
		categoryaxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
		//设置与X轴的补白为0
		categoryaxis.setLowerMargin(0.0D);
		categoryaxis.setUpperMargin(0.0D);
		
		//将图表以数据流的方式返回给客户端
		ChartUtilities.writeChartAsPNG(response.getOutputStream(), jfreechart, 500, 270);
		
	}


	private CategoryDataset createDataset() {
		//时间维度
		String[] category1={"第一季度","第二季度","第三季度","第四季度"};
		String[] category2={"java","C/C++","PHP"}; 
		DefaultCategoryDataset defaultdataset=new DefaultCategoryDataset();
		for(int i=0;i<category1.length;i++){
			String category=category1[i];
			for(int j=0;j<category2.length;j++){
				String cat=category2[j];
				//模拟添加数据
				defaultdataset.addValue(DataUtils.getRandomData(), cat, category);
			}
		}
		return defaultdataset;
	}

}
