package com.mapping.manytomany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Emp {
	@Id
	private int eid;

	private String name;

	@ManyToMany
	@JoinTable(name="empAndProjectConnected",		 // this is a join column (the primary key of this table will be connected by primary key o the Project table (will act as foreign key))
		joinColumns = { @JoinColumn(name="eid") } ,		// the first column of the join table
		inverseJoinColumns = { @JoinColumn(name="pid") }		// the second column of the join table
	)
	private List<Project> projects;

	public Emp(int eid, String name, List<Project> projects) {
		super();
		this.eid = eid;
		this.name = name;
		this.projects = projects;
	}

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

}
