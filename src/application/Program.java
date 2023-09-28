package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.services.BrasilTaxService;
import model.services.RentalService;
import vehicle.CarRental;
import vehicle.Vehicle;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm"); 
		
		System.out.println("Entre com os dados do aluguel!");
		System.out.print("Modelo do carro: ");
		String carModel = sc.nextLine();
		System.out.print("Entre com os dados da placa: ");
		String carPlate = sc.nextLine();
		System.out.print("Qual a cor do carro: ");
		String carColor = sc.nextLine();
		System.out.print("Hora da retirada (dd/MM/yyyy hh:mm): ");
		LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
		System.out.print("Hora da devolucao (dd/MM/yyyy hh:mm): ");
		LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);
			
		
		CarRental cr = new CarRental(start, finish, new Vehicle (carModel, carColor, carPlate));
		System.out.println();
		System.out.print("Entre com o preço por hora: ");
		double pricePerHour = sc.nextDouble();
		System.out.print("Entre com o preço por dia: ");
		double pricePerDay = sc.nextDouble();
		
		RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrasilTaxService());
		rentalService.processInvoice(cr);
		System.out.println();
		System.out.println("!!!!!Fatura!!!!!!!!");
		System.out.println();
		System.out.println("Pagamento Basico: " + cr.getInvoice().getBasicPayment());
		System.out.println("Imposto " + cr.getInvoice().getTax());
		System.out.println("Pagamento Total: " + cr.getInvoice().getTotalPayment());
		
		sc.close();
	}

}
