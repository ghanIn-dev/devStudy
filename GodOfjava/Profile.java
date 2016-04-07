
public class Profile{
	
	String name="간석현";
	int age=10;
	
	public static void main(String[] args){
		
		
		Profile profile = new Profile();
		
		profile.printName();
		profile.setName("김연아 ");
		
		profile.printName();
			
	}
	
	
	public void setName(String str){
		
		name=str;
	}
	
	public void setAge(int val){
		
		age=val;
	}
	
	public void printName(){
		
		System.out.println(name);
		
	}
	
	
	
}