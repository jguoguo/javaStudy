package com.bjpowernode.drp.statreport.web;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

import com.bjpowernode.drp.flowcard.manager.FlowCardManager;
import com.bjpowernode.drp.statreport.manager.StatReportManager;
import com.bjpowernode.drp.util.filter.BaseServlet;

public class ChartDemoServlet extends BaseServlet {
	
	private StatReportManager statReportManager=null;
	@Override
	public void init() throws ServletException {
		statReportManager=(StatReportManager) getBeanFactory().getServiceObject(StatReportManager.class);
	}
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException 
	{
		res.setContentType("image/jpeg");
		DefaultPieDataset data = getDataSet();
		JFreeChart chart = ChartFactory.createPieChart3D("�����̵ȼ��ֲ�ͼ", data, true,
				false, false);
		PiePlot3D plot=(PiePlot3D)chart.getPlot();
		// ͼƬ����ʾ�ٷֱ�:Ĭ�Ϸ�ʽ
		//plot.setLabelGenerator(new StandardPieSectionLabelGenerator(StandardPieToolTipGenerator.DEFAULT_TOOLTIP_FORMAT));
		// ͼƬ����ʾ�ٷֱ�:�Զ��巽ʽ��{0} ��ʾѡ� {1} ��ʾ��ֵ�� {2} ��ʾ��ռ���� ,С�������λ
		plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}={1}({2})", NumberFormat.getNumberInstance(), new DecimalFormat("0.00%")));
		// ͼ����ʾ�ٷֱ�:�Զ��巽ʽ�� {0} ��ʾѡ� {1} ��ʾ��ֵ�� {2} ��ʾ��ռ����
		plot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator("{0}={1}({2})")); 
		ChartUtilities.writeChartAsJPEG(res.getOutputStream(), 1.0f, chart, 400,
				300, null);
	}
	/**
	 * ��ȡһ����ʾ�õļ����ݼ�����
	 * @return
	 */
	private DefaultPieDataset getDataSet() {
		DefaultPieDataset dataset = new DefaultPieDataset();
//		dataset.setValue("һ��������",100);
//		dataset.setValue("����������",200);
//		dataset.setValue("����������",300);
		Map<String,Integer> map=statReportManager.getClientLevelCount();
		for(Iterator<Map.Entry<String,Integer>> iter=map.entrySet().iterator();iter.hasNext();){
			Map.Entry<String,Integer> entry=iter.next();
			dataset.setValue(entry.getKey(),entry.getValue());
		}
		return dataset;
	}
}
