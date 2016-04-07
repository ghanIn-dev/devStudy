
public class ManageStudent {

	public static void main(String[] args) {


		Student[] student = null ;
		
		ManageStudent manageStudent = new ManageStudent();
		
		student = manageStudent.addStudent();
		
		manageStudent.printStudents(student);
	}

	
	
	public Student[] addStudent(){
		
		Student[] student  = new Student[3];
		student[0] = new Student("Lim");
		student[1] = new Student("Min");
		student[2] = new Student("Sook", "Seoul","01055600433","ask@god.com");
		
		return student;
		
	}
	
	public void printStudents(Student[] student){

		for(Student temp : student){
			
			System.out.println(temp);
		}
		
		
		
	}
	
}
