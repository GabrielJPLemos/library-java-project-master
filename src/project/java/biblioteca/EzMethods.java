package com.project.java.biblioteca;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;

public class EzMethods {
	
	public static ArrayList<String> book = new ArrayList<String>();
	public static ArrayList<String> bookAuthor = new ArrayList<String>();
	public static ArrayList<String> bookReleaseDate = new ArrayList<String>();
	
	public static ArrayList<String> user1 = new ArrayList<String>();
	public static ArrayList<String> user2 = new ArrayList<String>();
	public static ArrayList<String> user3 = new ArrayList<String>();
	
	
	
	public void printForMenu(String... message) {
		for (int x = 0; x<message.length; x++) {
			System.out.println(message[x]);
		}
	}	
	
	
	public static  int menuTreatmentException () {
		int a;
		Scanner sc = new Scanner(System.in);
		try {
			a = sc.nextInt();		
			return a;
			
		} 
		catch (InputMismatchException e) {
			System.out.println("ERRO DE DIGITAÇÃO, TENTE NOVAMENTE!");
			return -1;
			
		}
	}
			
	
	public void mockStartAndMenu () {
		book.add("Berserk");
		book.add("One Piece");
		book.add("Naruto");
		book.add("Dragon Ball");	
		
		bookAuthor.add("Kentaro Miura");
		bookAuthor.add("Eiichiro Oda");
		bookAuthor.add("Massashi Kishimoto");
		bookAuthor.add("Akira Toriyama");
		
		bookReleaseDate.add("26 de Novembro de 1990");
		bookReleaseDate.add("20 de Outubro de 1999");
		bookReleaseDate.add("21 de Setembro de 1999");
		bookReleaseDate.add("26 de Abril de 1989");
		
		new MenuBiblioteca().menu();
	}
		
		
	public ArrayList<String> bookList (int choice, String... info) {	
		switch (choice) {
			case 1:
				book.add(info[0]);
				bookAuthor.add(info[1]);
				bookReleaseDate.add(info[2]);			
				System.out.println("LIVRO CADASTRADO COM SUCESSO!");
				break;
				
			default:
				System.out.println("Opção Inválida.");
			
				
		}
		return null;
		
		
		
	}
	
	public void seeBooks () {
		System.out.println("INDEX"+ "    NOME                " + "AUTOR                " + "DATA DE LANÇAMENTO");
		for (int x = 0; x<book.size(); x++) {
			System.out.print(x + "   ");
			System.out.print("   "+book.get(x) + "                ");
			System.out.print("   "+bookAuthor.get(x) + "                ");
			System.out.print("   "+bookReleaseDate.get(x) + "                ");
			System.out.println();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
