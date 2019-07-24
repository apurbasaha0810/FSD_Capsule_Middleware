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
			name = "callAddProject",
			query = "CALL addProject(?,?,?,?,?)",
			resultClass = Project.class),
	@NamedNativeQuery(
			name = "callGetAllProjectDetails",
			query = "CALL getAllProjectDetails(?)",
			resultClass = Project.class),
	@NamedNativeQuery(
			name = "callUpdateProjectStatus",
			query = "CALL updateProjectStatus(?,?)",
			resultClass = Project.class)
})

@Entity
@Table(name = "project_details")
public class Project {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int project_id;
	@Column
	private String project_name;
	@Column
	private Date start_date;
	@Column
	private Date end_date;
	@Column
	private int priority;
	@Column
	private int manager_id;
	private int no_of_tasks;
	private int no_of_tasks_completed;
	@Column
	private String status;
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
	 * @return the project
	 */
	public String getProject_name() {
		return project_name;
	}
	/**
	 * @param project the project to set
	 */
	public void setProject_name(String project_name) {
		this.project_name = project_name;
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
	public int getPriority() {
		return priority;
	}
	/**
	 * @param priority the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}
	/**
	 * @return the manager_id
	 */
	public int getManager_id() {
		return manager_id;
	}
	/**
	 * @param manager_id the manager_id to set
	 */
	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}
	/**
	 * @return the no_of_tasks
	 */
	public int getNo_of_tasks() {
		return no_of_tasks;
	}
	/**
	 * @param no_of_tasks the no_of_tasks to set
	 */
	public void setNo_of_tasks(int no_of_tasks) {
		this.no_of_tasks = no_of_tasks;
	}
	/**
	 * @return the no_of_tasks_completed
	 */
	public int getNo_of_tasks_completed() {
		return no_of_tasks_completed;
	}
	/**
	 * @param no_of_tasks_completed the no_of_tasks_completed to set
	 */
	public void setNo_of_tasks_completed(int no_of_tasks_completed) {
		this.no_of_tasks_completed = no_of_tasks_completed;
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
	
}
