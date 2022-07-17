package org.example.CourseDao;

import org.example.Entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface courseDao extends JpaRepository<Course, Long> {
}
