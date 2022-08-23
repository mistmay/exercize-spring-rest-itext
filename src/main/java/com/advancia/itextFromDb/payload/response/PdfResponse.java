package com.advancia.itextFromDb.payload.response;

public class PdfResponse {
	private String pdf;
	
	public PdfResponse() {}
	
	public PdfResponse(String pdf) {
		this.pdf = pdf;
	}
	
	public String getPdf() {
		return pdf;
	}

	public void setPdf(String pdf) {
		this.pdf = pdf;
	}
}
