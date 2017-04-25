package org.sid.web;




import javax.validation.constraints.Null;

import org.sid.entities.Admin;
import org.sid.entities.Score;
import org.sid.entities.Universite;
import org.sid.metier.IOrient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
 public class BanqueController {
	@Autowired
	private IOrient or;
	
	
	
	
	
	 @InitBinder
	    public void initBinder(WebDataBinder binder) {
	        
		 binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));  
		
	 
	    }
	
	@RequestMapping("/operations")
	public String index()
	{
		return "comptes";
	}
	
	
	
	
	
	@RequestMapping("/authentifier")	
	public String authentifier()
	{
		
	return "authentifier";
	
	}
	
	@RequestMapping("/pageAdmin")
	public String pageAdmin(Model model, String uname,String psw)
	
	{
		if  ( uname.equals("admin") && psw.equals("admin") ) return "admin";
		else
			{
			model.addAttribute("exception","vérifier les paramètres !!");
			return "authentifier";
			}
				
				
		
	}
	
	@RequestMapping(value="/ajouterUniversite",method=RequestMethod.POST)
	public String ajoutUniver(Model model,String nom,String region,String scoreMath,String scoreScience,String scoreEco,String scoreInfo,String scoreLettre )
	{
		
		model.addAttribute("ok","cv");
		Universite u=new Universite(nom,region);
		or.ajouterUniversite(nom, region,(scoreMath==null)? 1000: Double.parseDouble(scoreMath),(scoreScience==null)? 1000: Double.parseDouble(scoreScience),(scoreInfo==null)? 1000: Double.parseDouble(scoreInfo),(scoreLettre==null)? 1000: Double.parseDouble(scoreLettre),(scoreEco==null)? 1000: Double.parseDouble(scoreEco));
		return "admin";
		
	}

	
	@RequestMapping(value="/modifierUniversite",params="visualiser")
	public String modiferUniver(Model model,String nomModif)
	{
		model.addAttribute("nomU",nomModif);
		
	

		Score score=or.scoreCorrespond(nomModif);
		
		
		model.addAttribute("scoreU",score);

		
			
		return "admin";
		
	}
	
	@RequestMapping(value="/modifierUniversite",params="valider")
	public String validerModif(Model model,String nomModif,String scoreMathModif,String scoreScienceModif,String scoreInfoModif,String scoreLettreModif,String scoreEcoModif)
	{
		Long r= or.identiteUniver(nomModif);
		or.modifierScore(Double.parseDouble(scoreMathModif), Double.parseDouble(scoreScienceModif), Double.parseDouble(scoreInfoModif), Double.parseDouble(scoreEcoModif), Double.parseDouble( scoreLettreModif ), r);
		model.addAttribute("modificationTermine","modification terminé !!!");
		return "admin";
	}
	
	
	@RequestMapping(value="/supprimerUniversite")
	public String supprimer(Model model,String nomSupp)
	{
		Long r= or.identiteUniver(nomSupp);
		or.supprimerScore( r);
		or.supprimerUniversite(nomSupp);
		model.addAttribute("SuppressionTermine","suppression terminé !!!");
		return "admin";
	}
	
	@RequestMapping("/deconnecter")
	public String deconnecter()
	{
		return "comptes";
	}
	
	
	
	@RequestMapping("/calculScoreForm")
	public String calculerScoreMath(Model model, String sectionCalculScore,String mathCalcul,String physiqueCalcul,String scienceCalcul,String françaisCalcul,String anglaisCalcul,String arabeCalcul,String phyloCalcul)
	{
		Long score=(long) 0;
		if(mathCalcul==null ||mathCalcul==null ||mathCalcul==null ||mathCalcul==null ||mathCalcul==null ||mathCalcul==null ||mathCalcul==null )
			model.addAttribute("scoreErreur","oups,vous devez remplir tous les champs !");
		
		else
		{
			if(sectionCalculScore.equals("math"))
				score=(long) 1;
			model.addAttribute("calculScoreTermine","votre score est : "+score);
			
		}
		return "comptes";
	}
	

	
}
