package model.services;

import java.time.Duration;

import vehicle.CarRental;
import vehicle.Invoice;

public class RentalService {

	private Double pricePerDay;
	private Double pricePerHour;
	
	private TaxService taxService;

	public RentalService(Double pricePerDay, Double pricePerHour, TaxService taxService) {
		super();
		this.pricePerDay = pricePerDay;
		this.pricePerHour = pricePerHour;
		this.taxService = taxService;
	}
	
	public void processInvoice (CarRental carRental) {
		
		double minutes  = Duration.between(carRental.getStart(),carRental.getFinish()).toMinutes();
		double hours = minutes /60.0;
		
		double basicPaymant;
		
		if (hours <=12.0) {
			basicPaymant = pricePerHour * Math.ceil(hours);
		}else {
			basicPaymant = pricePerDay * Math.ceil(hours /24.0);
		}
			
		double tax = taxService.tax(basicPaymant);
		
		carRental.setInvoice(new Invoice(basicPaymant, tax));
	}
}
