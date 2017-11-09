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
		//���÷�������ΪͼƬ
		response.setContentType("image/png");
		//��ȡ���ݼ�����
		CategoryDataset dataset=createDataset();
		//����ͼ�ζ���
		JFreeChart jfreechart=ChartFactory.createBarChart3D("08��ͼ���������а�", "������", "����", dataset,PlotOrientation.VERTICAL,true,true,false);
		//��ȡͼ���������
		CategoryPlot categoryPlot=(CategoryPlot)jfreechart.getPlot();
		//���x�����
		CategoryAxis categoryAxis=categoryPlot.getDomainAxis();
		//����x����ʾ�ķ������Ƶ���ʾλ�ã������������ˮƽ��ʾ
		//���ú󣬿���б����ʾ������Ƕȡ�ͼ��ռ�����ʱ���������
		categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(0.2926D));
		categoryAxis.setCategoryMargin(0.0D);
		//��ȡ��ʾͼ�����
		BarRenderer3D barRenderer3d=(BarRenderer3D)categoryPlot.getRenderer();
		//���ò���ʾ�߿���
		barRenderer3d.setDrawBarOutline(false);
		//��ͼ�����������ķ�ʽ���ظ��ͻ���
		ChartUtilities.writeChartAsPNG(response.getOutputStream(), jfreechart, 500, 270);
	}

	private CategoryDataset createDataset() {
		//ʱ��ά��
		String[] category1={"��һ����","�ڶ�����","��������","���ļ���"};
		//����ά��
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
