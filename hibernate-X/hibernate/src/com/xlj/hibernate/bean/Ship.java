package com.xlj.hibernate.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_ship")
public class Ship {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;//船的名称
	@OneToOne(cascade={CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="captain_id",unique=true)//外键为caption_id,为保证一对一关系，需声明unique属性为true
	private Sailor captain;//船长
	
	@OneToMany(mappedBy="ship",cascade=CascadeType.PERSIST)//使用反向配置
	
	private Set<Sailor> sailors=new HashSet<Sailor>();

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

	public Sailor getCaptain() {
		return captain;
	}

	public void setCaptain(Sailor captain) {
		this.captain = captain;
	}

	public Set<Sailor> getSailors() {
		return sailors;
	}

	public void setSailors(Set<Sailor> sailors) {
		this.sailors = sailors;
	}
	
}
