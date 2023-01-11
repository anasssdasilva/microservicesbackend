package com.tasshilat.users.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tasshilat.users.beans.CountConnections;
import com.tasshilat.users.beans.CounterConnections;

public interface CounterRepository extends JpaRepository<CounterConnections, Integer>{

	@Query(value = "SELECT count(*) as count ,date(p.date_login) as date FROM counter_connections p group by date(p.date_login)", nativeQuery = true)
	List<CountConnections> findConnectionsByDate();
	
}
