package com.xlj.spring.dao;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class UpdateCreditRating extends SqlUpdate {//继承sqlupdate
	public UpdateCreditRating(DataSource ds){//构造函数
		setDataSource(ds);//设置数据源
		setSql("update customer set credit_rating=? where id=?");
		declareParameter(new SqlParameter(Types.NUMERIC));//设置参数位置
		declareParameter(new SqlParameter(Types.NUMERIC));//设置参数位置
		compile();//编译sql
	}
	public int run(int id,int rating){
		Object[] params=new Object[]{new Integer(rating),new Integer(id)};
		return update(params);
	}
}
