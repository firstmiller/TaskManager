package org.example.app.repository;

import org.example.app.entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    void create(Task task);

    void update(Task task);

    Optional<Task> findById(long id);

    List<Task> getTasksByUserId(long id);
    List<Task> getTasksByListId(long id);

    boolean delete(Task task);
}
