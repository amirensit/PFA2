package org.sid.entities;

import javax.annotation.Nullable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Score {
@Id @GeneratedValue
private Long code_score;

private double scoreMath;

private double scoreScience;

private double scoreInfo;

private double scoreEco;

private double scoreLettre;
@ManyToOne
@JoinColumn(name="code_universite")
private Universite universite;



public double getScoreMath() {
	return scoreMath;
}
public void setScoreMath(double scoreMath) {
	this.scoreMath = scoreMath;
}
public double getScoreScience() {
	return scoreScience;
}
public void setScoreScience(double scoreScience) {
	this.scoreScience = scoreScience;
}
public double getScoreInfo() {
	return scoreInfo;
}
public void setScoreInfo(double scoreInfo) {
	this.scoreInfo = scoreInfo;
}
public double getScoreEco() {
	return scoreEco;
}
public void setScoreEco(double scoreEco) {
	this.scoreEco = scoreEco;
}
public double getScoreLettre() {
	return scoreLettre;
}
public void setScoreLettre(double scoreLettre) {
	this.scoreLettre = scoreLettre;
}
public Universite getUniversite() {
	return universite;
}
public void setUniversite(Universite universite) {
	this.universite = universite;
}
public Score() {
	super();
}
public Score(double scoreMath, double scoreScience, double scoreInfo, double scoreEco, double scoreLettre,
		Universite universite) {
	super();
	this.scoreMath = scoreMath;
	this.scoreScience = scoreScience;
	this.scoreInfo = scoreInfo;
	this.scoreEco = scoreEco;
	this.scoreLettre = scoreLettre;
	this.universite = universite;
}
public Long getCode_score() {
	return code_score;
}
public void setCode_score(Long code_score) {
	this.code_score = code_score;
}




}
