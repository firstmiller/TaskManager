package org.example.app.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.util.Map;

@Entity
@Table(name = "task_styles")
@Getter
@Setter
public class TaskStyle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @Type(JsonType.class)
    @Column(name = "style_data", columnDefinition = "jsonb")
    private Map<String, Object> styleData;
}
