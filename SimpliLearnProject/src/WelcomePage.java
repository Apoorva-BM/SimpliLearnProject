import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WelcomePage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("*****Welcome Page*****");
		System.out.println("Developer: Apoorva BM");
	    File file = new File("C:/Users/Dell/Documents/ParentFile");
		String filename[] = file.list();
		List<String> list =new ArrayList<String>(Arrays.asList(filename));
		int mainChoice;
		
			    
		do{
			System.out.println("Choose an Option:\n1.Display the contents of the directory\n2.Edit the current Directory\n3.Exit Apllication");
			mainChoice=sc.nextInt();
			switch(mainChoice) {
		
	    case 1: 
	    	list.sort(null);
			for(String name : list ) {
				System.out.println(name); }
			break;
	    case 2 :	System.out.println("*****Second Screen*****");  
	    	SecondOption second = new SecondOption();
	    			second.secondPage(list,file);
	    			break;
	    case 3: System.exit(0); break;
	    default : System.out.println("Wrong Option");
	    
	    }} while(mainChoice!=3);
	    sc.close();
		}
		
	}
class SecondOption{
	public void secondPage(List<String> list,File file) {
		Scanner s = new Scanner(System.in);
		int choice;
		try {
		do {
			System.out.println("Choose which operation has to be done to the existing directory");
			System.out.println("1.Add a file to the existing directory list\n2.Delete a  file from the existing directory list");
			System.out.println("3.Search for a file from the directory\n4.Navigate back to the main context\n");
			choice = s.nextInt();
			
			switch(choice) {
			
			case 1 : if(file.createNewFile()) {
				System.out.println("File created");
			}
				list.add("New.Txt");
					System.out.println("The New List of existing directory");
					for(String name : list ) {
				         System.out.println(name);
					}
					break;
			case 2:  System.out.println("Enter the file to be deleted:");
					String deleteItem = s.next();
					list.remove(deleteItem);
					for(String name : list ) {
				         System.out.println(name);
					}
					break;
			case 3: System.out.println("Enter the name of the file:");
			String searchItem = s.next();
				if(list.contains(searchItem))
					System.out.println("Found " + searchItem);
				else
					System.out.println("Not Found");
				break;
			case 4:WelcomePage.main(null);
			break;
			default: System.out.println("Wrong Option");
			}
			}while(choice!=4);}
		catch(IOException e) {
			e.printStackTrace();
			System.out.println("IOException Found because of File Creation");
		}
			s.close();
	}
}
