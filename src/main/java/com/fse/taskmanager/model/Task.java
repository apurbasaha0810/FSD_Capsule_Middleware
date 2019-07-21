package com.fse.taskmanager.model;

import java.text.ParseException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import javax.validation.constraints.Null;

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
                name = "callInsertSpecificTask",
                query = "CALL insertSpecificTask(?,?,?,?,?)",
                resultClass = Task.class)
})

@Entity
@Table(name = "task")

public class Task {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int task_id;
    @Column
    @Null
    private Integer parent_id;
    @Column
    private String task;
    @Column
    private Date start_date;
    @Column
    private Date end_date;

    public String getParent_task() {
        return parent_task;
    }

    public void setParent_task(String parent_task) {
        this.parent_task = parent_task;
    }

    @Column

    private String priority;
    @Column
    @Null
    private String parent_task;

    @Column
    private String finished;

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Date getStart_date() throws ParseException {
        java.sql.Date sqlDate = new java.sql.Date(start_date.getTime());
        return  sqlDate;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        java.sql.Date sqlDate = new java.sql.Date(end_date.getTime());
        return sqlDate;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getFinished() {
        return finished;
    }

    public void setFinished(String finished) {
        this.finished = finished;
    }

}