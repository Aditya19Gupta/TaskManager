package com.adi.taskManager.repository;

import com.adi.taskManager.data.enums.TaskStatus;
import com.adi.taskManager.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Tasks, Long> {
    @Query(value = "Select t from Tasks as t where t.status =:st")
    List<Tasks> findAllByStatus(@Param("st") TaskStatus taskStatus);

    @Query(value = "Select COUNT(t) from Tasks as t where t.status =:st")
    int getTaskCountByStatus(@Param("st") TaskStatus taskStatus);

    @Query(value = "Select COUNT(t) from Tasks as t")
    int getAllTaskCount();
}
