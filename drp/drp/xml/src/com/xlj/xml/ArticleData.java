package com.xlj.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;

//根元素的标签名为articles
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
		//创建解析的XML对象，其保存在E盘的根目录下的article.xml文件
		File xmlFile=new File("E:\\article.xml");
		//声明JAXBContext上下文对象
		JAXBContext context;
		try{
			//通过制定映射的类创建上下文
			context=JAXBContext.newInstance(ArticleData.class);
			//通过上下文创建XML转化java的对象Unmarshaller
			Unmarshaller u=context.createUnmarshaller();
			//将XML数据转换成java对象
			ArticleData data=(ArticleData)u.unmarshal(xmlFile);
			//获取所有的Article数据
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
