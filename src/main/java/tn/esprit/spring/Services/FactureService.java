package tn.esprit.spring.Services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Facture;
import tn.esprit.spring.repository.factureRepository;

@Service
public class FactureService implements IFactureService {
@Autowired
factureRepository facturerep;

@Override
public ResponseEntity<Object> GetFactureById(Long id) {
	Facture f = facturerep.findById(id).get();
	List<Facture> facture = new ArrayList<>();
	facture.add(f);
	StringBuilder file = new StringBuilder("num_facture,date_facture,client");
	for (Facture fact:facture)
	{
		file.append(f.getNum_Facture()).append(",").append(f.getDate_facture())
		.append(",").append(f.getClient().getNom_client()).append("\n");
	}
	String filename="C:\\Users\\asus\\Documents\\workspace-sts-3.8.4.RELEASE\\facture.txt";
	try {
		FileWriter fileWriter=new FileWriter(filename);
		fileWriter.write(file.toString());
		fileWriter.flush();
		File filee = new File(filename);
		InputStreamResource resource = new InputStreamResource(new FileInputStream(filee));
		HttpHeaders headers =new HttpHeaders();
		headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", filee.getName()));
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		ResponseEntity<Object> responseEntity = ResponseEntity.ok().headers(headers).contentLength(filee.length()).contentType(MediaType.parseMediaType("application/txt")).body(resource);
		return responseEntity;
	} catch (IOException e) {
		return new ResponseEntity<>("error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
	
}
