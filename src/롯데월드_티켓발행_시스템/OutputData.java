package 롯데월드_티켓발행_시스템;

import java.util.Scanner;

public class OutputData {
	
	Scanner sc = new Scanner(System.in);
	
	InputData input = new InputData();
	CalculateData calculate = new CalculateData();
	
	public int totalDiscountPriceFinal;
	public int again;
	public int againFinal;
	
void ticketProcessFinal(){

	do{
		do{
			calculate.calTodayYMD();
			input.calTicketSelect();
			input.calIdNumber();
			input.calBackIdNumber();
			input.calMaxTicketSelect();
			input.calDiscount();
			calculate.calAgeFromTodayYMD();
			calculate.calGeneration();
			calculate.calDistributePriceFromTicketSelect();
			calculate.calCountPriceWithDiscount();
			calculate.calFinalPriceWithDiscount();
			
			System.out.println(input.orderCount);
			
			totalDiscountPriceFinal += calculate.totalDiscountPrice;
		
			System.out.printf("\n ***** 가격은 %d원입니다. *****\n", calculate.totalDiscountPrice);
			System.out.printf("\n 계속 발권 하시겠습니까? \n 1. 티켓 발권\n 2. 종료\n");
			
			again = sc.nextInt();
				
			calculate.orderList[calculate.add_addCount][0] = input.ticketSelect;   // 이용권 종류 
			calculate.orderList[calculate.add_addCount][1] = calculate.generation;  // 나이 
			calculate.orderList[calculate.add_addCount][2] = input.orderCount;  // 구매수량 
			calculate.orderList[calculate.add_addCount][3] = calculate.totalDiscountPrice;  // 지불 금액 
			calculate.orderList[calculate.add_addCount][4] = input.discount;   // 우대사항 
				
			calculate.add_addCount++;
				
		}while(again == 1);
	
	System.out.printf("\n감사합니다.\n\n");
	System.out.printf("====================================롯데월드======================================\n\n");
			
	calculate.calSummary();		
			
	System.out.printf("\n입장료 총액은 %d원 입니다.\n\n", totalDiscountPriceFinal);
	System.out.printf("================================================================================\n\n");
	System.out.printf("계속 진행(1: 새로운 주문, 2: 프로그램 종료) : ");

	againFinal = sc.nextInt();
	System.out.printf("\n");		

	}while(againFinal == 1);
}

}