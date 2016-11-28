import java.text.ParseException;
import java.util.Date;
/**
 * @author Alexandra Solorano
 * This class tastefully tests all of the methods created in 
 * SortedDblList.
 */
public class Demo {
	@SuppressWarnings({ "unchecked", "rawtypes", "unused", "deprecation" })
	public static void main(String[]args) throws ParseException, ClassNotFoundException{
		
	SortedDblList test = new SortedDblList();
	SortedDblList empty = new SortedDblList();
	SortedDblList studentTest = new SortedDblList();
	Date dob =new Date("10/25/1996");
	Person a = new Person("person","one",1201,dob);
	Person b = new Person("person","two",1202,dob);
	Student aa = new Student("student","one",5025,dob,"uga");
	Student bb = new Student("student","two",1510,dob,"uga");
	test.add(a);
	test.add(b);
	studentTest.add(aa);
	studentTest.add(bb);
	//Write Test
	System.out.println("Write Test");
	studentTest.writeObject("src/fileName"); //<--- pathway to fileName src/edu/uga/cs1302/list
	System.out.println("");
	
	//Read Test
	System.out.println("Read Test");
	SortedDblList readTest = new SortedDblList();
	readTest = studentTest.readObject("src/fileName");
	readTest.printList();
	System.out.println("");
	
	
	//isEmpty Test
	 System.out.println("IsEmpty Test");
	 System.out.println(empty.isEmpty());
	 System.out.println(test.isEmpty());
	 System.out.println("");
	
	 //get test
	 System.out.println("Get Test");
	 System.out.println(test.get(0));
	 System.out.println("");
	
	 //Add & PrintList Test
	 System.out.println("Add Test");
	 SortedDblList personList = new SortedDblList();
	 personList.add(b);
	 personList.add(a);
	 personList.printList();
	 System.out.println("");
	 
	 //Remove Test
	 System.out.println("Remove Test");
	 test.remove(a);
	 test.printList();
	 System.out.println("");
	 
	 //Union Test
	 System.out.println("Union Test");
	 test.union(studentTest).printList();
	 System.out.println("");
	 
	 SortedDblList newList= new SortedDblList();
	 Person c = new Person("person", "three",1203,dob);
	 Person d = new Person("person", "four",1204,dob);
	 newList.add(c);
	 newList.add(d);
	 newList.union(personList).printList();
	 System.out.println("");
	 
	 //Intersection Test
	 System.out.println("Intersection Test");
	 SortedDblList matchList=new SortedDblList();
	 Person cc = new Student("student copy","one",1201,dob,"uga");
	 Person dd= new Student("Student Copy","two",1202,dob,"uga");
	 matchList.add(cc);
	 matchList.add(dd);
	
	 personList.intersection(matchList).printList();
	 System.out.println("");
	 
	 //Index Of Test
	 System.out.println("Index Of Test");
	 System.out.println(test.indexOf(a));
	 System.out.println(test.indexOf(b));
	}
}
