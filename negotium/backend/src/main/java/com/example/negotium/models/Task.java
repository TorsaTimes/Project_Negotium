package com.example.negotium.models;

import java.util.Date;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Getter
@Setter
@Data
// @NoArgsConstructor
@AllArgsConstructor
// @Builder
@Table(name = "TASK")
@RequiredArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // will be set when persisting

    // name of the Task
    @Column(name = "TASK_NAME", length = 50, nullable = false, unique = false)
    private String taskName;
    // description of the Task
    @Column(name = "TASK_DESCRIPTION", length = 250, nullable = true, unique = false)
    private String description;
    // List of Categorie Objects
    // @ManyToOne(targetEntity=Categorie.class, mappedBy="categorieTaskList", fetch
    // = FetchType.LAZY)
    @ManyToOne
    @JoinColumn(name = "CATEGORIE_ID", nullable = false)
    private Categorie taskCategorie;
    // @JoinColumn(name = "CATEGORIE_ID")
    // @ManyToOne(fetch = FetchType.LAZY)
    // private Categorie taskCategorie;
    // date of Task
    @Column(nullable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date taskDueDate;
    // duration of Task
    // time: Day, Week, Month, Year
    // duartion: 1 <= x <= 730

    // @Column(name = "TASK_DUARTION_ITERATION", length = 50, nullable = true,
    // unique = false)
    // // error with enum - set String to Enum!
    // private Map<String, Integer> durationDictionary;
    // status of the Task - a Task can be "Done" True or "not Done" False
    // after the due date / for the next due date status would be reset
    @Column(name = "TASK_STATUS", nullable = true, unique = false)
    private boolean taskStatus;

    // public Task(String taskName, String description, Date taskDueDate,
    // HashMap<String, Integer> durationDictionary,
    // boolean taskStatus, Categorie taskCategorie) {
    // this.taskName = taskName;
    // this.description = description;
    // this.taskDueDate = taskDueDate;
    // this.taskCategorie = taskCategorie;
    // this.durationDictionary = durationDictionary;
    // this.taskStatus = taskStatus;
    // }
    // Get Categorie Id:
    public long getCategorie_id() {
        return taskCategorie.getId();
    }

    public String getCategorie_Name() {
        return taskCategorie.getCategorieName();
    }
}
