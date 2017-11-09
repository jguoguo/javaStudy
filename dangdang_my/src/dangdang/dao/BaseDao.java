package dangdang.dao;

import java.io.Serializable;
import java.util.List;
/**
 * 对数据库进行基础操作的接口。功能如下：
 * @author soft01
 *<ul>
 *<li>在数据库中添加一条记录</li>
 *<li>从数据库中删除一条记录</li>
 *<li>在数据库中更新一条记录</li>
 *<li>在数据库中通过id查找一条记录</li>
 *<li>在数据库中通过对象查找该对象对应的所有记录</li>
 *<li>在数据库中通过对象按分页查找该对象对应的所有记录</li>
 *</ul>
 * @param <T>
 */
public interface BaseDao<T> {
	/**
	 * 插入<T>类型的数据到数据库
	 * @param t
	 */
	void save(T t);
	/**
	 * 从数据库删除<T>类型的数据
	 * @param t
	 */
	void delete(T t);
	/**
	 * 更新数据库中对应的数据
	 * @param t
	 */
	void update(T t);
/**
 * 通过id从数据库查找数据
 * @param clazz
 * @param id
 * @return
 */
	T findById(Class<T> clazz,Serializable id);
	/**
	 * 从数据库中查找<T>对象数据，并放入List<T>
	 * @param clazz
	 * @return
	 */
	List<T> findAll(Class<T> clazz);
	/**
	 * 按页，从数据库中查找<T>对象数据，并放入List<T>
	 * @param clazz
	 * @param p
	 * @return
	 */
	List<T> findAll(Class<T> clazz,Pagination p);
}
