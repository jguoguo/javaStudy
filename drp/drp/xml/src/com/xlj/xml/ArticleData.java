package com.xlj.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;

//��Ԫ�صı�ǩ��Ϊarticles
@XmlRootElement(name="articles")
public class ArticleData {

	List<Article> article=new ArrayList<Article>();
	public List<Article> getArticle(){
		return article;
	}
	public void setArticle(List<Article> article){
		this.article=article;
	}
	public static void main(String[] args){
		//����������XML�����䱣����E�̵ĸ�Ŀ¼�µ�article.xml�ļ�
		File xmlFile=new File("E:\\article.xml");
		//����JAXBContext�����Ķ���
		JAXBContext context;
		try{
			//ͨ���ƶ�ӳ����ഴ��������
			context=JAXBContext.newInstance(ArticleData.class);
			//ͨ�������Ĵ���XMLת��java�Ķ���Unmarshaller
			Unmarshaller u=context.createUnmarshaller();
			//��XML����ת����java����
			ArticleData data=(ArticleData)u.unmarshal(xmlFile);
			//��ȡ���е�Article����
			List<Article> articles=data.getArticle();
			for(Article a:articles){
				System.out.println("-------------------");
				System.out.println(a.getAuthor());
				System.out.println(a.getDate());
				System.out.println(a.getEmail());
				System.out.println(a.getTitle());
			}
		}catch(JAXBException e){
			e.printStackTrace();
		}
	}
}
