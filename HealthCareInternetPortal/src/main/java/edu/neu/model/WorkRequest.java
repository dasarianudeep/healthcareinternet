package edu.neu.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class WorkRequest implements Serializable{
	
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int workrequestid;

	
	
	private String workrequeststatus;
	
	
	
	public WorkRequest()

{
		}
	
	

	
	




	public int getWorkrequestid() {
		return workrequestid;
	}


	public void setWorkrequestid(int workrequestid) {
		this.workrequestid = workrequestid;
	}


	

	

	public String getWorkrequeststatus() {
		return workrequeststatus;
	}

	public void setWorkrequeststatus(String workrequeststatus) {
		this.workrequeststatus = workrequeststatus;
	}
	
	public String toString()
	{
		return workrequeststatus;
	}
	
	
}
