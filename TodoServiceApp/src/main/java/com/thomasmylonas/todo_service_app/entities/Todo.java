package com.thomasmylonas.todo_service_app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "Todo")
@Table(name = "Todos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Todo {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY) // Throws "ObjectOptimisticLockingFailureException" (see "Proxeiro")
    private Long id;

    @Column(name = "User_Id")
    private Long userId;

    @Column(name = "Title")
    private String title;

    @Column(name = "Completed")
    private boolean completed;
}
