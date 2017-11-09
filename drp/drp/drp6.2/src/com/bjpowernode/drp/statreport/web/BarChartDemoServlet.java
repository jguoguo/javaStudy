package com.bjpowernode.drp.statreport.web;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import com.bjpowernode.drp.statreport.manager.StatReportManager;
import com.bjpowernode.drp.util.filter.BaseServlet;

public class BarChartDemoServlet extends BaseServlet {

	CategoryDataset dataset = getDataSet();
	private StatReportManager statReportManager=null;
	@Override
	public void init() throws ServletException {
		statReportManager=(StatReportManager) getBeanFactory().getServiceObject(StatReportManager.class);
	}
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException 
	{
		JFreeChart chart = ChartFactory.createBarChart3D(
				"分销商等级分布图", // 图表标题
				"分销商", // 目录轴的显示标签
				"产量", // 数值轴的显示标签
				dataset, // 数据集
				PlotOrientation.VERTICAL, // 图表方向：水平、垂直
				true, 	// 是否显示图例(对于简单的柱状图必须是false)
				false, 	// 是否生成工具
				false 	// 是否生成URL链接
				);
		ChartUtilities.writeChartAsJPEG(res.getOutputStream(),1.0f,chart,400,300,null);
	}


	private  CategoryDataset getDataSet() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		Map<String,Integer> map=statReportManager.getClientLevelCount();
		for(Iterator<Map.Entry<String,Integer>> iter=map.entrySet().iterator();iter.hasNext();){
			Map.Entry<String,Integer> entry=iter.next();
			dataset.addValue(entry.getValue(), entry.getKey(), entry.getKey());
		}
//		dataset.addValue(100, "苹果", "苹果");
//		dataset.addValue(200, "梨子", "梨子");
//		dataset.addValue(300, "葡萄", "葡萄");
//		dataset.addValue(400, "香蕉", "香蕉");
//		dataset.addValue(500, "荔枝", "荔枝");
		return dataset;
	}
}
