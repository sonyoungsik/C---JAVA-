package �Ե�����_Ƽ�Ϲ���_�ý���;

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
		
			System.out.printf("\n ***** ������ %d���Դϴ�. *****\n", calculate.totalDiscountPrice);
			System.out.printf("\n ��� �߱� �Ͻðڽ��ϱ�? \n 1. Ƽ�� �߱�\n 2. ����\n");
			
			again = sc.nextInt();
				
			calculate.orderList[calculate.add_addCount][0] = input.ticketSelect;   // �̿�� ���� 
			calculate.orderList[calculate.add_addCount][1] = calculate.generation;  // ���� 
			calculate.orderList[calculate.add_addCount][2] = input.orderCount;  // ���ż��� 
			calculate.orderList[calculate.add_addCount][3] = calculate.totalDiscountPrice;  // ���� �ݾ� 
			calculate.orderList[calculate.add_addCount][4] = input.discount;   // ������ 
				
			calculate.add_addCount++;
				
		}while(again == 1);
	
	System.out.printf("\n�����մϴ�.\n\n");
	System.out.printf("====================================�Ե�����======================================\n\n");
			
	calculate.calSummary();		
			
	System.out.printf("\n����� �Ѿ��� %d�� �Դϴ�.\n\n", totalDiscountPriceFinal);
	System.out.printf("================================================================================\n\n");
	System.out.printf("��� ����(1: ���ο� �ֹ�, 2: ���α׷� ����) : ");

	againFinal = sc.nextInt();
	System.out.printf("\n");		

	}while(againFinal == 1);
}

}