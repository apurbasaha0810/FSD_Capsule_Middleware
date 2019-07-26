package com.fse.taskmanager.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@NamedNativeQueries({
	@NamedNativeQuery(
			name = "callGetAllTasks",
			query = "CALL taskDetails()",
			resultClass = Task.class),
	@NamedNativeQuery(
			name = "callFinishTask",
			query = "CALL finishTask(?)",
			resultClass = Task.class),
	@NamedNativeQuery(
			name = "callSpecificTask",
			query = "CALL taskSpecificDetails(?)",
			resultClass = Task.class),
	@NamedNativeQuery(
			name = "callUpdateSpecificTask",
			query = "CALL updateSpecificTask(?,?,?,?,?,?)",
			resultClass = Task.class),
	@NamedNativeQuery(
			name = "callAddTask",
			query = "CALL addTask(?,?,?,?,?,?,?)",
			resultClass = Task.class),
})

@Entity
@Table(name = "task")

public class Task {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int task_id;
	@Column
	private int parent_id;
	@Column
	private int project_id;
	@Column
	private String task;
	@Column
	private Date start_date;
	@Column
	private Date end_date;
	@Column
	private String priority;
	@Column
	private String status;
	private Integer user_id;
	private String user_name;
	private String parent_task;
	private String project_name;
	/**
	 * @return the task_id
	 */
	 public int getTask_id() {
		 return task_id;
	 }
	 /**
	  * @param task_id the task_id to set
	  */
	 public void setTask_id(int task_id) {
		 this.task_id = task_id;
	 }
	 /**
	  * @return the parent_id
	  */
	 public int getParent_id() {
		 return parent_id;
	 }
	 /**
	  * @param parent_id the parent_id to set
	  */
	 public void setParent_id(int parent_id) {
		 this.parent_id = parent_id;
	 }
	 /**
	  * @return the project_id
	  */
	 public int getProject_id() {
		 return project_id;
	 }
	 /**
	  * @param project_id the project_id to set
	  */
	 public void setProject_id(int project_id) {
		 this.project_id = project_id;
	 }
	 /**
	  * @return the task
	  */
	 public String getTask() {
		 return task;
	 }
	 /**
	  * @param task the task to set
	  */
	 public void setTask(String task) {
		 this.task = task;
	 }
	 /**
	  * @return the start_date
	  */
	 public Date getStart_date() {
		 return start_date;
	 }
	 /**
	  * @param start_date the start_date to set
	  */
	 public void setStart_date(Date start_date) {
		 this.start_date = start_date;
	 }
	 /**
	  * @return the end_date
	  */
	 public Date getEnd_date() {
		 return end_date;
	 }
	 /**
	  * @param end_date the end_date to set
	  */
	 public void setEnd_date(Date end_date) {
		 this.end_date = end_date;
	 }
	 /**
	  * @return the priority
	  */
	 public String getPriority() {
		 return priority;
	 }
	 /**
	  * @param priority the priority to set
	  */
	 public void setPriority(String priority) {
		 this.priority = priority;
	 }
	 /**
	  * @return the status
	  */
	 public String getStatus() {
		 return status;
	 }
	 /**
	  * @param status the status to set
	  */
	 public void setStatus(String status) {
		 this.status = status;
	 }
	 /**
	  * @return the user_id
	  */
	 public Integer getUser_id() {
		 return user_id;
	 }
	 /**
	  * @param user_id the user_id to set
	  */
	 public void setUser_id(Integer user_id) {
		 this.user_id = user_id;
	 }
	/**
	 * @return the user_name
	 */
	public String getUser_name() {
		return user_name;
	}
	/**
	 * @param user_name the user_name to set
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	/**
	 * @return the parent_task
	 */
	public String getParent_task() {
		return parent_task;
	}
	/**
	 * @param parent_task the parent_task to set
	 */
	public void setParent_task(String parent_task) {
		this.parent_task = parent_task;
	}
	/**
	 * @return the project_name
	 */
	public String getProject_name() {
		return project_name;
	}
	/**
	 * @param project_name the project_name to set
	 */
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	 
}
