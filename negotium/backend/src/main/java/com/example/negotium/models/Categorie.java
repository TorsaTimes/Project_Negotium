package com.example.negotium.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.FetchType;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
// @Builder
@Table(name = "CATEGORIE")
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // will be set when persisting

    // name of the Task
    @Column(name = "CATEGORIE_NAME", length = 50, nullable = false, unique = false)
    private String categorieName;
    // description of the Task
    @Column(name = "CATEGORIE_DESCRIPTION", length = 250, nullable = true, unique = false)
    private String categorieDescription;
    // List of Categorie Objects
    //@OneToMany(mappedBy = "taskCategorie", cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToMany(mappedBy = "taskCategorie",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Task> categorieTaskList;
    //@ElementCollection
    //private List<Task> categorieTaskList = new ArrayList<Task>();
    // status of the Task - a Task can be "Done" True or "not Done" False
    // after the due date / for the next due date status would be reset
    @Column(name = "CATEGORIE_STATUS", nullable = false, unique = false)
    private boolean categorieStatus;
    // timestamp counter - measure cleaning time
    @Column(name = "CATEGORIE_COUNTER", length = 250, nullable = true, unique = false)
    private long categorieCounter;

    // public Task(String taskName, String description, Date taskDueDate,
    // HashMap<reiterationKeys, Integer> durationDictionary,
    // boolean taskStatus, Categorie taskCategorie) {
    // this.taskName = taskName;
    // this.description = description;
    // this.taskDueDate = taskDueDate;
    // this.taskCategorie = taskCategorie;
    // this.durationDictionary = durationDictionary;
    // this.taskStatus = taskStatus;
    // }
}
