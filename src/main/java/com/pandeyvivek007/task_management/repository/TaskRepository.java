package com.pandeyvivek007.task_management.repository;

import com.pandeyvivek007.task_management.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
     Task findById(long id);

     @Query("SELECT e FROM Task e WHERE e.date = ?1")
     Task findTaskBeforeDate(Date date);
}
