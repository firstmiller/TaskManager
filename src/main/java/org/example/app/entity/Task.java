package org.example.app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@Setter
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String description;

    @Column(name = "created")
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "list_id")
    private TaskList taskList;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "task_style_id")
    private TaskStyle taskStyle;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "urgency_id")
    private Urgency urgency;

}