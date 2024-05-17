package com.mspr_kawa.clients.main.repository;

import com.mspr_kawa.clients.main.model.Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DetailsRepository extends JpaRepository<Details,UUID> {
}
