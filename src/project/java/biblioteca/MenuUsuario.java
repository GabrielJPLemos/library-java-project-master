package com.project.java.biblioteca;

import java.util.Scanner;

public class MenuUsuario {
	
	public static int userLoginCheck () {
		Scanner sc = new Scanner(System.in);
		EzMethods p = new EzMethods();
		int choice = -1;
		int userNumb = 0;
		
		while(choice !=0) {
	
				p.printForMenu("[ 1 ] USUÁRIO 1", "[ 2 ] USUÁRIO 2", "[ 3 ] USUÁRIO 3","[ 0 ] SAIR");
				System.out.print("ESCOLHA: ");				
				choice = EzMethods.menuTreatmentException();
				switch(choice) {
				case 0:
					userNumb = -1;
					break;
				case 1:
					userNumb = 1;
					choice = 0;
					break;
				case 2:	
					userNumb = 2;
					choice = 0;
					break;
				case 3: 
					userNumb = 3;
					choice = 0;
					break;
				default:
				System.out.println("OPÇÃO INVÁLIDA.");
			}
		} return userNumb;
	}

	public static void menuUser () {
		Scanner sc = new Scanner(System.in);
		EzMethods p = new EzMethods();
		int choice = -1;
		int user = userLoginCheck();
			while(choice !=0 && user > 0) {
				System.out.println("USUARIO: "+user);
				p.printForMenu("[ 1 ] ALUGAR LIVRO", "[ 2 ] VER LIVROS DISPONÍVEIS", "[ 0 ] SAIR");
				System.out.print("ESCOLHA: ");				
				choice = EzMethods.menuTreatmentException();
				switch(choice) {
				case 0:
					choice = 0;
					break;
				case 1:
					System.out.print("\nDIGITE O INDEX PARA ALUGAR: ");
					int indexDel = EzMethods.menuTreatmentException();
					try {
						
						if(user ==1 && EzMethods.user1.size()==0) {
						EzMethods.user1.add(EzMethods.book.get(indexDel));
						EzMethods.user1.add(EzMethods.bookAuthor.get(indexDel));
						EzMethods.user1.add(EzMethods.bookReleaseDate.get(indexDel));
						
						EzMethods.book.remove(indexDel);
						EzMethods.bookAuthor.remove(indexDel);
						EzMethods.bookReleaseDate.remove(indexDel);
						
						}
						
						
						else if(user ==2 && EzMethods.user2.size()==0) {
							EzMethods.user2.add(EzMethods.book.get(indexDel));
							EzMethods.user2.add(EzMethods.bookAuthor.get(indexDel));
							EzMethods.user2.add(EzMethods.bookReleaseDate.get(indexDel));
							
							EzMethods.book.remove(indexDel);
							EzMethods.bookAuthor.remove(indexDel);
							EzMethods.bookReleaseDate.remove(indexDel);
							
							}
							
						
						else if(user ==3 && EzMethods.user3.size()==0) {
							EzMethods.user3.add(EzMethods.book.get(indexDel));
							EzMethods.user3.add(EzMethods.bookAuthor.get(indexDel));
							EzMethods.user3.add(EzMethods.bookReleaseDate.get(indexDel));
							
							EzMethods.book.remove(indexDel);
							EzMethods.bookAuthor.remove(indexDel);
							EzMethods.bookReleaseDate.remove(indexDel);
							
							}else {
								System.out.println("APENAS É POSSÍVEL ALUGAR 1 LIVRO POR VEZ");
							}
					
					} 
					catch (IndexOutOfBoundsException e) {
						System.out.println("ERRO! INDEX INEXISTENTE.");
					}
					
					break;
				case 2:	
					p.seeBooks();
					break;
				default:
					System.out.println("OPÇÃO INVÁLIDA.");
			}
		}
	} 
}
