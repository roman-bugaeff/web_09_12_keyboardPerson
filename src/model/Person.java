package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;

public class Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private double weight;
	private boolean married;

	public Person(String name, int age, double weight, boolean married) {
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.married = married;
	}

	@Override
	public String toString() {
		return "Person: name = " + name + ", age = " + age + ", weight = " + weight + ", married = " + married + ".";
	}

	public static Person getFromKeyboard(BufferedReader br) {

		String n = null;
		String nInp = null;
		String sInp = null;
		String wInp = null;
		while (true) {
			System.out.println("Input persons name:");
			try {
				sInp = br.readLine();
				if (!sInp.equals("") && !sInp.equalsIgnoreCase("exit")) {
					n = sInp;
					break;
				} else {
					if (!sInp.equals(""))
						return null;
					System.out.println("Empty names not allowed!");
				}
			} catch (IOException e) {
			}
		}

		int a = 0;
		while (true) {
			System.out.println("Input persons age:");
			try {
				nInp = br.readLine();
				if (!nInp.equals("") && !nInp.equalsIgnoreCase("exit")) {
					a = Integer.parseInt(nInp);
					break;
				} else {
					if (!nInp.equals(""))
						return null;
					System.out.println("Empty age not allowed!");
				}
			} catch (IOException e) {
			} catch (NumberFormatException e1) {
				System.out.println("Only integers allowed");
			}
		}

		double w = 0.;
		while (true) {
			System.out.println("Input persons weight:");
			try {
				wInp = br.readLine();
				if (!wInp.equals("") && !wInp.equalsIgnoreCase("exit")) {
					w = Double.parseDouble(wInp);
					break;
				} else {
					if (!wInp.equals(""))
						return null;
					System.out.println("Empty weight not allowed!");
				}
			} catch (IOException e) {
			} catch (NumberFormatException e1) {
				System.out.println("Only doubles allowed");
			}
		}
		boolean m = false;
		while (true) {
			System.out.println("Is the person merried?\n:" + "\t 0 - No\n" + "\t 1 - Yes");
			try {
				nInp = br.readLine();
				if (!nInp.equals("") && !nInp.equalsIgnoreCase("exit")) {
					if (!nInp.equals("0") && !nInp.equals("1")) {
						System.out.println("Only 0 and 1 allowed");
					} else {
						m = nInp.equals("1");
						break;
					}
				} else {
					if (!nInp.equals(""))
						return null;
					System.out.println("Empty married not allowed!");
				}
			} catch (IOException e) {}			
		}
		return new Person(n, a, w, m);	
	}
	
	public void toCSV(PrintWriter pw){		
		pw.println(name + ";" + Integer.toString(age) + ";" + Double.toString(weight) + ";" + Boolean.toString(married));
	}
	
	public void toDataFile(ObjectOutputStream oos){
		try {
			oos.writeObject(this);
		} catch (IOException e) {}
	}
	
	public static Person readFromCSV(String inp){
		String[] arr = inp.split(";");
		return new Person(arr[0], Integer.parseInt(arr[1]), Double.parseDouble(arr[2]), Boolean.parseBoolean(arr[3]));
	}
}
