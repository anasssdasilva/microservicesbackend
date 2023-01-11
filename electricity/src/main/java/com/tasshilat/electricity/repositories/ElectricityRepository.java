package com.tasshilat.electricity.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tasshilat.electricity.beans.CountOperation;
import com.tasshilat.electricity.beans.Electricity;

public interface ElectricityRepository extends JpaRepository<Electricity, Integer> {
	@Query(value = "SELECT * from electricity w where w.num_contrat=:numContrat and w.payed=false", nativeQuery = true)
	public List<Electricity> findFactureByContrat(@Param("numContrat") String numContrat);

	@Query(value = "SELECT count(*) as count,p.user_id as id from electricity  p group by p.user_id", nativeQuery = true)
	public List<CountOperation> countUserByOp();

	@Query(value = "SELECT count(*) as count from electricity", nativeQuery = true)
	public int countOp();

	@Query(value = "SELECT * from electricity p where p.user_id = :id  ", nativeQuery = true)
	public List<Electricity> findAllById(@Param("id") int id);
}
