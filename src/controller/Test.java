package controller;

import model.Person;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

public class Test {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new FileWriter("person.txt", true));
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.dta", true));
		
		/*Person p = Person.getFromKeyboard(br);
		p.toCSV(pw);
		p.toDataFile(oos);*/
		
		BufferedReader br1 = new BufferedReader(new FileReader("person.txt"));
		String inp;
		
		/*while((inp = br1.readLine()) != null){
			 System.out.println(Person.readFromCSV(inp));
		}
		System.out.println("--------------------------------------------------------");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.dta"));
		Object obj = null;
		while((obj = ois.readObject()) != null){
			System.out.println((Person)obj);
		}
		
		pw.close();
		oos.close();*/
		
		FileOutputStream fis = new FileOutputStream("person.dta");
		Object obj = null;
		
		/*while(true){
			ObjectInputStream ois = new ObjectInputStream(fis);
			obj = ois.readObject();
		}*/
	}

}
