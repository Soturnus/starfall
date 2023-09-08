package com.soturno.starfall.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soturno.starfall.utils.PdfReader;

@Service
public class StarfallService {

	@Autowired
	PdfReader pdf;
	
	
	public String getText() {
		
		String texto = pdf.extractText("C:\\Users\\rsant\\OneDrive\\Desktop\\starfall\\origem\\barueri_nfse.pdf");
		
		
		
		String cnpj = getCNPJ(texto);
		
		return cnpj;
	}
	
	public String getCNPJ(String texto) {

	        // Padronize a expressão regular para CPF ou CNPJ
	        String padrao = "\\b\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}\\b|\\b\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}\\b";

	        // Compile o padrão
	        Pattern pattern = Pattern.compile(padrao);

	        // Crie um Matcher para encontrar correspondências
	        Matcher matcher = pattern.matcher(texto);
	        String cpfCnpj = null;
	        // Encontre e imprima todas as correspondências
	        while (matcher.find()) {
	            cpfCnpj = matcher.group();
	            System.out.println("CPF/CNPJ encontrado: " + cpfCnpj);
	        }
			return cpfCnpj;
		
	}
}
