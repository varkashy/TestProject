package testConcepts;

import testConcepts.TestNestedClasses.InnerClass1;
import testConcepts.TestNestedClasses.NestedClass1;

public class TestNestedClassClient {

	public static void main(String args[])
	{
		TestNestedClasses obj1=new TestNestedClasses();
		//InnerClass1 inc=new InnerClass1();// This will not work
		InnerClass1 inc=obj1.new InnerClass1();// This will work 
		NestedClass1 obj2=new NestedClass1();
		obj1.testNestedClassesFlow();
		obj2.sayClassType();
	}
}
