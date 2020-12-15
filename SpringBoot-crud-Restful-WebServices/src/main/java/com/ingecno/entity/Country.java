package com.ingecno.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cid;
	
	private String cname;
	
	

	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Country(long cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}

	public long getCid() {
		return cid;
	}

	public void setCid(long cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Override
	public String toString() {
		return "Country [cid=" + cid + ", cname=" + cname + "]";
	}
	
	

}
