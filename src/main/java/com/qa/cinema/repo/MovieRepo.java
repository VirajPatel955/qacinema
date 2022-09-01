package com.qa.cinema.repo;

import com.qa.cinema.domain.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepo extends JpaRepository<Listing, Long> {
}
