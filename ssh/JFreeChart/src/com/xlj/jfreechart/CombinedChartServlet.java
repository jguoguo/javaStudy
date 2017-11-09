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
		//设置返回类型为图片
		response.setContentType("image/png");
		//创建第一个数据集
		CategoryDataset categorydataset=createDataset();
		NumberAxis numberAxis=new NumberAxis("销量");
		numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		LineAndShapeRenderer lineAndShapeRenderer=new LineAndShapeRenderer();
		CategoryPlot categoryplot=new CategoryPlot(categorydataset,null,numberAxis,lineAndShapeRenderer);
		categoryplot.setDomainGridlinesVisible(true);
		//创建第一个数据集
		CategoryDataset categorydataset1=createDataset();
		NumberAxis numberAxis1=new NumberAxis("销量");
		BarRenderer barrenderer=new BarRenderer();
		barrenderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
		CategoryPlot categoryplot1=new CategoryPlot(categorydataset1,null,numberAxis1,barrenderer);
		categoryplot1.setDomainGridlinesVisible(true);
		
		//创建组合数据集
		CategoryAxis categroyAxis=new CategoryAxis();
		CombinedDomainCategoryPlot combinedDomainCategoryPlot=new CombinedDomainCategoryPlot(categroyAxis);
		combinedDomainCategoryPlot.add(categoryplot,2);
		combinedDomainCategoryPlot.add(categoryplot1,1);
		
		JFreeChart jfreechart=new JFreeChart("组合图",null,combinedDomainCategoryPlot,true);
		//将图表以数据流的方式返回给客户端
		ChartUtilities.writeChartAsPNG(response.getOutputStream(), jfreechart, 500, 270);
	}


	private CategoryDataset createDataset() {
		//时间维度
		String[] category1={"第一季度","第二季度","第三季度","第四季度"};
		//分类维度
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
