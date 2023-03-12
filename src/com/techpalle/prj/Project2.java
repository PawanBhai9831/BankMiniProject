package com.techpalle.prj;

import java.util.Scanner;
import java.io.*;



class Myexception extends Exception{
	
	public char[] getMessage;

	Myexception(String message){
		super(message);
	}
}

class Bank
{
	private int age;
	private String name;
	private long balance=0;
	private long ac_no;
	
	public Bank(int age,String name,long ac_no) {
		this.age=age;
		this.name=name;
		this.ac_no=ac_no;
	  }
	public long getAc_no() {
		return ac_no;
	}
	
	public void setAc_no(long ac_no)
	{
		this.ac_no=ac_no;
	  }
	public int getAge() {
		return age;
	}
	public void setAge(int ch)
	{
		this.age=ch;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance=balance;
	}
}
class SBI extends Bank
  {
	public SBI(int age,String name,long balance) 
	{
		super(age,name,balance);
	}
  }

class SbiSavingsAc extends SBI
  {
	public  SbiSavingsAc (int age,String name,long balance) {
		super(age,name,balance);
	}
  }


public class Project2 {

	public static void main(String[] args) throws Myexception {
		
      Scanner s=new Scanner(System.in);
      System.out.println("Welcome to SBI Bank");
      int ch;
      long t = 0;
      SbiSavingsAc ac=new SbiSavingsAc(0,"xyz",0);
      boolean b=true;
      String ss;
      try {
      while(b) 
	  {
		
		  System.out.println("");
		  System.out.println("\tMenu");
		  System.out.println("1.Create A/c");
		  System.out.println("2.Deposit Money");
		  System.out.println("3.Withdraw Money");
		  System.out.println("4.Display Details");
		  System.out.println("5.Exit");
		  System.out.println("Enter your choice:");
		  ch=s.nextInt();
		  switch(ch) {
		  
		          case 1:System.out.println("Please enter your details");
		                 System.out.println("Please enter your Name:");
		                 ss=s.next();
		                 ac.setName(ss);
		                 System.out.println("Please Enter your Age:");
		                 ch=s.nextInt();
		                 ac.setAge(ch);
		                 System.out.println("Enter the account number:");
		                 t=s.nextLong();
		                 ac.setAc_no(t);
		                 System.out.println("Account Created Successfully:");
		                 break;
		                 
		          case 2:System.out.println("Deposit Section");
		                 System.out.println("Please Enter the AC number to deposit money:");
		                 t=s.nextLong();
		                try
		                   {
		        	         if(ac.getAc_no()==t)
		        	          {
		        	    	System.out.println("Enter Money to be Deposited:");
		        	    	
		        	    	try {
		        	    	  t=s.nextLong();
		        	          if(t<500) {
		        	        	  throw new Myexception("Minimum Balance Deposit Voilated");
		        	             }
		        	          
		        	          else {
		        	        	  long bb;
		        	        	  bb=ac.getBalance()+t;
		        	        	  ac.setBalance(bb);
		        	             }
		        	    	  }
		        	    	catch(Myexception e)
		        	    	   {
		        	    		System.out.println(e.getMessage());
		        	    		System.out.println("Transaction failed");
		        	    		b=false;
		        	    	    }
		        	          }
		        	         
		        	      else {
		        	        	 throw new Myexception("Account not Found");
		        	            }
		                     }
		        	    catch(Myexception e)
		                   {
		        	    		System.out.println(e.getMessage());
		        	    		System.out.println("Transaction failed");
		        	    		b=false;
		        	    	}
		                
		          case 3:System.out.println("Withdraw Section\n");
		                 System.out.println("Please Enter the Account Number to withdraw Money:");
		                 t=s.nextLong();
		                 try {
		                	 if(ac.getAc_no()==t) {
		                		 System.out.println("Enter the amount to be withdraw:");
		                		 t=s.nextLong();
		                		 try {
		                			 if(ac.getBalance()>t)
		                			    {
		                				 System.out.println("Amount Withdraw: ");
		                				 long a;
		                				 a=ac.getBalance()-t;
		                				 ac.setBalance(a);
		                				 
		                			      }
		                			 else {
		                				 throw new Myexception("Withdraw amount voilated");
		                			    }
		                		    }
		                		 catch(Myexception e) {
		                			 System.out.println(e.getMessage());
		                			 System.out.println("Transaction Failed");
		                			 b=false;
		                		   }
		                	 }
		                	 else {
		                		 throw new Myexception("Account not found");
		                	 }
		                 }		      
		                 catch(Myexception e) {
		                	 System.out.println(e.getMessage());
		                	 System.out.println("Transaction failed");
		                	 b=false;
		                 }
		                		 
		              case 4:System.out.println("Account Details");
		            		 System.out.println("Nmae :" + ac.getName());
		                	 System.out.println("Account No :"+ ac.getAc_no());
		                	 System.out.println("Age :" + ac.getAge());
		                	 System.out.println("Balance : " + ac.getBalance());
		              		 break;
		                			 
		               case 5:throw new Myexception("User Exit");
		               
		             }
	              }
            }
		                	 
      catch(Myexception e) 

      {
		  //e.printStackTrace();
		  
		  //System.out.println(e.getMessage);
		  System.out.println("Thanks for using");
		  System.exit(0);
	        }
         }
        
	  }
      
      
	

  
	
