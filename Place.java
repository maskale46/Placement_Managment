/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author acer
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.MessagingException;

	public class Place{

		static Place a=new Place();
		public static void main(String[] args) throws IOException//5
		{
			
	            Scanner sc;
	         sc=new Scanner(System.in);
	          System.out.println("-----------------------------");
			  System.out.println("|PLACEMENT MANAGEMENT SYSTEM|");
			  System.out.println("-----------------------------");	
               int i=1;			  
	          while(i==1)
	          {        	  
	              System.out.println("Enter your Choice\n1:Student details\n2:Placement details\n3:Send mail\n4:Exit");
	         
	             int ch=sc.nextInt();
	           switch(ch)
	              {
	             case 1:
	         	        a.call();
	              break; 
	         
	            case 2:
	            
	                  System.out.println("Enter your Choice\n1:Add placement details\n2:Display placement details\n3:List of Placed students\n4:List of non Placed students\n 5:exit");
	                      int c1=sc.nextInt();
	           switch(c1)
	           {
	               case 1:
	                a.placement();//3
	                break;
	               case 2:
			          a.display();//4
	                break;
	               case 3:a.displayp();//4
	                   break;
					case 4:a.displayn();//4
					   break;
					   default:System.out.println("wrong choice");
	                }
	                
	              break;
	          case 3:a.selectedmail();
			 
			  break;
			  case 4:System.exit(0);
	          break;
			  
	              }
	      
	            }
	         }
	
        
			public void call() throws IOException
			{
		System.out.println("Enter your Choice\n1:Enter Student details\n2:Display students\n3:exit");
		Scanner sc=new Scanner(System.in);
         int c=sc.nextInt();
         switch(c)
         {

           case 1:
	                a.stud();//1
                        aa:for(int i=1; ;i++){
                            System.out.println("Do you want to enter another student details  Y/N");
                        
				 String str1=sc.next();
                                 
                                 if(str1.equals("y"))
				 {
					 a.stud();
				 }else{
                                     break aa;
                                 }
                                 }
             break;

            case 2:
				    a.display1();//4
					break;
            case 3:
                System.exit(0);
                 
         }
			}
			public void stud() throws IOException//1
			{
				int f=1;
			FileWriter fw=new FileWriter("C:\\Users\\acer\\OneDrive\\Pictures\\Students.txt",true);
			BufferedWriter br=new BufferedWriter(fw);
                        Scanner s=new Scanner(System.in);
			Place a=new Place();
                        
			
				System.out.println("Enter roll no");
				String rollno=s.nextLine();
				if(a.duplicate(rollno))
				{
					System.out.println("The student with roll no "+rollno+" is already present");
					
				}
				else
				{
				System.out.println("Enter name");
				String name=s.nextLine();
				System.out.println("Enter collage_name: ");
			    String collage_name=s.nextLine();
			    System.out.println("Enter avg percent: ");
			    String avg=s.nextLine();
			    System.out.println(" Enter the email_id: ");
			    String email_id=s.nextLine();
                            fw.write(rollno+" "+name+" "+collage_name+" "+avg+" "+email_id+"\n");
                                }
                            
                         fw.close();
			System.out.println();
			System.out.println();
                        }
                     public Boolean duplicate(String rollno) throws IOException//2
		{
			String rno;
			Scanner input=new Scanner(new File("C:\\Users\\acer\\OneDrive\\Pictures\\Students.txt"));
			while(input.hasNextLine())
				{
					String line=" ";
					line=input.nextLine();
					Scanner data=new Scanner(line);
					rno=data.next();
					if(rollno.equals(rno))
					{
						return true;
					}
				}
				return false;
		}
	
   

		public void placement() throws IOException//3
		{
			String rno,name,pa,cname,aavg,mail;
			
			Scanner s=new Scanner(System.in);
			Scanner fr=new Scanner(new File("C:\\Users\\acer\\OneDrive\\Pictures\\Students.txt"));
			System.out.println("Enter the placement status");
			while(fr.hasNextLine())
			{
				FileWriter fw=new FileWriter("C:\\Users\\acer\\OneDrive\\Pictures\\StudentAttendence.txt",true);
			    BufferedWriter bf=new BufferedWriter(fw);
				FileWriter fw1=new FileWriter("C:\\Users\\acer\\OneDrive\\Pictures\\StudentAttendence1.txt",true);
				FileWriter fw2=new FileWriter("C:\\Users\\acer\\OneDrive\\Pictures\\StudentAttendence2.txt",true);
				
				BufferedWriter bf1=new BufferedWriter(fw1);
				BufferedWriter bf2=new BufferedWriter(fw2);
				String line=" ";
				line=fr.nextLine();
				Scanner data=new Scanner(line);
				rno=data.next();
                                if(rno.isEmpty()){
                                    rno=data.next();
                                }
				name=data.next();
                                if(name.isEmpty()){
                                    name=data.next();
                                }
				cname=data.next();
                                if(cname.isEmpty()){
                                    cname=data.next();
                                }
                                aavg=data.next();
                                if(aavg.isEmpty()){
                                    aavg=data.next();
                                }
                                mail=data.next();{
                            if(mail.isEmpty()){
                                mail=data.next();
                            }
                        }
                                System.out.println("__________________STUDENT DETAILS AND ATTTENDENCE________________");
				System.out.printf(rno+" | "+name+" | "+cname+" | "+aavg+" | "+mail+" | ");
				pa=s.nextLine();
                                if(pa.isEmpty()){
                                    pa=s.next();
                                }
                                System.out.println();
				 if(pa.contentEquals("p"))
				{
					System.out.println(rno+" | "+name+" | "+cname+" | "+aavg+" | "+mail+" | "+pa);
                                        bf1.write(rno+" "+name+" "+cname+" "+aavg+" "+mail+" "+pa+"\n");
					bf1.close();
                                        fw1.close();
				}
				else
				{
					bf2.write(rno+" "+name+" "+cname+" "+aavg+" "+mail+" "+pa+"\n");
					bf2.close();
                                        fw2.close();
				}
				bf.write(rno+" "+name+" "+cname+" "+aavg+" "+mail+" "+pa+"\n");
				bf.close();
                                fw.close();
		    }
			
		}
		public void display() throws IOException//4
		{
		     String rno,name,pa,cname,aavg,mail;
			Scanner input=new Scanner(new File("C:\\Users\\acer\\OneDrive\\Pictures\\StudentAttendence.txt"));
			System.out.println("Rollno \t Name\t\t Collage_name\t Average_Percentage\t Mail_id \t Placement_status\n");
			while (input.hasNextLine())
				{
					String line=" ";
					line=input.nextLine();
					Scanner data=new Scanner(line);
                                            rno=data.next();
                                          if(rno.isEmpty()){
                                              rno=data.next();
                                          }
					name=data.next();
                                        if(name.isEmpty()){
                                            name=data.next();
                                        }
					cname=data.next();
                                        if(cname.isEmpty()){
                                            cname=data.next();
                                        }
	                aavg=data.next();
                        if(aavg.isEmpty()){
                            aavg=data.next();
                        }
	                mail=data.next();
                        if(mail.isEmpty()){
                            mail=data.next();
                        }
					pa=data.next();
                                        if(pa.isEmpty()){
                                            pa=data.next();
                                        }
					System.out.printf(rno+" | "+name+" | "+cname+" | "+aavg+" | "+mail+" | "+pa+"\n");
				
				}
		}
		public void displayp() throws IOException//4
		{
		     String rno,name,pa,cname,aavg,mail;
			Scanner input=new Scanner(new File("C:\\Users\\acer\\OneDrive\\Pictures\\StudentAttendence1.txt"));
			System.out.println("Rollno \t Name\t\t Collage_name \tAverage_Percentage \tMail_Id \t Placement_status\n");
			while (input.hasNextLine())
				{
					String line=" ";
					line=input.nextLine();
					Scanner data=new Scanner(line);
					rno=data.next();
                                        if(rno.isEmpty()){
                                            rno=data.next();
                                        }
					name=data.next();
                                    if(name.isEmpty()){
                                        name=data.next();
                                    }
                                
					cname=data.next();
                                        if(cname.isEmpty()){
                                            cname=data.next();
                                        }
	                aavg=data.next();
                        if(aavg.isEmpty()){
                            aavg=data.next();
                        }
	                mail=data.next();
                        if(mail.isEmpty()){
                            mail=data.next();
                        }
					pa=data.next();
                                        if(pa.isEmpty()){
                                            pa=data.next();
                                        }
					System.out.printf(rno+" | "+name+" | "+cname+" | "+aavg+" | "+mail+" | "+pa+"\n");
				
				}
		}
		public void displayn() throws IOException//4
		{
		     String rno,name,pa,cname,aavg,mail;
			Scanner input=new Scanner(new File("C:\\Users\\acer\\OneDrive\\Pictures\\StudentAttendence2.txt"));
			System.out.println("Rollno \t Name\t\t Collage_name \t Average_Percentage \t Mail_id \t Placement_status\n");
			while (input.hasNextLine())
				{
					String line=" ";
					line=input.nextLine();
					Scanner data=new Scanner(line);
					rno=data.next();
					name=data.next();
					cname=data.next();
	                aavg=data.next();
	                mail=data.next();
					pa=data.next();
					System.out.printf(rno+" | "+name+" | "+cname+" | "+aavg+" | "+mail+" | "+pa+"\n");
				
				}
		}
			public void display1() throws IOException//4
		{
		     String rollno,name,collage_name,avg,email_id;
			Scanner input=new Scanner(new File("C:\\Users\\acer\\OneDrive\\Pictures\\Students.txt"));
			System.out.println("Rollno \t Name\t\t Collage_name\t Average_percentage \t Mail_id \n");
			while (input.hasNextLine())
				{
					String line=" ";
					line=input.nextLine();
					Scanner data=new Scanner(line);
					rollno=data.next();
                                        if(rollno.isEmpty()){
                                            rollno=data.next();
                                        }
					name=data.next();
                                        if(name.isEmpty()){
                                            name=data.next();
                                        }
					collage_name=data.next();
                                        if(collage_name.isEmpty()){
                                            collage_name=data.next();
                                        }
	                avg=data.next();
                        if(avg.isEmpty()){
                            avg=data.next();
                        }
	                email_id=data.next();
                        if(email_id.isEmpty()){
                            email_id=data.next();
                        }
					System.out.printf(rollno+" | "+name+" | "+collage_name+" | "+avg+" | "+email_id+"\n");
				
				}
		}
                        
                        
        public void selectedmail() throws FileNotFoundException
            {
                String rno,name,pa,cname,aavg,mail;
                Scanner sc=new Scanner(System.in);
			Scanner input=new Scanner(new File("C:\\Users\\acer\\OneDrive\\Pictures\\StudentAttendence1.txt"));
                        aa:while (input.hasNextLine())
				{
					String line=" ";
					line=input.nextLine();
					Scanner data=new Scanner(line);
					rno=data.next();
                                        if(rno.isEmpty()){
                                            rno=data.next();
                                        }
					name=data.next();
                                        if(name.isEmpty()){
                                            name=data.next();
                                        }
					cname=data.next();
                                        if(cname.isEmpty()){
                                            cname=data.next();
                                        }
	                aavg=data.next();
                        if(aavg.isEmpty()){
                            aavg=data.next();
                        }
	                mail=data.next();
                        if(mail.isEmpty()){
                            mail=data.next();
                        }
					pa=data.next();
					System.out.println("sending mail to\t" +name);
				mail1(mail);
                                System.out.println("Do You Want Send Email Next Person\n If Yes Press y");
                                String ch=sc.next();
                                if(ch.contains("y")){
                                    continue aa;
                                }
                                else{
                                    System.exit(0);
                                }
				}
				
				}
            
			public void mail1(String mailto)
			{
				Scanner sc = new Scanner(System.in);
				mail m=new mail();
				  String mail,pass,to,sub,msg;
			 mail="shiva******@gmail.com";
			pass="********0";
			 sub="Placement Cell Department";
			 msg="Congratulation\n Dear.\n You Placed Placement";
			 to=mailto;
			m.sendmail(mail,pass,to,sub,msg);
  
	}
	}
	class mail
{
            
            
            
	public void sendmail(String user, String password,String to,String sub,String msg)
	{
		System.out.println("Preparing To Send....");
                Scanner input=new Scanner(System.in);
		//String host="smtp.gmail.com";  
		Properties props = new Properties();    
		props.put("mail.smtp.host","smtp.gmail.com");  
		props.put("mail.smtp.auth", "true"); //enable authentication
		props.put("mail.smtp.starttls.enable","true"); 
		//props.put("mail.smtp.EnableSSL.enable","true");
		//props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");   
		//props.setProperty("mail.smtp.socketFactory.fallback", "false");   
		props.setProperty("mail.smtp.port", "587");   
		//props.setProperty("mail.smtp.socketFactory.port", "587"); 
				
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
								protected PasswordAuthentication getPasswordAuthentication() {
								return new PasswordAuthentication(user, password);}
								});
		//Compose the message  
		try 
		{  
			MimeMessage message = new MimeMessage(session);  
			message.setFrom(new InternetAddress(user));  
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
			message.setSubject(sub);  
			message.setText(msg);  
				
			//send the message  
			Transport.send(message);
		  
			System.out.println("\nmessage sent successfully...");  
		}
		catch (MessagingException e) {e.printStackTrace();} 
}
}
