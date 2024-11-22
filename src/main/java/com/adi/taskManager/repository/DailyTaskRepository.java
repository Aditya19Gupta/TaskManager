package com.adi.taskManager.repository;

import com.adi.taskManager.model.DailyTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyTaskRepository extends JpaRepository<DailyTask, Long> {
}
