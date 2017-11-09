package dangdang.test;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dangdang.entity.Book;
import dangdang.entity.Category;

public class TestCase1 {
	@Test
	public void test2() {
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(
			"applicationContext*.xml");
		SessionFactory f = 
			(SessionFactory)ac.getBean("sessionFactory");
		Session s = f.openSession();
		Category c = (Category)s.get(Category.class, 2);
		System.out.println(c.getCnName());
		List<Category> list = c.getSubCategorys();
		for (Category sub : list) {
			System.out.print(sub.getParent().getCnName());
			System.out.print(" - ");
			System.out.println(sub.getCnName());
		}
	}
	@Test
	public void test1() {
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(
				"applicationContext*.xml");
		SessionFactory f = 
			(SessionFactory)ac.getBean("sessionFactory");
		Session s = f.openSession();
		List<Book> list = s.createQuery("from Book").list();
		for (Book b : list) {
			System.out.println(b.getId());
			System.out.println(b.getProductName());
			System.out.println(b.getAuthor());
		}
	}
}







