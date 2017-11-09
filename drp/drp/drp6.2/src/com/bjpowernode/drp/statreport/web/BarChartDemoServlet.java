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
				"�����̵ȼ��ֲ�ͼ", // ͼ�����
				"������", // Ŀ¼�����ʾ��ǩ
				"����", // ��ֵ�����ʾ��ǩ
				dataset, // ���ݼ�
				PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ
				true, 	// �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������false)
				false, 	// �Ƿ����ɹ���
				false 	// �Ƿ�����URL����
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
//		dataset.addValue(100, "ƻ��", "ƻ��");
//		dataset.addValue(200, "����", "����");
//		dataset.addValue(300, "����", "����");
//		dataset.addValue(400, "�㽶", "�㽶");
//		dataset.addValue(500, "��֦", "��֦");
		return dataset;
	}
}
