package com.project.java.biblioteca;
import java.util.Scanner;
import java.util.ArrayList;

public class MenuAdmin {	
			
	public static int loginCheck () {
		Scanner sc = new Scanner(System.in);
		
		String[] loginList = {"admin", "123"};
				
		while (true) {
		
			System.out.println("PARA RETORNAR AO MENU PRINCIPAL, DIGITE [ 0 ] NO LOGIN");
			System.out.print("LOGIN ADMINISTRADOR: ");			
			String login = sc.next();
			
			if (login.equals("0")) {
				new MenuBiblioteca().menu();
				return 0;
			}
					
			System.out.print("SENHA: ");
			String password = sc.next();
			
			

			if (login.equals(loginList[0]) && password.equals(loginList[1])) {
				return 1;
			}
			else {
				System.out.println("LOGIN OU SENHA INCORRETOS");
				return 0;
			}	
		}
	}
	

	
		
	public static void menuAdmin () {		
		Scanner sc = new Scanner(System.in);
		EzMethods p = new EzMethods();
		int choice = -1;
		int ok = 0;
		while (choice != 0) { 
			while (ok != 1) {
				ok = MenuAdmin.loginCheck();
			}
					
			p.printForMenu("[ 1 ] CRIAR LIVRO", "[ 2 ] EDITAR LIVRO", "[ 3 ] LER INFORMAÇÃO DO LIVRO SELECIONADO",
					"[ 4 ] DELETAR LIVRO", "[ 0 ] VOLTAR AO MENU PRINCIPAL", "");
			System.out.print("ESCOLHA: ");
			
			choice = EzMethods.menuTreatmentException();
			switch (choice) {
			case 0:
				choice = 0;
				break;
			case 1:
				System.out.print("NOME DO NOVO LIVRO: ");
				String bookName = sc.nextLine();
				System.out.print("NOME DO AUTOR: ");
				String bookAuthorName = sc.nextLine();
				System.out.print("DATA DE LANÇAMENTO: ");
				String bookReleaseDate = sc.nextLine();
				p.bookList(choice, bookName, bookAuthorName, bookReleaseDate);		
				p.seeBooks();
				break;
			case 2:
				p.seeBooks();	
				int index = -2;
				
				System.out.print("ESCOLHA O INDEX PARA EDIÇÃO: ");
				index = EzMethods.menuTreatmentException();
				
				while (index != -1) {
										
					
					if (index > EzMethods.book.size() - 1 || index < 0) {
						System.out.println("INDEX FORA DO LIMITE");
						index = -1;
					}
					else {
						int choice1;
						System.out.println("0 - NOME: " + EzMethods.book.get(index));
						System.out.println("1 - AUTOR: " + EzMethods.bookAuthor.get(index));
						System.out.println("2 - DATA DE LANÇAMENTO: " + EzMethods.bookReleaseDate.get(index));
						System.out.print("ESCOLHA: ");
						choice1 = EzMethods.menuTreatmentException();
						sc.nextLine();
						switch (choice1) {
						case 0:
							
							System.out.print("NOVO NOME: ");
							String bookNewName = sc.nextLine();
							EzMethods.book.remove(index);
							EzMethods.book.add(index, bookNewName);
							System.out.println("DADO ATUALIZADO");
						
							break;
						case 1:
							System.out.print("NOVO AUTOR: ");
							String bookNewAuthor = sc.nextLine();
							EzMethods.bookAuthor.remove(index);
							EzMethods.bookAuthor.add(index, bookNewAuthor);
							System.out.println("DADO ATUALIZADO");
					
							break;
						case 2:
							System.out.print("NOVA DATA DE LANÇAMENTO: ");
							String bookNewReleaseDate = sc.nextLine();
							System.out.println("INFORME");
							EzMethods.bookReleaseDate.remove(index);
							EzMethods.bookReleaseDate.add(index, bookNewReleaseDate);
							System.out.println("DADO ATUALIZADO");
						
							break;
						default:
							System.out.println("OPÇÃO INVÁLIDA");
						}
						break;
					}
				} 
				break;
				
			case 3:
				p.seeBooks();
				int index1 = -2;
				while (index1 != -1) {
					System.out.print("DIGITE O INDEX PARA VER AS INFORMAÇÕES DO LIVRO: ");
					index1 = EzMethods.menuTreatmentException();		
					if (index1 > EzMethods.book.size() - 1 || index1 < 0) {
						System.out.println("INDEX FORA DO LIMITE");
						index1 = -1;
					}
					else {
						System.out.println("0 - NOME: " + EzMethods.book.get(index1));
						System.out.println("1 - AUTOR: " + EzMethods.bookAuthor.get(index1));
						System.out.println("2 - DATA DE LANÇAMENTO: " + EzMethods.bookReleaseDate.get(index1));
						System.out.println();
						index1 = -1;
					}
				}	
				break;
			case 4:
				p.seeBooks();
				System.out.print("\nDIGITE O INDEX PARA REMOÇÃO: ");
				int indexDel = EzMethods.menuTreatmentException();
				try {
					EzMethods.book.remove(indexDel);
					EzMethods.bookAuthor.remove(indexDel);
					EzMethods.bookReleaseDate.remove(indexDel);
				} 
				catch (IndexOutOfBoundsException e) {
					System.out.println("ERRO! INDEX INEXISTENTE.");
				}
				
				break;
			default:
				System.out.println("OPÇÃO INVÁLIDA, TENTE NOVAMENTE.");
			}			
		}
	}
}
