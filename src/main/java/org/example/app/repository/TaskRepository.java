package org.example.app.repository;

import org.example.app.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> getTasksByTaskList_Id(long taskListId);

    List<Task> findByTaskList_Board_User_Id(long userId);

}
