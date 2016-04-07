
public class ManageHeight {

	int[][]gradeHeights;
	
	public static void main(String[] args){
		
		ManageHeight height = new ManageHeight();
		
		height.setDate();
	
		for(int classNum=1; classNum<6; classNum++){
		
			height.printHeight(classNum);
			
		}
		
		
	}
	
	public void setDate(){
		
		gradeHeights =new int[][] {{170,180,173,175,177},{160,165,167,186},{158,177,187,176},{173,182,181},{170,180,165,177,172}};
		
	}
	
	
	public void printHeight(int classNo){
		
		System.out.println(classNo);
		
			for(int temp:gradeHeights[classNo-1])
			{
				System.out.println(temp);
			}
		
		
	}
	
}
