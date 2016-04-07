
public class ProfilePrint {

	
	byte age;
	String name;
	
	boolean isMarried;
	
	public void setAge(byte age){
		
		age = age;
	}
	
	
	public byte getAge(){
		
		return age;
	}
	
	
	public void setName(String name){
		
		name = name;
	}
	
	
	public String getName(){
		
		
		return name;
	}
	
	
	public void setMarried(boolean flag){
		
		
		
	}
	
	
	public boolean isMarried(){
		
		return isMarried;
	}
	
	
	
	public static void main(String[] args){
		
		ProfilePrint profilePrint = new ProfilePrint();
				
		byte age=20;
				
				profilePrint.setAge(age);
				profilePrint.setMarried(false);
				profilePrint.setName("YUME");
				
				
				profilePrint.getAge();
				profilePrint.getName();
				profilePrint.isMarried();
		
		
	}
	
	
	
	
}
