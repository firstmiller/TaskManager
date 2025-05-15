package org.example.app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "urgencies")
@Getter
@Setter
public class Urgency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String color;

    @Column(name = "priority_order")
    private int priorityOrder;
}
