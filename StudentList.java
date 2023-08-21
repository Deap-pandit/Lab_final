import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static String students;
	public static Constants constants=new Constants();
	public static String []studentName;



	public static void reader() {
		try{
			BufferedReader reader= new BufferedReader(
					new InputStreamReader(
							new FileInputStream(constants.fileName)));

			students = reader.readLine();
			 studentName = students.split(constants.split);

		}catch (Exception e){
			System.out.println(e);
		}

	}
	public static void write(String lastUpdate) {
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(
					new FileWriter(constants.fileName, true));
			bufferedWriter.flush();
			bufferedWriter.write(lastUpdate);
			bufferedWriter.close();
		}catch (Exception e){
			System.out.println(e);
		}

	}
	public static void main(String[] args) {

//		Check arguments

		if(args.length !=1){

		 	System.out.println(constants.invalid);
			return;
		}
		if(args[0].equals(constants.showNames)) {

			System.out.println(constants.loadingData);
			reader();
			for(String name : studentName) {
				System.out.println(name);
			}

			System.out.println(constants.loadedData);
		}
		else if(args[0].equals(constants.randomName))
		{
			System.out.println(constants.loadingData);
			reader();
			Random random = new Random();
				//int y = random.nextInt();

			System.out.println(studentName[random.nextInt(studentName.length)]);

			System.out.println(constants.loadedData);
		}
		else if(args[0].contains(constants.addName)){
			System.out.println(constants.loadingData);
			reader();
			try {

			String t= args[0].substring(1);
	       // Date d = new Date();
	        String df = "dd/mm/yyyy-hh:mm:ss a";
	        DateFormat dateFormat = new SimpleDateFormat(df);
	        String fd= dateFormat.format(new Date());
			write(", "+t+"\nList last updated on "+fd);

			} catch (Exception e){
				System.out.println(e);
			}
							
			System.out.println(constants.loadedData);
		}
		else if(args[0].contains(constants.query))
		{
			System.out.println(constants.loadingData);
			reader();
			//boolean done = false;
			//String t = args[0].substring(1);
			for(int idx = 0; idx<studentName.length ; idx++) {
				if(studentName[idx].equals(args[0].substring(1)) ){
					System.out.println(constants.found);
						break;

				}
			}

			System.out.println(constants.loadedData);
		}
		else if(args[0].contains(constants.countWord))
		{
			System.out.println(constants.loadingData);
			reader();
			char[] array = students.toCharArray();
			boolean in_word = false;
			int count=0;
			for(char space:array) {
				if(space ==' ')
				{
					if (!in_word) {	count++; in_word =true;	}
					else { in_word=false;}			
				}
			}
			System.out.println(count +" word(s) found " + array.length);

			System.out.println(constants.loadedData);
		}
		else {
			System.out.println(constants.invalid);
		}
	}
}