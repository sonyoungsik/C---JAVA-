package 롯데월드_티켓발행_시스템;

import java.util.Scanner;

public class Calculator_Final {
	
	TodayYMD t = new TodayYMD();
	OrderDate o = new OrderDate();
	Calculator_Age c = new Calculator_Age();
	CalculatorPriceWithDiscount ca = new CalculatorPriceWithDiscount();
	Calculator_Summary cal = new Calculator_Summary();
		
	public int totalDiscountPriceFinal;
	public int again;
	public int againFinal;
	
public void ticketProcessFinal(){
	Scanner sc = new Scanner(System.in);
	do{
		do{
			t.calTodayYMD();
			o.calTicketSelect();
			o.calIdNumber();
			o.calBackIdNumber();
			o.calMaxTicketSelect();
			o.calDiscount();
			c.calAgeFromTodayYMD();
			c.calGeneration();
			c.calDistributePriceFromTicketSelect();
			ca.calCountPriceWithDiscount();
			ca.calFinalPriceWithDiscount();
			
			totalDiscountPriceFinal += ca.totalDiscountPrice;
		
			System.out.printf("\n ***** 가격은 %d원입니다. *****\n", ca.totalDiscountPrice);
			System.out.printf("\n 계속 발권 하시겠습니까? \n 1. 티켓 발권\n 2. 종료\n");
			
			again = sc.nextInt();
				
			cal.orderList[cal.add_addCount][0] = o.ticketSelect;   // 이용권 종류 
			cal.orderList[cal.add_addCount][1] = c.generation;  // 나이 
			cal.orderList[cal.add_addCount][2] = o.orderCount;  // 구매수량 
			cal.orderList[cal.add_addCount][3] = ca.totalDiscountPrice;  // 지불 금액 
			cal.orderList[cal.add_addCount][4] = o.discount;   // 우대사항 
				
			cal.add_addCount = cal.add_addCount + 1;
				
		}while(again == 1);
	
	System.out.printf("\n감사합니다.\n\n");
	System.out.printf("====================================롯데월드======================================\n\n");
			
	cal.calSummary();		
			
	System.out.printf("\n입장료 총액은 %d원 입니다.\n\n", totalDiscountPriceFinal);
	System.out.printf("================================================================================\n\n");
	System.out.printf("계속 진행(1: 새로운 주문, 2: 프로그램 종료) : ");

	againFinal = sc.nextInt();
	System.out.printf("\n");		

	}while(againFinal == 1);
}

}