package com.revature.beans;

import java.sql.Date;

public class Reimbursement {
	private int id;
	private double amount;
	private Date date_submitted;
	private Date date_resolved;
	private String description;
	private int author_id;
	private int resolver_id;
	private String status; //open, approved, denied
	
	
	
	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", date_submitted=" + date_submitted
				+ ", date_resolved=" + date_resolved + ", description=" + description + ", author_id=" + author_id
				+ ", resolver_id=" + resolver_id + ", status=" + status + "]";
	}
	public Reimbursement(int id, double amount, Date date_submitted, Date date_resolved, String description,
			int author_id, int resolver_id, String status) {
		super();
		this.id = id;
		this.amount = amount;
		this.date_submitted = date_submitted;
		this.date_resolved = date_resolved;
		this.description = description;
		this.author_id = author_id;
		this.resolver_id = resolver_id;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getDate_submitted() {
		return date_submitted;
	}
	public void setDate_submitted(Date date_submitted) {
		this.date_submitted = date_submitted;
	}
	public Date getDate_resolved() {
		return date_resolved;
	}
	public void setDate_resolved(Date date_resolved) {
		this.date_resolved = date_resolved;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	public int getResolver_id() {
		return resolver_id;
	}
	public void setResolver_id(int resolver_id) {
		this.resolver_id = resolver_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
