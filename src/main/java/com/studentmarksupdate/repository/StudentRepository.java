package com.studentmarksupdate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.studentmarksupdate.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	@Query(value="select std_name from jb.student inner join  jb.marks on jb.student.mark_id = jb.marks.mark_id where jb.marks.total = ? ",nativeQuery=true)
	public String getStdName(int total);
	

}
