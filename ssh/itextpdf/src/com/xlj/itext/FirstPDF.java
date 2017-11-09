package com.xlj.itext;

import java.awt.Color;
import java.io.FileOutputStream;

import com.lowagie.text.*;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;



public class FirstPDF {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//�����ĵ�����A4ֽ��С
		Document document=new Document(PageSize.A4);
		try{
			//���ΪE:\itext.pdf�ļ�
			PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream("E:\\itext.pdf"));
			//�����ĵ�����
			document.addAuthor("xlj");
			//�����ĵ�����
			document.addTitle("This is itext pdf file");
			//��������
			document.addSubject("First pdf");
			//���ùؼ���
			document.addKeywords("iText");
			//���ĵ�
			document.open();
			//pdf�ļ���д������
			document.add(new Paragraph("Hello World,Hello iText"));
			
			//������������
			BaseFont bfChiness=BaseFont.createFont("STSong-Light","UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
			Font fontChinese=new Font(bfChiness,12,Font.NORMAL);
			//����Ϊ����
			Paragraph pragraph=new Paragraph("��ã���������",fontChinese);
			
			document.add(pragraph);
			
			/*�������*/
			//����2��3�еı�
			Table table=new Table(3,2);
			//���ñ��߿���ɫ
			table.setBorderColor(new Color(220,100,100));
			//���ñ��߾�
			table.setPadding(5);
			//���ñ����
			table.setSpacing(3);
			//���ñ���������
			table.setBorderWidth(3);
			//������Ԫ�����
			Cell cell=new Cell("Header 1");
			//����Ԫ����ӵ������
			table.addCell(cell);
			cell=new Cell("Header 2");
			//���õ�Ԫ��ռ2��
			cell.setColspan(2);
			table.addCell(cell);
			//����ͨ�ı���ӵ������
			table.addCell("Cell 1");
			table.addCell("Cell 2");
			table.addCell("Cell 3");
			//�������ӵ��ĵ���
			document.add(table);
			
			
			/*����ͼ��*/
			//����ͼƬ���󣬲���ΪͼƬ���ļ���
			Image bmp=Image.getInstance("E:\\java.jpg");
			//��С��ԭ����25%
			bmp.scalePercent(25f);
			document.add(bmp);
			
			//�ر��ļ�
			document.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
