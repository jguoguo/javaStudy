package com.xlj.jfreechart;

import java.awt.Font;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.ChartUtilities;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class PieChartServlet extends HttpServlet {

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
		PieDataset dataset=createPieDataset();
		//����ͼ�ζ���
		JFreeChart jfreechart=ChartFactory.createPieChart3D("08��ͼ���������а�", dataset,true,true,false);
		//��ȡͼ���������
		PiePlot pieplot=(PiePlot)jfreechart.getPlot();
		//���ñ�ǩ����
		pieplot.setLabelFont(new Font("����",0,12));
		//����ͼ������������ʱ��Ĭ����ʾ����
		pieplot.setNoDataMessage("û����������");
		//����ͼ��������Բ�Σ�������3D�ı���ͼ����������Ϊfalse
		pieplot.setCircular(false);
		//����ͼ������������ͼ������ļ�����룬0.02��ʾ2%
		pieplot.setLabelGap(0.02D);
		ChartUtilities.writeChartAsPNG(response.getOutputStream(), jfreechart, 500, 270);
		
	}

	private PieDataset createPieDataset() {
		//��������ͼ���ݼ�����
		DefaultPieDataset defaultPieDataset=new DefaultPieDataset();
		//�ֱ�����ͼ�������˵��������
		defaultPieDataset.setValue("JAVA", DataUtils.getRandomData());
		defaultPieDataset.setValue("C/C++", DataUtils.getRandomData());
		defaultPieDataset.setValue("PHP", DataUtils.getRandomData());
		defaultPieDataset.setValue("JavaScript", DataUtils.getRandomData());
		
		defaultPieDataset.setValue("Ajax", DataUtils.getRandomData());
		return defaultPieDataset;
	}
	
}
