package �Ե�����_Ƽ�Ϲ���_�ý���;

import java.util.Scanner;

public class OrderDate {

	Scanner sc = new Scanner(System.in);
	
	public static int ticketSelect;
	public static int idNumber;
	public static int backIdNumber;
	public static int orderCount;
	public static int discount;
	
public void calTicketSelect(){ //���� �����ϱ�  
	
		do{ 
			System.out.printf("������ �����ϼ���.(After4�� ���� 4�ú��� ����)\n");
			System.out.printf("\n1. ��ũ�̿�� [1DAY]\n2. ��ũ�̿�� [After4]\n3. �����̿�� [1DAY]\n4. �����̿�� [After4]\n");
			ticketSelect = sc.nextInt();
			if(!(ticketSelect == 1 || ticketSelect == 2 || ticketSelect == 3 || ticketSelect == 4 )){
				System.out.printf("\n �߸��Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.\n\n");
			}
		}while (!(ticketSelect == 1 || ticketSelect == 2 || ticketSelect == 3 || ticketSelect == 4 ));
}
	
public void calIdNumber(){ //�ֹε�Ϲ�ȣ �Է� �� 6���� ���ϱ� 
	
		do{ 
			System.out.printf("\n�ֹι�ȣ �� 6���ڸ� �Է��ϼ���\n");
			idNumber = sc.nextInt();			
			if(!((idNumber >= 000101) && (idNumber <= 991231))){
				System.out.printf("\n �߸��Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.\n\n");
				}
		}while (!((idNumber >= 000101) && (idNumber <= 991231)));
}

public void calBackIdNumber(){ //�ֹε�Ϲ�ȣ �Է� �� 1�ڸ� ���ϱ� 
	
	do{ 
		System.out.printf("\n�ֹι�ȣ �� 1���ڸ� �Է��ϼ���\n");
		backIdNumber = sc.nextInt();
		if(!(backIdNumber == 1 || backIdNumber == 2 || backIdNumber == 3 || backIdNumber == 4 )){
			System.out.printf("\n �߸��Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.\n\n");
		}				
	}while(!(backIdNumber == 1 || backIdNumber == 2 || backIdNumber == 3 || backIdNumber == 4 ));
}

public void calMaxTicketSelect(){ //Ƽ�� �߱� ���� (��10�� ����)
	
	do{
		System.out.printf("\n��� �ֹ��Ͻðڽ��ϱ�? (�ִ� 10��)\n");
		orderCount = sc.nextInt();
		if(orderCount > 10){
			System.out.printf("\n �߸��Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.\n\n");
		}
	}while(orderCount > 10);
}

public void calDiscount(){ //���� ���� ������(5����) 
		
	do{
		System.out.printf("\n�������� �����ϼ���.\n1. ����(���� ���� �ڵ�ó��)\n2. �����\n3. ����������\n4. �ް��庴\n5. �ӻ��\n6. �ٵ���\n");
		discount = sc.nextInt();
		if(!(discount == 1 || discount == 2 || discount == 3 || discount == 4 || discount == 5 || discount == 6)){
			System.out.printf("\n �߸��Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.\n\n");
		}
	}while (!(discount == 1 || discount == 2 || discount == 3 || discount == 4 || discount == 5 || discount == 6));
}

}