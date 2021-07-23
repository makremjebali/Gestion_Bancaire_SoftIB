package tn.esprit.spring.controllers;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.Services.CompteService;
import tn.esprit.spring.Services.IStatistiquesService;

@RestController
@RequestMapping("/api/auth")
public class StatistiquesController {
	
	@Autowired
	IStatistiquesService iStatistiquesService;
	
	private static final Logger l = LogManager.getLogger(CompteService.class);
	
	@GetMapping("/GetNumerosComptePlusGrandSoldeASC")
	@ResponseBody
	public List<String> GetNumerosComptePlusGrandSoldeASC()
	{
		return (List<String>)iStatistiquesService.GetNumerosComptePlusGrandSoldeASC();
	}

	@GetMapping("/GetNumerosComptePlusPetitSoldeASC")
	@ResponseBody
	public List<String> GetNumerosComptePlusPetitSoldeASC()
	{
		return (List<String>)iStatistiquesService.GetNumerosComptePlusPetitSoldeASC();
	}

	@GetMapping("/GetMoyenneDesSalaires")
	@ResponseBody
	public double GetMoyenneDesSalaires()
	{
		return iStatistiquesService.GetMoyenneDesSalaires();
	}








}
