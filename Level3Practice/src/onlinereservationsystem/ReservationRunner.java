package onlinereservationsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

import check.UserException;

public class ReservationRunner
{
	public static void main(String[] args)
	{
		LogicalLayer logic = new LogicalLayer();
		Logger logger = Logger.getLogger("Exception");
		/*
		 * UserInfo user = new UserInfo(); user.setUserId("1");
		 * user.setPassword("I@minevitable"); Map<String,UserInfo> hm = new
		 * HashMap<String,UserInfo>(); hm.put(user.getUserId(), user); user = new
		 * UserInfo(); user.setUserId("2"); user.setPassword("Darth^ader");
		 * hm.put(user.getUserId(), user); user = new UserInfo(); user.setUserId("3");
		 * user.setPassword("RaonMiru"); hm.put(user.getUserId(), user);
		 * logic.createUser(hm);
		 */
//		try
//		{
//			Map<String, List<PassengerInfo>> hm = logic.showManifest("03.12.2022");
//			System.out.println(hm);
//		}
//		catch(UserException e)
//		{
//			e.printStackTrace();
//		}
		
		System.out.println("Enter the user Id "); 
		Scanner sc = new Scanner(System.in);
		String userId = sc.nextLine();
		System.out.println("Enter the Password ");
		String password = sc.nextLine();
		try
		{
			logic.passwordVerification(userId,password);
			boolean first = true;
			while (first)
			{
				System.out.println("Choose the operation to be performed");
				System.out.println("1. Ticket Reservation");
				System.out.println("2. PNR enquiry");
				System.out.println("3. Cancellation");
				char choice = sc.nextLine().charAt(0);
				switch (choice)
				{
				case '1':
					System.out.println("Enter date of journey");
					String doj = sc.nextLine();
					logic.find(doj);
					System.out.println("Enter the from station");
					String from = sc.nextLine();
					System.out.println("Enter the to station");
					String to = sc.nextLine();
					int booked = logic.noOfPassengers(doj);
					if(booked != 16)
					{
						System.out.println("The number of vacancies are "+ (16-booked));
					}
					else
					{
						System.out.println("The number of vacancies are 0");
						System.out.println("The waiting list no is " + logic.getWaitListLen(doj));
					}
					System.out.println("Enter the number of tickets");
					int num = sc.nextInt();
					Long timeLong = System.currentTimeMillis();
					String time = timeLong.toString();
					String pnr = time.substring(3);
					sc.nextLine();
					List<PassengerInfo> list = new ArrayList<PassengerInfo>();
					List<PassengerInfo> waitList = new ArrayList<PassengerInfo>();
					for(int i=0; i<num; i++)
					{
						PassengerInfo passenger = new PassengerInfo();
						passenger.setPnr(pnr);
						System.out.println("Enter passenger "+(i+1)+" Details");
						System.out.println("Enter the name");
						String name = sc.nextLine();
						passenger.setName(name);
						System.out.println("Enter the sex");
						char sex = sc.nextLine().charAt(0);
						passenger.setSex(sex);
						System.out.println("Enter the Age");
						int age = sc.nextInt();
						passenger.setAge(age);
						sc.nextLine();
						System.out.println("Enter the Id number");
						String idNo = sc.nextLine();
						passenger.setIdNo(idNo);
						passenger.setCoachClass("Sleeper");
						passenger.setTrainName("Pallavan");
						passenger.setTrainNo("125006");
						passenger.setFrom(from);
						passenger.setTo(to);
						passenger.setDoj(doj);
						int result = logic.book(passenger);
						if(result == 1 )
						{
							int per = passenger.getSeatNo()%8;
							switch(per)
							{
							case 1:
							case 4:
								passenger.setBerth("U");
								break;
							case 2:
							case 5:
								passenger.setBerth("M");
								break;
							case 3:
							case 6:
								passenger.setBerth("L");
								break;
							case 7:
								passenger.setBerth("SU");
								break;
							case 0:
								passenger.setBerth("SL");
								break;
							}
							list.add(passenger);
						}
						else
						{
							waitList.add(passenger);
							logic.addToWaitList(passenger);
						}
					}
					int i = 1;
					if(!list.isEmpty())
					{
						logic.updateManifest(list);
						
						for(PassengerInfo pass:list)
						{
							System.out.println("\nTicket "+ i+" details");
							System.out.println(pass.toString());
							i++;
						}
					}
					if(!waitList.isEmpty())
					{
						for(PassengerInfo pass:waitList)
						{
							System.out.println("\nTicket "+ i+" details");
							System.out.println(pass.toString());
							System.out.println("this ticket has been waitlisted");
							i++;
						}
					}
					first = false;
					break;
				case '2':
					System.out.println("Enter the PNR number");
					pnr = sc.nextLine();
					System.out.println("Enter date of journey");
					doj = sc.nextLine();
					list= logic.retriveManifest(pnr, doj);
					i=1;
					if(list != null)
					{
						for(PassengerInfo pass:list)
						{
							System.out.println("passenger "+i+"details");
							System.out.println(pass.toString());
							i++;
						}
						waitList = logic.findFirstWait(pnr,doj);
						int j = 1;
						if(!waitList.isEmpty())
						{
							for(PassengerInfo pass:waitList)
							{
								System.out.println("passenger "+i+"details");
								System.out.println(pass.toString());
								System.out.println("WaitList number:"+j++);
								i++;
							}
						}
					}
					else
					{
						waitList = logic.findWait(pnr,doj);
						if(waitList.isEmpty())
						{
							System.out.println("the PNR number or date entered are incorrect");
						}
						else
						{
							for(PassengerInfo pass:waitList)
							{
								System.out.println("passenger "+i+"details");
								System.out.println(pass.toString());
								System.out.println("WaitList number:"+logic.findPos(pass));
								i++;
							}
						}
					}
					first = false;
					break;
				case '3':
					System.out.println("Enter the PNR number");
					pnr = sc.nextLine();
					System.out.println("Enter date of journey");
					doj = sc.nextLine();
					System.out.println("Enter the ID number");
					String idNo = sc.nextLine();
					int result = logic.cancel(pnr,doj,idNo);
					if(result == -1)
					{
						System.out.println("The entered ticket details are invalid");
					}
					else
					{
						System.out.println("The ticket has been successfully cancelled");
					}
					first = false;
					break;
				default:
					first = true;
					System.out.println("The choice is invalid");
				}
			}
		}
		catch(UserException e)
		{
			logger.severe(e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			sc.close();
		}
	}
}