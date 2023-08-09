package com.mdesignandmimarlik.architectureblog.database.repository;

import com.mdesignandmimarlik.architectureblog.database.entity.PhotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends JpaRepository<PhotoEntity, Long> {

}
