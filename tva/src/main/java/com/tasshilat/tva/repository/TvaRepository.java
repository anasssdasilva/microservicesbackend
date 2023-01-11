package com.tasshilat.tva.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tasshilat.tva.beans.CountOperation;
import com.tasshilat.tva.beans.CountOperator;
import com.tasshilat.tva.beans.Tva;

public interface TvaRepository extends JpaRepository<Tva, Integer> {

	@Query(value = "SELECT count(*) FROM tva p WHERE p.user = :id", nativeQuery = true)
	public int getCount(@Param("id") int id);

	@Query(value = "SELECT count(*) as count,p.user as id from tva p group by p.user", nativeQuery = true)
	public List<CountOperation> countUserByOp();

	@Query(value = "SELECT count(*) as count from tva", nativeQuery = true)
	public int countOp();

	@Query(value = "SELECT count(*) as count, vehicule.name as nom from tva,vehicule  where vehicule.id=tva.vehicule_id  group by vehicule.name", nativeQuery = true)
	public List<CountOperator> countOperByOperator();
	
	@Query(value = "SELECT * from tva p where p.user = :id  ", nativeQuery = true)
	public List<Tva> findAllById(@Param("id") int id);

}
