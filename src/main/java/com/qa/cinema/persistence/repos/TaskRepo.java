package com.qa.cinema.persistence.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.cinema.persistence.domain.TaskDomain;

@Repository
public interface TaskRepo extends JpaRepository<TaskDomain, Long> {

}
