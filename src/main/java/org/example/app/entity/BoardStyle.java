package org.example.app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Map;

@Entity
@Table(name = "board_styles")
@Getter
@Setter
public class BoardStyle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "style_data", columnDefinition = "jsonb")
    private Map<String, Object> styleData;
}
