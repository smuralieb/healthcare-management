package org.healthcare.enrollment.repository;

import org.healthcare.enrollment.entity.Dependent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DependentRepo extends JpaRepository<Dependent,Long>{
}
