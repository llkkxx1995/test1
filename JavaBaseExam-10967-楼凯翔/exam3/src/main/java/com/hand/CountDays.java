package com.hand;

public class CountDays {

	public static int[] normalMonthDays = {0,31,28,31,30,31,30,31,31,30,31,30,31};
	public static int[] bisseMonthDays = {0,31,29,31,30,31,30,31,31,30,31,30,31};
	public static int countDays(String date){
		int result = 0;
		
		String yearStr = date.substring(0, 4);
		String monthStr = date.substring(5, 7);
		String dayStr = date.substring(8);
		
		int year = Integer.parseInt(yearStr);
		int month = Integer.parseInt(monthStr);
		int day = Integer.parseInt(dayStr);
		
		//判断是否为闰年
		if((year%100==0&&year%400==0)||(year%100!=0&&year%4==0)){
			for(int i=0; i<month; i++){
		     result = result+bisseMonthDays[i];
			}
		}else{
			for(int i=0; i<month; i++){
				result = result+normalMonthDays[i];
		  }

		}
		result = result + day;
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String date = args[0];
		//String date = "2011-12-31";
       System.out.println("输入的日期为："+date);
       int result = CountDays.countDays(date);
       System.out.println("您输入的日期为当年的第"+result+"天");
	}

}
