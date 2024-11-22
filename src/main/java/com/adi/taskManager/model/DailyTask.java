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
@Table(name="daily_task")
public class DailyTask {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private TaskStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "overall_task_status")
    private TaskStatus overallStatus;
}
