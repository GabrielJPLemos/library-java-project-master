package com.project.java.biblioteca;
import java.util.ArrayList;

public class MenuBiblioteca{

	public void menu () {
		EzMethods a = new EzMethods();
		int choice = -1;
		while (choice != 0) {
			System.out.println("-- MENU PRINCIPAL --");
			a.printForMenu("", "[ 1 ] ADMIN", "[ 2 ] USUÁRIO", "[ 0 ] SAIR", "");
			System.out.print("ESCOLHA: ");
			choice = EzMethods.menuTreatmentException();
			
			switch (choice) {
			
			case 0:
				choice = 0;
				break;
			case 1:
				// MENU ADMIN
				MenuAdmin.menuAdmin();
				break;
			case 2:
				// MENU USUÁRIO
				MenuUsuario.menuUser();
				break;
			default:
				System.out.println("OPÇÃO INVÁLIDA, TENTE NOVAMENTE.");
			}
			
}
		System.out.println("FECHANDO O SISTEMA...");
	}
}
