package com.example.checklist.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Importance {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long importanceid;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "importance")
	private List<Entry> entries;
	private String importanceState;
	
	public Importance() {}
	
	public Importance(String importanceState) {
		this.importanceState = importanceState;
	}

	public long getImportanceid() {
		return importanceid;
	}

	public void setImportanceid(long importanceid) {
		this.importanceid = importanceid;
	}

	public List<Entry> getEntries() {
		return entries;
	}

	public void setEntries(List<Entry> entries) {
		this.entries = entries;
	}

	public String getImportanceState() {
		return importanceState;
	}

	public void setImportanceState(String importanceState) {
		this.importanceState = importanceState;
	}

	@Override
	public String toString() {
		return "Importance [importanceid=" + importanceid + ", entries=" + entries + ", importanceState=" + importanceState + "]";
	}

}
