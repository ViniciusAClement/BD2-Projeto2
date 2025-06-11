package main.models.services;

import java.util.List;
import java.util.Scanner;

import main.models.dao.UbsDao;
import main.models.entities.EnderecoUbs;

public class Programa {
	public static void iniciarPrograma() {
		System.out.println("---------------------------");
		System.out.println("|                         |");
		System.out.println("|    Unidades Básicas     |");
		System.out.println("|       de Saúde          |");
		System.out.println("|                         |");
		System.out.println("---------------------------");
		System.out.println("|1-Unidades Mais Proximas |");
		System.out.println("|2-Unidades da CIdade     |");
		System.out.println("---------------------------");
		
		Scanner sc = new Scanner(System.in);
		int escolha = sc.nextInt();
		
		switch(escolha) {
		case 1:
			unidadesProximas();
			break;
		case 2:
			unidadesDaCidade();
			break;
		default:
			System.out.println("Escolheu errado");
			break;
		}
		
	}
	public static void unidadesProximas() {
		List<String> bairros = UbsDao.bairrosQueTemUbs();
		int numero = 1;
		for(String bairro : bairros) {
			System.out.println(numero+"-"+bairro);
			numero++;
			System.out.println("---------------------------");
		}
		Scanner sc = new Scanner(System.in);
		int escolha = sc.nextInt();
		List<EnderecoUbs> ubsDoBairro = UbsDao.ubsPorBairro(bairros.get(escolha-1));
		for(EnderecoUbs ubs : ubsDoBairro) {
			System.out.println(ubs);
		}
		iniciarPrograma();
	}
	public static void unidadesDaCidade() {
		List<EnderecoUbs> ubsDaCidade = UbsDao.ubsPorCidade(UserServices.codigoIbgeDaCidade());
		int numero = 1;
		for(EnderecoUbs ubs: ubsDaCidade) {
			System.out.println(numero+"-"+ubs);
			numero++;
			
		}
		iniciarPrograma();
	}
}
