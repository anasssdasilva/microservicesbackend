package com.tasshilat.billetAvion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tasshilat.billetAvion.beans.CountOperation;
import com.tasshilat.billetAvion.beans.CountCity;
import com.tasshilat.billetAvion.beans.BilletAvion;

public interface BilletAvionRepository extends JpaRepository<BilletAvion, Integer> {

	@Query(value = "SELECT count(*) FROM billet_avion p WHERE p.user = :id", nativeQuery = true)
	public int getCount(@Param("id") int id);

	@Query(value = "SELECT count(*) as count,p.user as id from billet_avion p group by p.user", nativeQuery = true)
	public List<CountOperation> countUserByOp();

	@Query(value = "SELECT count(*) as count from billet_avion", nativeQuery = true)
	public int countOp();

	@Query(value = "SELECT count(*) as count, city.name as nom from billet_avion,city  where city.id=billet_avion.city_id  group by city.name", nativeQuery = true)
	public List<CountCity> countOperByCity();
	
	@Query(value = "SELECT * from billet_avion p where p.user = :id  ", nativeQuery = true)
	public List<BilletAvion> findAllById(@Param("id") int id);

}
