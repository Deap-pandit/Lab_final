import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {

//		Check arguments

		if(args.length !=1){

			System.out.println("invalid argument");
			return;
		}
		if(args[0].equals("a")) {
			System.out.println("Loading data ...");			
			try {
			BufferedReader s = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String students = s.readLine();
			String studentName[] = students.split(",");
			for(String name : studentName) {
				System.out.println(name);
			}
			} catch (Exception e){} 
			System.out.println("Data Loaded.");
		}
		else if(args[0].equals("r")) 
		{
			System.out.println("Loading data ...");			
			try {
			BufferedReader s = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String students= s.readLine();
			//System.out.println(students);
			String studentName[] = students.split(",");
			Random random = new Random();
				//int y = random.nextInt();

					System.out.println(studentName[random.nextInt(studentName.length)]);
			} catch (Exception e){} 
			System.out.println("Data Loaded.");			
		}
		else if(args[0].contains("+")){
			System.out.println("Loading data ...");			
			try {
			BufferedWriter s = new BufferedWriter(
					new FileWriter("students.txt", true));
			String t= args[0].substring(1);
	        Date d = new Date();
	        String df = "dd/mm/yyyy-hh:mm:ss a";
	        DateFormat dateFormat = new SimpleDateFormat(df);
	        String fd= dateFormat.format(d);
			s.write(", "+t+"\nList last updated on "+fd);
			s.close();
			} catch (Exception e){}
							
			System.out.println("Data Loaded.");	
		}
		else if(args[0].contains("?")) 
		{
			System.out.println("Loading data ...");			
			try {

			BufferedReader s = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String students = s.readLine();
			String studentName[] = students.split(", ");
			boolean done = false;
			//String t = args[0].substring(1);
			for(int idx = 0; idx<studentName.length && !done; idx++) {
				if(studentName[idx].equals(args[0].substring(1)) ){
					System.out.println("We found it!");
						done=true;
				}
			}
			} catch (Exception e){} 
			System.out.println("Data Loaded.");				
		}
		else if(args[0].contains("c")) 
		{
			System.out.println("Loading data ...");			
			try {
			BufferedReader s = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String D = s.readLine();
			char array[] = D.toCharArray();
			boolean in_word = false;
			int count=0;
			for(char c:array) {
				if(c ==' ') 
				{
					if (!in_word) {	count++; in_word =true;	}
					else { in_word=false;}			
				}
			}
			System.out.println(count +" word(s) found " + array.length);
			} catch (Exception e){} 
			System.out.println("Data Loaded.");				
		}
		else {
			System.out.println("invalid input");
		}
	}
}