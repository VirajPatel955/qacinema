package com.qa.cinema.persistence.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.cinema.persistence.domain.AssigneeDomain;

@Repository
public interface AssigneeRepo extends JpaRepository<AssigneeDomain, Long> {

}
