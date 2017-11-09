package com.xlj.spring.dao;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class UpdateCreditRating extends SqlUpdate {//�̳�sqlupdate
	public UpdateCreditRating(DataSource ds){//���캯��
		setDataSource(ds);//��������Դ
		setSql("update customer set credit_rating=? where id=?");
		declareParameter(new SqlParameter(Types.NUMERIC));//���ò���λ��
		declareParameter(new SqlParameter(Types.NUMERIC));//���ò���λ��
		compile();//����sql
	}
	public int run(int id,int rating){
		Object[] params=new Object[]{new Integer(rating),new Integer(id)};
		return update(params);
	}
}
