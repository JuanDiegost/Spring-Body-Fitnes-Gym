package com.bodyFitnessGym.reports;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.expression.ParseException;

import com.bodyFitnessGym.model.entity.Alumno;
import com.bodyFitnessGym.model.entity.ProgresoImagen;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class Reports {

	private static final String PDF_REPORTS_DIR = "/src/main/java/com/bodyfitnessGym/reports/";
	private static final String REPORT_TEMPLATE_FILENAME = PDF_REPORTS_DIR + "progresos.jrxml";

	/**
	 * Retorna un PDF con los progresos del alumno, el alumno debe tener una lista de progresos.
	 * @param alumno El alumno al que se le quiere generar sus progresos
	 * @return PDF en un vector de bytes
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 * @throws JRException
	 */
	public static byte[] generarProgresosPDF(Alumno alumno)
			throws ClassNotFoundException, IOException, ParseException, JRException {
		JasperReport jasperReport = JasperCompileManager.compileReport(new File(".").getCanonicalPath()+REPORT_TEMPLATE_FILENAME);
		Map<String, Object> parameters = new HashMap<String, Object>();
		List<ProgresoImagen> imagens = alumno.getHistorialProgresoImagen();
		Collections.sort(imagens, new Comparator<ProgresoImagen>() {
			public int compare(ProgresoImagen o1, ProgresoImagen o2) {
				return o1.getFechaProgresoImagen().compareTo(o2.getFechaProgresoImagen());
			}
		});

		parameters.put("NOMBRE", alumno.getNombreAlumno());
		parameters.put("urlImgUser", alumno.getUrlImagenUsuario());
		parameters.put("CHART_DATASET", new JRBeanCollectionDataSource(imagens));
		parameters.put("CHART_DATASET_GRASA", new JRBeanCollectionDataSource(imagens));
		parameters.put("urlFirtsIMG", imagens.get(0).getUrl());
		parameters.put("urlSecondIMG", imagens.get(imagens.size()-1).getUrl());
		JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
		// Make sure the output directory exists
		String outFilePath =new File(".").getCanonicalPath()+ PDF_REPORTS_DIR + "Reporte-" + alumno.getDniAlumno() + ".pdf";// REPORTS_DIR

		// +persona.getDNI()+persona.getPrimerApellido()+"_"+persona.getPrimerNombre()+"_Carnet.pdf";
		JasperExportManager.exportReportToPdfFile(print, outFilePath);
		return getPDFAsByte(outFilePath);
	}

	public static byte[] getPDFAsByte(String filePath) throws IOException {
		Path pdfPath = Paths.get(filePath);
		return Files.readAllBytes(pdfPath);
	}
	
}