package dangdang.dao;
/**
 * 图书排序方案的实体。
 * @author soft01
 *
 */
public class BookOrder {
   private String field;
   private boolean desc ;
   private String orderString;
   
   /**
    * 创建图书排序方案
    */
public BookOrder() {
	super();
}

/**
 * 创建一个以orderString为排序方式，以field为要求排序的字段的图书排序方案
 * @param field
 * @param orderString
 */
public BookOrder(String field, String orderString) {
	super();
	this.field = field;
	this.orderString = orderString;
}

/**
 * 创建一个以os为排序方式的图书排序方案
 * @param os
 */
public BookOrder(String os) {

	if(os==null||"".equals(os)){
		this.orderString="dangPrice|false";
	}else{
		this.orderString = os;
	}
}
/**
 * 获得排序方式
 * @return
 */
public String getOrderString() {
	return orderString;
}
/**
 * 设置排序方式
 * @param oo
 */
public void setOrderString(String oo) {
	if("".equals(oo)||null==oo){
		this.orderString="dangPrice|false";
	}
	this.orderString = oo;
	String[] arr = orderString.split("\\|");
	field = arr[0];
	desc = Boolean.parseBoolean(arr[1]);
}
/**
 * 获得要求排序的字段
 * @return
 */
public String getField() {
	return field;
}
/**
 * 设置要求排序的字段
 * @param field
 */
public void setField(String field) {
	this.field = field;
}
/**
 * 获得排序的升降方式
 * @return
 */
public boolean isDesc() {
	return desc;
}
/**
 * 设置排序的升降方式
 * @param desc
 */
public void setDesc(boolean desc) {
	this.desc = desc;
}
   
}
