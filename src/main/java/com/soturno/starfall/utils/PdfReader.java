package com.soturno.starfall.utils;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Component;

@Component
public class PdfReader {

	//"C:\\Users\\rsant\\OneDrive\\Desktop\\starfall\\origem\\NFSe_03957135_01997092.pdf"
	public String extractText(String caminho) {

		try {
			// Carregue o arquivo PDF
			File arquivoPDF = new File(caminho);
			PDDocument documento = Loader.loadPDF(arquivoPDF);

			// Crie um objeto PDFTextStripper para extrair o texto
			PDFTextStripper stripper = new PDFTextStripper();

			// Extraia o texto do documento PDF
			String texto = stripper.getText(documento);

			// Exiba o texto no console
			//System.out.println(texto);
			return texto;
			// Feche o documento
			//documento.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "err";
	}
}
