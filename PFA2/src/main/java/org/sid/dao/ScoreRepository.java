package org.sid.dao;

import org.sid.entities.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ScoreRepository extends JpaRepository<Score, Long> {
	@Query("select sc from Score sc where sc.universite.nom=:x  ")
	public Score scoreCorrespond(@Param("x") String nomModif);
	
	@Modifying
	@Query("update Score sc set sc.scoreMath=:a,sc.scoreScience=:b,sc.scoreInfo=:c,scoreEco=:d,sc.scoreLettre=:e where sc.universite.id_universite=:f ")
	public void modifierScore(@Param("a")double scoreMathu, @Param("b") double scoreScienceu, @Param("c") double scoreInfou, @Param("d") double scoreEcou,@Param("e") double scoreLettreu,@Param("f") Long identifiantUniveru );
	
	@Modifying
	@Query("delete from Score sc  where sc.universite.id_universite=:f ")
	public void supprimerScore(@Param("f") Long identifiantUniveru );
}
