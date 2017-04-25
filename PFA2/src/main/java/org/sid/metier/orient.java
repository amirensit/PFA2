package org.sid.metier;

import org.sid.dao.ScoreRepository;
import org.sid.dao.UniversiteRepository;
import org.sid.entities.Score;
import org.sid.entities.Universite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service // instancier la classe au début et utilisé pour les objets metier
@Transactional
public class orient implements IOrient {
	@Autowired
	UniversiteRepository universityRepository;
	@Autowired 
	ScoreRepository scoreRepository;
	
@Override
public void ajouterUniversite(String nom, String region, double scoreMath, double scoreScience, double scoreInfo,
		double scoreLettre, double scoreEco) {
	
	Universite u=new Universite(nom,region);
	universityRepository.save(u);
	scoreRepository.save(new Score(scoreMath, scoreScience, scoreInfo, scoreEco, scoreLettre, u));
	
}


@Override
public Score scoreCorrespond(String nomModif) {
	
	
	
	Score score=scoreRepository.scoreCorrespond(nomModif);
	
	return score;
	
}

@Override
public Long identiteUniver(String nomModif) {
	Long r=universityRepository.identieUniver(nomModif);
	return r;
}


@Override
public void modifierScore(double scoreMathu, double scoreScienceu, double scoreInfou, double scoreEcou,
		double scoreLettreu, Long identifiantUniveru) {
	
	scoreRepository.modifierScore(scoreMathu, scoreScienceu, scoreInfou, scoreEcou, scoreLettreu, identifiantUniveru); 
	
}

@Override
public void supprimerScore(Long identifiantUniveru) {
	scoreRepository.supprimerScore(identifiantUniveru);
	
}

@Override
public void supprimerUniversite(String nomSupp) {
	universityRepository.supprimerUniversite(nomSupp);
	
}


}
