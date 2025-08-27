package org.example.app.mapper;

import org.example.app.dto.TaskDTO;
import org.example.app.entity.Task;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDTO toDTO(Task task);

    List<TaskDTO> toListDto(List<Task> tasks);
}
