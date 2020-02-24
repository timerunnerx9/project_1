package project_1_POJO;
import java.sql.Timestamp;

public class Reimb {

	private int reimb_id;//serial type, generated from database
	private Double reimb_amount;
	private Timestamp reimb_submitted;
	private Timestamp reimb_resolved;
	private String description;
	private Boolean reimb_receipt;
	private int reimb_author;
	private int reimb_resolver;
	private int reimb_status_id;
	private int reimb_type_id;
	
	
	
	
	//database will use the constructor below to create new object
	public Reimb(
			int reimb_id,
			Double reimb_amount,
			Timestamp reimb_submitted,
			Timestamp reimb_resolved,
			String description,
			Boolean reimb_receipt,
			int reimb_author,
			int reimb_resolver,
			int reimb_status_id,
			int reimb_type_id) {
		this.reimb_id = reimb_id;
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
		this.description = description;
		this.reimb_receipt = reimb_receipt;
		this.reimb_author = reimb_author;
		this.reimb_resolver = reimb_resolver;
		this.reimb_status_id = reimb_status_id;
		this.reimb_type_id = reimb_type_id;
	}

	
	
	
	//we will call the below constructor with our input as parameters to create a transit object
	public Reimb(
			Double reimb_amount,
			Timestamp reimb_submitted,
			Timestamp reimb_resolved,
			String description,
			Boolean reimb_receipt,
			int reimb_author,
			int reimb_resolver,
			int reimb_status_id,
			int reimb_type_id)
	{

		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
		this.description = description;
		this.reimb_receipt = reimb_receipt;
		this.reimb_author = reimb_author;
		this.reimb_resolver = reimb_resolver;
		this.reimb_status_id = reimb_status_id;
		this.reimb_type_id = reimb_type_id;
	}
	

	
	
	
	
	
	
	public int getReimb_id() {
		return reimb_id;
	}
	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}
	
	public Double getReimb_amount() {
		return reimb_amount;
	}
	public void setReimb_amount(Double reimb_amount) {
		this.reimb_amount = reimb_amount;
	}
	
	public Timestamp getReimb_submitted() {
		return reimb_submitted;
	}
	public void setReimb_submitted(Timestamp reimb_submitted) {
		this.reimb_submitted = reimb_submitted;
	}
	
	public Timestamp getReimb_resolved() {
		return reimb_resolved;
	}
	public void setReimb_resolved(Timestamp reimb_resolved) {
		this.reimb_resolved = reimb_resolved;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Boolean getReimb_receipt() {
		return reimb_receipt;
	}
	public void setReimb_receipt(Boolean reimb_receipt) {
		this.reimb_receipt = reimb_receipt;
	}
	
	public int getReimb_author() {
		return reimb_author;
	}
	public void setReimb_author(int reimb_author) {
		this.reimb_author = reimb_author;
	}
	
	public int getReimb_resolver() {
		return reimb_resolver;
	}
	public void setReimb_resolver(int reimb_resolver) {
		this.reimb_resolver = reimb_resolver;
	}
	
	public int getReimb_status_id() {
		return reimb_status_id;
	}
	public void setReimb_status_id(int reimb_status_id) {
		this.reimb_status_id = reimb_status_id;
	}
	
	public int getReimb_type_id() {
		return reimb_type_id;
	}
	public void setReimb_type_id(int reimb_type_id) {
		this.reimb_type_id = reimb_type_id;
	}

}
