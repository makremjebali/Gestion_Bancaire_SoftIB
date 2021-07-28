package tn.esprit.spring.controllers;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.Services.CompteService;
import tn.esprit.spring.Services.IStatistiquesService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class StatistiquesController {
	
	@Autowired
	IStatistiquesService iStatistiquesService;
	
	private static final Logger l = LogManager.getLogger(CompteService.class);
	
	@GetMapping("/GetNumerosComptePlusGrandSoldeASC")
	@ResponseBody
	@PreAuthorize("hasRole('ADMIN')")
	public List<String> GetNumerosComptePlusGrandSoldeASC()
	{
		return (List<String>)iStatistiquesService.GetNumerosComptePlusGrandSoldeASC();
	}

	@GetMapping("/GetNumerosComptePlusPetitSoldeASC")
	@ResponseBody
	@PreAuthorize("hasRole('ADMIN')")
	public List<String> GetNumerosComptePlusPetitSoldeASC()
	{
		return (List<String>)iStatistiquesService.GetNumerosComptePlusPetitSoldeASC();
	}

	@GetMapping("/GetMoyenneDesSalaires")
	@ResponseBody
	@PreAuthorize("hasRole('ADMIN')")
	public double GetMoyenneDesSalaires()
	{
		return iStatistiquesService.GetMoyenneDesSalaires();
	}

	@GetMapping("/GetNombreDecompteParType")
	@ResponseBody
	@PreAuthorize("hasRole('ADMIN')")
	public List<String> GetNombreDecompteParType() {
		return iStatistiquesService.GetNombreDecompteParType();
	}
	@GetMapping("/GetSommeDesCrédits")
	@ResponseBody
	@PreAuthorize("hasRole('ADMIN')")
	public Float GetSommeDesCrédits() {
		return iStatistiquesService.GetSommeDesCrédits();
	}
	@GetMapping("/CalculeTMM")
	@ResponseBody
	//@PreAuthorize("hasRole('ADMIN')")
	public String CalculeTMM() {
		return iStatistiquesService.CalculeTMM();
	}








}
