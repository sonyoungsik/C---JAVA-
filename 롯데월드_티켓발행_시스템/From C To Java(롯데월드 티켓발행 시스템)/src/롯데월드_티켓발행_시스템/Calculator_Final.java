package �Ե�����_Ƽ�Ϲ���_�ý���;

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
		
			System.out.printf("\n ***** ������ %d���Դϴ�. *****\n", ca.totalDiscountPrice);
			System.out.printf("\n ��� �߱� �Ͻðڽ��ϱ�? \n 1. Ƽ�� �߱�\n 2. ����\n");
			
			again = sc.nextInt();
				
			cal.orderList[cal.add_addCount][0] = o.ticketSelect;   // �̿�� ���� 
			cal.orderList[cal.add_addCount][1] = c.generation;  // ���� 
			cal.orderList[cal.add_addCount][2] = o.orderCount;  // ���ż��� 
			cal.orderList[cal.add_addCount][3] = ca.totalDiscountPrice;  // ���� �ݾ� 
			cal.orderList[cal.add_addCount][4] = o.discount;   // ������ 
				
			cal.add_addCount = cal.add_addCount + 1;
				
		}while(again == 1);
	
	System.out.printf("\n�����մϴ�.\n\n");
	System.out.printf("====================================�Ե�����======================================\n\n");
			
	cal.calSummary();		
			
	System.out.printf("\n����� �Ѿ��� %d�� �Դϴ�.\n\n", totalDiscountPriceFinal);
	System.out.printf("================================================================================\n\n");
	System.out.printf("��� ����(1: ���ο� �ֹ�, 2: ���α׷� ����) : ");

	againFinal = sc.nextInt();
	System.out.printf("\n");		

	}while(againFinal == 1);
}

}