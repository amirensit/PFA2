package org.sid.dao;

import org.sid.entities.Score;
import org.sid.entities.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UniversiteRepository extends JpaRepository<Universite, Long> {

	
	@Query("select id_universite from Universite u where u.nom=:x")
	public Long identieUniver(@Param("x")String nomModif);
	
	
	@Modifying
	@Query("delete from Universite u  where u.nom=:f ")
	public void supprimerUniversite(@Param("f") String nomSupp );
	
		
	
}
