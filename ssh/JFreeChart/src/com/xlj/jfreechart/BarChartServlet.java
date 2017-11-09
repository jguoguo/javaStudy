package com.xlj.jfreechart;

import java.io.IOException;

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
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarChartServlet extends HttpServlet {

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
		CategoryDataset dataset=createDataset();
		//创建图形对象
		JFreeChart jfreechart=ChartFactory.createBarChart3D("08年图书销量排行榜", "按季度", "销量", dataset,PlotOrientation.VERTICAL,true,true,false);
		//获取图表区域对象
		CategoryPlot categoryPlot=(CategoryPlot)jfreechart.getPlot();
		//获得x轴对象
		CategoryAxis categoryAxis=categoryPlot.getDomainAxis();
		//设置x轴显示的分类名称的显示位置，如果不设置则水平显示
		//设置后，可以斜向显示。分类角度、图表空间有限时，建议采用
		categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(0.2926D));
		categoryAxis.setCategoryMargin(0.0D);
		//获取显示图像对象
		BarRenderer3D barRenderer3d=(BarRenderer3D)categoryPlot.getRenderer();
		//设置不显示边框线
		barRenderer3d.setDrawBarOutline(false);
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
			String catetory=category1[i];
			for(int j=0;j<category2.length;j++){
				String cat=category2[j];
				defaultdataset.addValue(DataUtils.getRandomData(), cat, catetory);
			}
		}
		return defaultdataset;
	}

}
