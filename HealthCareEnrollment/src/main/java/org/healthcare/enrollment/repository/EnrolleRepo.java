package org.healthcare.enrollment.repository;

import org.healthcare.enrollment.entity.Enrolle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrolleRepo extends JpaRepository<Enrolle, Long>{

}
