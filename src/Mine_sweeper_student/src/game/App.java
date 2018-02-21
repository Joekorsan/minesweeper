package Mine_sweeper_student.src.game;

import java.util.Scanner;


public class App {

	static Scanner reader = new Scanner(System.in);
	static int width;
	static int height;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//		boolean check = false;
		
		System.out.println(" enter a positive int between 5 and 20");
		
		System.out.print("enter width here: ");
		width = reader.nextInt();
		System.out.print("enter height here: ");
		height = reader.nextInt();
		
		System.out.println("i am here");
		
		if(check(width, height)){
			System.out.println("is good");
			System.out.println(" this is the width " + width +" this is the height "+ height);
		}
		else{
			
		}
		
		
		
		
		
		
		
		
	}//end of main

	public static boolean check( int width, int height){
		boolean checkB = false;
		
		//Scanner reader = new Scanner(System.in);
		
		if(width >= 5 && width <= 20 && height >= 5 && height <= 20){
			checkB = true;
		}
		else
		{
			while(!checkB){
				System.out.println("please enter the CORRECT W and H");
				
				System.out.print("enter width here: ");
				width = reader.nextInt();
				System.out.print("enter height here: ");
				height = reader.nextInt();
				
				if(width >= 5 && width <= 20 && height >= 5 && height <= 20){
					checkB = true;
					break;
				}
				
			}
		}
		
		return checkB;
	}//end of check method 
	
	
}
