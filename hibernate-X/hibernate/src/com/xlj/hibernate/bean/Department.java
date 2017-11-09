package com.xlj.hibernate.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_department")
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;//��������
	private String description;//��������
	
	@OneToOne							//һ��һ
	@JoinColumn(name="line_manager_id")	//�����������
	private Employee lineManager;		//��������
	
	@OneToMany(mappedBy="department")//��ӦEmployee��department����
	private Set<Employee> employee=new HashSet<Employee>();//Ա��������

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Employee getLineManager() {
		return lineManager;
	}

	public void setLineManager(Employee lineManager) {
		this.lineManager = lineManager;
	}

	public Set<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(Set<Employee> employee) {
		this.employee = employee;
	}
	
	
}
