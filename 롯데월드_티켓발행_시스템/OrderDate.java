package 롯데월드_티켓발행_시스템;

import java.util.Scanner;

public class OrderDate {

	Scanner sc = new Scanner(System.in);
	
	public static int ticketSelect;
	public static int idNumber;
	public static int backIdNumber;
	public static int orderCount;
	public static int discount;
	
public void calTicketSelect(){ //권종 선택하기  
	
		do{ 
			System.out.printf("권종을 선택하세요.(After4는 오후 4시부터 입장)\n");
			System.out.printf("\n1. 파크이용권 [1DAY]\n2. 파크이용권 [After4]\n3. 종합이용권 [1DAY]\n4. 종합이용권 [After4]\n");
			ticketSelect = sc.nextInt();
			if(!(ticketSelect == 1 || ticketSelect == 2 || ticketSelect == 3 || ticketSelect == 4 )){
				System.out.printf("\n 잘못입력하셨습니다. 다시 입력해주세요.\n\n");
			}
		}while (!(ticketSelect == 1 || ticketSelect == 2 || ticketSelect == 3 || ticketSelect == 4 ));
}
	
public void calIdNumber(){ //주민등록번호 입력 앞 6글자 구하기 
	
		do{ 
			System.out.printf("\n주민번호 앞 6글자를 입력하세요\n");
			idNumber = sc.nextInt();			
			if(!((idNumber >= 000101) && (idNumber <= 991231))){
				System.out.printf("\n 잘못입력하셨습니다. 다시 입력해주세요.\n\n");
				}
		}while (!((idNumber >= 000101) && (idNumber <= 991231)));
}

public void calBackIdNumber(){ //주민등록번호 입력 뒷 1자리 구하기 
	
	do{ 
		System.out.printf("\n주민번호 뒤 1글자를 입력하세요\n");
		backIdNumber = sc.nextInt();
		if(!(backIdNumber == 1 || backIdNumber == 2 || backIdNumber == 3 || backIdNumber == 4 )){
			System.out.printf("\n 잘못입력하셨습니다. 다시 입력해주세요.\n\n");
		}				
	}while(!(backIdNumber == 1 || backIdNumber == 2 || backIdNumber == 3 || backIdNumber == 4 ));
}

public void calMaxTicketSelect(){ //티켓 발급 개수 (총10개 제한)
	
	do{
		System.out.printf("\n몇개를 주문하시겠습니까? (최대 10개)\n");
		orderCount = sc.nextInt();
		if(orderCount > 10){
			System.out.printf("\n 잘못입력하셨습니다. 다시 입력해주세요.\n\n");
		}
	}while(orderCount > 10);
}

public void calDiscount(){ //할인 관련 우대사항(5가지) 
		
	do{
		System.out.printf("\n우대사항을 선택하세요.\n1. 없음(나이 우대는 자동처리)\n2. 장애인\n3. 국가유공자\n4. 휴가장병\n5. 임산부\n6. 다둥이\n");
		discount = sc.nextInt();
		if(!(discount == 1 || discount == 2 || discount == 3 || discount == 4 || discount == 5 || discount == 6)){
			System.out.printf("\n 잘못입력하셨습니다. 다시 입력해주세요.\n\n");
		}
	}while (!(discount == 1 || discount == 2 || discount == 3 || discount == 4 || discount == 5 || discount == 6));
}

}