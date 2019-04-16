package com.example.checklist.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Entry {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@ManyToOne
	@JoinColumn(name = "importanceid")
	private Importance importance;
	private String entryName;
	private String entryText;
	
	public Entry() {}
	
	public Entry(Importance importance, String entryName, String entryText) {
		this.importance = importance;
		this.entryName = entryName;
		this.entryText = entryText;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Importance getImportance() {
		return importance;
	}

	public void setImportance(Importance importance) {
		this.importance = importance;
	}

	public String getEntryName() {
		return entryName;
	}

	public void setEntryName(String entryName) {
		this.entryName = entryName;
	}

	public String getEntryText() {
		return entryText;
	}

	public void setEntryText(String entryText) {
		this.entryText = entryText;
	}

	@Override
	public String toString() {
		return "Entry [id=" + id + ", importance=" + importance + ", entryName=" + entryName + ", entryText="
				+ entryText + "]";
	}

}
