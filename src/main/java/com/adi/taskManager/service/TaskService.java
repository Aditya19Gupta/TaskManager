package com.adi.taskManager.service;

import com.adi.taskManager.data.enums.TaskStatus;
import com.adi.taskManager.model.Tasks;
import com.adi.taskManager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Tasks> getAllTaskByStatus(TaskStatus taskStatus) {
        return taskRepository.findAllByStatus(taskStatus);
    }

    public int getTaskCount(TaskStatus taskStatus) {
        return taskRepository.getTaskCountByStatus(taskStatus);
    }

    public int getAllTaskCount() {
        return taskRepository.getAllTaskCount();
    }
}
