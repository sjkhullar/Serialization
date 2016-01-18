package org.learn;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeDeserialize {

	public static void serialize() throws IOException {
		Person person = new Person("Mike", "harvey", 34, "001894536");
		FileOutputStream output = new FileOutputStream(new File("savePerson.txt"));
		ObjectOutputStream outputStream = new ObjectOutputStream(output);
		outputStream.writeObject(person);
		outputStream.flush();
		outputStream.close();
		System.out.println("Serialized the person object : "+person);
	} 
	public static void deSerialize() throws IOException, ClassNotFoundException {
		
		FileInputStream inputStream = new FileInputStream(new File("savePerson.txt"));
		ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
		Person person = (Person) objectInputStream.readObject();
		System.out.println("Deserialize the person object :"+ person);
		inputStream.close();
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		serialize();
		deSerialize();
	}
}
