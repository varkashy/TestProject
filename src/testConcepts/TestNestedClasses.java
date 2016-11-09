package testConcepts;

public class TestNestedClasses {

	public int x=10;
	private int y=15;
	private static String encloseStr="String in enclosing class";
	private void sayX()
	{
		System.out.println(x);
	}
	public void sayY()
	{
		System.out.println(y);
	}
	public static class NestedClass1{
		String classType="I am a static nested class";
		
		void sayClassType()
		{
			System.out.println(classType);
			//sayY(); 
			/* Cannot make this call as sayY() is non static. 
			* Since class is static it can only invoke static methods.
			*/
			//System.out.println(y);
			/*
			 * Same reason as above
			 */
			System.out.println(new TestNestedClasses().x);
		}
		
		static void sayClassType2()
		{
			System.out.println("Can declare static methods in static inner class");
		}
		
	}
	
	class InnerClass1{
		String classType="I am a non-static inner class";
		/*public static void callClasstype()
		{
			
		}
		* Cannot declare static methods in an inner class
		*/
		// static int xInner=10; same as above
		static final int xInner=10; // This is allowed 
		public  void callClasstype()
		{
			System.out.print(classType);
			System.out.println(x);
			System.out.println(y);
			System.out.println(encloseStr);
		}
	}
	public void testNestedClassesFlow()
	{
		TestNestedClasses obj=new TestNestedClasses();
		System.out.print(obj.x);
		System.out.print(obj.y);
		obj.sayX();
		obj.sayY();
		System.out.println(TestNestedClasses.InnerClass1.xInner);// This will work
		new InnerClass1().callClasstype();
		NestedClass1 nestedObj1=new NestedClass1();
		nestedObj1.sayClassType();
	}
	public static void main(String args[])
	{
		TestNestedClasses obj=new TestNestedClasses();
		obj.testNestedClassesFlow();
	}
}
