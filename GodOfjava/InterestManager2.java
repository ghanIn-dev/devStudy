
public class InterestManager2 {

	
	double rate;
	
	public static void main(String [] args){
	
		InterestManager2 interestManager2 = new InterestManager2();
		
		for (int day=1; day<366; day++){
		System.out.println(interestManager2.calculateAmount(day, 100)); 
		}
	}
	
	
	
	public double getInterestRate(int day){
		
		
		if(day>=1 && day<=90){
			
			rate=rate*0.5;
			
		}
		
		else if(day>=91 && day<=180){
			
			rate=rate*1;
			
		}
		
		else if(day>=181 && day<=364){
			
			rate=rate*2;
			
		}
		
		else if(day>=365){
			
			rate=rate*5.6;
			
		}
		
		return rate;
		
	}
	
	
	public double calculateAmount(int day, long amount){
		
		double rate = getInterestRate(day);
		
		double resultMoney;
		
		resultMoney = rate + amount;
		
		
		return resultMoney;
	
	}
	
	
	
	
}
