package com.exception.whatIsException;

public class Try_With_Multiple_Catch {
	
	public static void main(String[] args) {
		String name = null;
		int arr[] = {1, 2, 3};
		 
		try {
//			System.out.println(10/0);  //Arithmatic Exception
//			System.out.println(name.length()); // Null pointer Exception
			System.out.println(arr[3]);   
		}catch(ArithmeticException e) {
			System.out.println("This is arithmatic exception " + e.getMessage());
		}
		catch (NullPointerException e) {
			System.out.println("This is NullPointerException ->  " + e.getMessage());
		}
		
		catch (Exception e) {
			System.out.println("This is Some thing else Exception");
		}
	}

}
