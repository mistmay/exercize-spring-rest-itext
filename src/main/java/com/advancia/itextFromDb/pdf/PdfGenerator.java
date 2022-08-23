package com.advancia.itextFromDb.pdf;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.advancia.itextFromDb.model.Employee;
import com.advancia.itextFromDb.repository.EmployeeRepository;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.VerticalAlignment;

public class PdfGenerator {
	
	public static String generatePdf(List<Employee> employees) {
		try {
			String userDirectory = System.getProperty("user.home") + File.separator + "Downloads";
			PdfWriter writer = new PdfWriter(userDirectory + File.separator + "table.pdf");
			PdfDocument pdf = new PdfDocument(writer);
			Document document = new Document(pdf);
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			String format = formatter.format(date);
			float col = 280f;
			float[] pointColumnWidths = { col, col };
			Table header = new Table(pointColumnWidths);
			header.setBackgroundColor(new DeviceRgb(63, 169, 219));
			header.setFontColor(new DeviceRgb(255, 255, 255));
			header.addCell(new Cell().add(new Paragraph("Employees List")).setTextAlignment(TextAlignment.LEFT)
					.setVerticalAlignment(VerticalAlignment.TOP).setPaddingTop(30f).setPaddingBottom(30f)
					.setPaddingLeft(20f).setFontSize(25f).setBorder(Border.NO_BORDER));
			header.addCell(new Cell().add(new Paragraph("Generated\n" + format)).setTextAlignment(TextAlignment.RIGHT)
					.setPaddingTop(30f).setPaddingBottom(30f).setPaddingRight(20f).setBorder(Border.NO_BORDER));
			float[] tablecol = { 185, 185, 185 };
			Table table = new Table(tablecol);
			table.setMarginTop(30f);
			table.addCell(new Cell().add(new Paragraph("Name")).setBackgroundColor(new DeviceRgb(63, 169, 219))
					.setFontColor(new DeviceRgb(255, 255, 255)));
			table.addCell(new Cell().add(new Paragraph("Surname")).setBackgroundColor(new DeviceRgb(63, 169, 219))
					.setFontColor(new DeviceRgb(255, 255, 255)));
			table.addCell(new Cell().add(new Paragraph("Age")).setBackgroundColor(new DeviceRgb(63, 169, 219))
					.setFontColor(new DeviceRgb(255, 255, 255)));
			for (Employee employee : employees) {
				table.addCell(new Cell().add(new Paragraph(employee.getName())));
				table.addCell(new Cell().add(new Paragraph(employee.getSurname())));
				table.addCell(new Cell().add(new Paragraph("" + employee.getAge())));
			}
			document.add(header);
			document.add(table);
			document.close();
			byte[] input_file = Files.readAllBytes(Paths.get(userDirectory + File.separator + "table.pdf"));
	        byte[] encodedBytes = Base64.getEncoder().encode(input_file);
	        String encodedString =  new String(encodedBytes);
	        new File(userDirectory + File.separator + "table.pdf").delete();
	        return encodedString;
		} catch (Exception e) {
			return null;
		}
	}
}
