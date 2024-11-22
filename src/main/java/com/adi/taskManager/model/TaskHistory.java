package com.adi.taskManager.model;

import com.adi.taskManager.data.enums.TaskStatus;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Data
@Getter
@Setter
@ToString
@Entity
@Table(name="task_history")
public class TaskHistory {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    Long id;

    @Column(name = "title")
    private String title;

    @ManyToOne(fetch= FetchType.EAGER, optional = true)
    @JoinColumn(name = "task_id",nullable = true)
    private Tasks tasks;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private TaskStatus status;

}
