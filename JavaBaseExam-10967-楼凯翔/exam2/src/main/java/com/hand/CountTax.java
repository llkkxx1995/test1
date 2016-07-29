package com.hand;

public class CountTax {

	public static double countTax(int salary){
		double result;
		if(salary<=3500){
			result = 0;
		}else{
			salary = salary -3500;
			if(salary<=1500){
			result = salary*0.03;
		}else if(salary>1500 && salary<=4500){
			result = 1500*0.3+(salary-1500)*0.1;
		}else if(salary>4500 && salary<=9000){
			result = 1500*0.3+3000*0.1+(salary-4500)*0.2;
		}else if(salary>9000 && salary<=35000){
			result = 1500*0.3+3000*0.1+4500*0.2+(salary-9000)*0.25;
		}else if(salary>35000 && salary<=55000){
			result = 1500*0.3+3000*0.1+4500*0.2+26000*0.25+(salary-35000)*0.3;
		}else if(salary>55000 && salary<=80000){
			result = 1500*0.3+3000*0.1+4500*0.2+26000*0.25+20000*0.3+(salary-55000)*0.35;
		}else{
			result = 1500*0.3+3000*0.1+4500*0.2+26000*0.25+20000*0.3+25000*0.35+(salary-80000)*0.45;
		}
	}
		
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String salaryStr = args[0];
        int salary = Integer.parseInt(salaryStr);
        System.out.println("输入的工资为："+salary);
        double tax = CountTax.countTax(salary);
        System.out.println("所要缴纳的税款为："+tax);
	}

}