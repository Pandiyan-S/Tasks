package virtualclassroom;

import java.util.Scanner;

import check.UserException;

public class ClassroomRunner
{
	public void studentInterface(UserInfo user,Scanner sc) throws UserException
	{
		boolean truth = true;
		LogicalLayer logic = new LogicalLayer();
		while(truth)
		{
			System.out.println("Enter the operation to be performed");
			System.out.println("1.Edit Profile");
			System.out.println("2.Access Study Material");
			System.out.println("3.Ask doubts");
			System.out.println("4.Frequently asked questions");
			int choice = sc.nextInt();
			sc.nextLine();
			switch(choice)
			{
			case 1:
				System.out.println("Enter the new name");
				String name = sc.nextLine();
				System.out.println("Enter the Date of Birth");
				String dob = sc.nextLine();
				System.out.println("Enter the Phone Number");
				long phNo = sc.nextLong();
				logic.updateProfile(user.getUserId(),name,dob,phNo);
				truth =false;
				break;
			case 2:
				System.out.println("Enter the topic to study");
				String topic = sc.nextLine();
				for(StudyMaterial mat : logic.thisMaterial(topic))
				{
					System.out.println(mat.toString());
				}
				truth =false;
				break;
			case 3:
				System.out.println("Enter the doubt");
				String question = sc.nextLine();
				logic.askQuestion(question);
				System.out.println("Question posted successfully");
				truth =false;
				break;
			case 4:
				System.out.println("Frequently asked questions");
				for(Doubts ask: logic.allDoubts())
				{
					System.out.println(ask.toString());
				}
				truth =false;
				break;
			default:
				truth = true;
				System.out.println("The choice is invalid");
			}
		}
		
	}
	public void teacherInterface(UserInfo user,Scanner sc) throws UserException
	{
		boolean truth = true;
		LogicalLayer logic = new LogicalLayer();
		while(truth)
		{
			System.out.println("Enter the operation to be performed");
			System.out.println("1.Edit Profile");
			System.out.println("2.add or remove Study Material");
			System.out.println("3.See all doubts");
			System.out.println("4.Answer doubt");
			int choice = sc.nextInt();
			sc.hasNextLine();
			switch(choice)
			{
			case 1:
				System.out.println("Enter the new name");
				String name = sc.nextLine();
				System.out.println("Enter the Date of Birth");
				String dob = sc.nextLine();
				System.out.println("Enter the Phone Number");
				long phNo = sc.nextLong();
				logic.updateProfile(user.getUserId(),name,dob,phNo);
				truth =false;
				break;
			case 2:
				System.out.println("The materials uploaded by you are ");
				int i=1;
				for(StudyMaterial mat : logic.yourMaterial(user.getUserId()))
				{
					System.out.println("Material "+(i++));
					System.out.println(mat.toString());
				}
				System.out.println("Enter 1 to remove materials");
				System.out.println("Enter any other key to add materials");
				char ch = sc.nextLine().charAt(0);
				if(ch == '1')
				{
					System.out.println("Enter the material id of the material to be removed");
					Long materialId = sc.nextLong();
					sc.nextLine();
					if(logic.checkId(user.getUserId(),materialId))
					{
						logic.deleteMaterial(materialId);
					}
					else
					{
						System.out.println("There is no such material uploaded by you");
					}
				}
				else
				{
					System.out.println("Enter the topic");
					String topic = sc.nextLine();
					System.out.println("Enter the file type");
					String fileType = sc.nextLine();
					System.out.println("Enter the link");
					String link = sc.nextLine();
					logic.upload(user.getUserId(),topic,fileType,link);
				}
				truth =false;
				break;
			case 3:
				System.out.println("All asked questions");
				for(Doubts ask: logic.allDoubts())
				{
					System.out.println(ask.toString());
				}
				truth =false;
				break;
			case 4:
				System.out.println("Enter the doubt Id");
				long doubtId = sc.nextLong();
				sc.nextLine();
				System.out.println("Enter the Answer");
				String answer = sc.nextLine();
				logic.answerQuestion(doubtId,answer);
				System.out.println("Question posted successfully");
				truth =false;
				break;
			default:
				truth = true;
				System.out.println("The choice is invalid");
			}
		}
	}
	public void adminInterface(Scanner sc) throws UserException
	{
		boolean truth = true;
		LogicalLayer logic = new LogicalLayer();
		while(truth)
		{
			System.out.println("Enter the operation to be performed");
			System.out.println("1.List of users");
			System.out.println("2.Pending request");
			System.out.println("3.All Questions and answers");
			int choice = sc.nextInt();
			sc.hasNextLine();
			switch(choice)
			{
			case 1:
				System.out.println("List of users");
				for(UserInfo user: logic.allUsers())
				{
					System.out.println(user.toString());
				}
				truth = false;
				break;
			case 2:
				System.out.println("Pending List");
				for(UserInfo user: logic.allPending())
				{
					System.out.println(user.toString());
				}
				System.out.println("Enter the user id");
				int userId = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter 1 to approve");
				System.out.println("Enter any other key to reject");
				char approve = sc.nextLine().charAt(0);
				if(approve == '1')
				{
					logic.updateStatus(userId,"approved");
					System.out.println("User "+userId + " has been approved");
				}
				else
				{
					logic.updateStatus(userId,"reject");
					System.out.println("User "+userId + " has been rejected");
				}
				truth = false;
				break;
			case 3:
				System.out.println("All asked questions");
				for(Doubts ask: logic.allDoubts())
				{
					System.out.println(ask.toString());
				}
				System.out.println("Enter the doubtId");
				long doubtId = sc.nextLong();
				logic.removeDoubt(doubtId);
				System.out.println("the doubt has been deleted");
				truth =false;
				break;
			}
		}
	}
	public static void main(String[] args)
	{
		ClassroomRunner room = new ClassroomRunner();
		LogicalLayer logic = new LogicalLayer();
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 to sign up");
		System.out.println("Press any other key to sign in");
		char perform = sc.nextLine().charAt(0);
		if(perform == '1')
		{
			System.out.println("Enter the Password");
			String password = sc.nextLine();
			System.out.println("Enter the Name");
			String name = sc.nextLine();
			System.out.println("Enter the Date of Birth");
			String dob = sc.nextLine();
			System.out.println("Enter the Phone Number");
			long phNo = sc.nextLong();
			sc.nextLine();
			System.out.println("Press 0 if you are an Admin");
			System.out.println("Press 1 if you are a Teacher");
			System.out.println("Press any other key if you are a student");
			try
			{
				char type = sc.nextLine().charAt(0);
				if(type == '0')
				{
					logic.sendRequest(password,name,dob,phNo,"Admin");
				}
				else if(type == '1')
				{
					logic.sendRequest(password,name,dob,phNo,"Teacher");
				}
				else
				{
					logic.sendRequest(password,name,dob,phNo,"Student");
				}
				System.out.println("Request submitted");
			}
			catch (UserException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			try
			{
				System.out.println("Enter the User Id");
				int userId = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter the password");
				sc.hasNextLine();
				String password = sc.nextLine();
				UserInfo user = logic.findUser(userId,password);
				if(user == null)
				{
					System.out.println("The entered User ID or Password is invalid");
				}
				else
				{
					System.out.println("The user details are :");
					System.out.println(user.toString());
					if(user.getType().equalsIgnoreCase("Admin"))
					{
						room.adminInterface(sc);
					}
					else if(user.getType().equalsIgnoreCase("Teacher"))
					{
						room.teacherInterface(user,sc);
					}
					else
					{
						room.studentInterface(user,sc);
					}
				}
			}
			catch (UserException e)
			{
				e.printStackTrace();
			}
		}
	}
}
