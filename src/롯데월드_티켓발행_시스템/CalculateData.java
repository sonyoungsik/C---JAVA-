package �Ե�����_Ƽ�Ϲ���_�ý���;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalculateData {
	
	StaticData fix = new StaticData();
	InputData input = new InputData();
	
	public int year;
	public int month;
	public int day;
	public int todayYMD;
	
	public int calAge;
	public int generation;
	public int price;
	
	public int countPrice;
	public int countPriceYesdiscount;
	public int countPriceNodiscount;
	public int discountPrice;
	public int totalDiscountPrice;
	
	public int add_addCount;
	public int[][] orderList = new int[10000][5];

void calTodayYMD(){ // ���� ��¥ ��� + ������ ����

	Calendar calendar = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("YYMMdd");
	int today = Integer.parseInt(sdf.format(calendar.getTime()));
	year = (today / 10000);
	month = (today / 100) % 100;
	day = (today % 100);
	todayYMD = year *10000 +  month *100 +  + day;
	}

void calAgeFromTodayYMD(){ //���� ��¥ �������� ������ ��� 
	calAge = (todayYMD - (input.idNumber)) / 10000;	
	if((input.backIdNumber == 1) || (input.backIdNumber == 2)){   // �ֹε�Ϲ�ȣ ���ڸ� 1 �Ǵ� 2�� ��� �߰� ���
			calAge = calAge + 100;
	}
}

void calGeneration(){ // ���̺� ���� ����
	if(calAge < 1){						                //���� ������ 1�� �̸�
		generation = 1;
	}else if((calAge >= 1) && (calAge < 3)){	        //���� ������ 1 ~ 3�� �̸� 
		generation = 2;
	}else if((calAge >= 3) && (calAge < 13)){	        //���� ������ 3 ~ 13�� �̸� 
		generation = 3;
	}else if((calAge >= 13) && (calAge < 18)){	        //���� ������ 13 ~ 18�� �̸� 
		generation = 4;
	}else if((calAge >= 19) && (calAge < 65)){	        //���� ������ 19 ~ 65�� �̸� 
		generation = 5;
	}else if(calAge >= 65){						        //���� 65�� �̻�~ 
		generation = 6;
	}
}

void calDistributePriceFromTicketSelect(){ //���� ��� ���̿� ���� ���� �Ҵ� (��ũ�̿��, �����̿�� ���� ��, �� ���̴뺰 ���� �Ҵ�) 
	switch(input.ticketSelect){
		case 1 :                            // ��ũ�̿��(1��) 
			if(generation == 1){
				price = fix.FREE;
			}else if(generation == 2){
				price = fix.BABY_DAY;
			}else if(generation == 3){
				price = fix.CHILD_DAY;
			}else if(generation == 4){
				price = fix.TEEN_DAY;
			}else if(generation == 5){
				price = fix.ADULT_DAY;
			}else{
				price = fix.CHILD_DAY;
			}
			break;
		case 2 :                            // ��ũ�̿��(���� 4��~) 
			if(generation == 1){
				price = fix.FREE;
			}else if(generation == 2){
				price = fix.BABY_AFTER;
			}else if(generation == 3){
				price = fix.CHILD_AFTER;
			}else if(generation == 4){
				price = fix.TEEN_AFTER;
			}else if(generation == 5){
				price = fix.ADULT_AFTER;
			}else{
				price = fix.CHILD_AFTER;
			} 
			break;
			
		case 3 :                            // �����̿��(1��) 
			if(generation == 1){
				price = fix.FREE;
			}else if(generation == 2){
				price = fix.BABY_DAY_TOTAL;
			}else if(generation == 3){
				price = fix.CHILD_DAY_TOTAL;
			}else if(generation == 4){
				price = fix.TEEN_DAY_TOTAL;
			}else if(generation == 5){
				price = fix.ADULT_DAY_TOTAL;
			}else{
				price = fix.CHILD_DAY_TOTAL;
			}
			break;
			
		case 4 :                            // �����̿��(���� 4��~) 
			if(generation == 1){
				price = fix.FREE;
			}else if(generation == 2){
				price = fix.BABY_AFTER_TOTAL;
			}else if(generation == 3){
				price = fix.CHILD_AFTER_TOTAL;
			}else if(generation == 4){
				price = fix.TEEN_AFTER_TOTAL;
			}else if(generation == 5){
				price = fix.ADULT_AFTER_TOTAL;
			}else{
				price = fix.CHILD_AFTER_TOTAL;
			}
			break;
	}
}

void calCountPriceWithDiscount(){ // ���̴뺰 ���ݰ� �� ������ ���� ���� Ƽ�ϰ��� ���ϱ�  
	
	if(input.orderCount <= 10){
		countPrice = price * input.orderCount;                                    //1. �� ������ Ƽ�� �ݾ�(1 = 2 + 3) 
		countPriceYesdiscount = countPrice - (price * (input.orderCount - 2));    //2. �� ������ Ƽ�� �ݾ� - ���� �����׺� ����(���� 1�� ���η� �ݿ� ���� ���ؼ�) �ο��� ����Ͽ� �и� 
		countPriceNodiscount = countPrice - (price * 2);                    //3. �� ������ Ƽ�� �ݾ� - ������ ������ ���� ���ϴ� �ο� ����Ͽ� �и� 
	}
}

void calFinalPriceWithDiscount(){
	// �����׺� �������� ����� ���� ���� ���  
			switch(input.discount){
				case 1 :							      //1. ������ ���� - > �� ������ Ƽ�� �ݾ��� ���� �����ؾ� �� �ݾ�		
					discountPrice = countPrice;
					totalDiscountPrice = discountPrice;
					break;
				
				case 2 :						         //2. ����� �� ��  -> �����̿��/��ũ�̿�� ���� +  ����1�α��� 50% ���� 
				if(input.orderCount >= 3){
					discountPrice = countPriceNodiscount;
					if((input.ticketSelect == 1) || (input.ticketSelect == 2) || (input.ticketSelect == 3) || (input.ticketSelect == 4)){
						totalDiscountPrice = (int)(discountPrice + countPriceYesdiscount * 0.5); 	
					}
				}else{
					discountPrice = (int) (countPrice * 0.5);
					totalDiscountPrice = discountPrice;
				}	
					break;					
				
				case 3 :									//3. ���������� �� ��  -> �����̿��/��ũ�̿�� ���� +  ����1�α��� 50% ���� 
					if(input.orderCount >= 3){
					discountPrice = countPriceNodiscount;
					if((input.ticketSelect == 1) || (input.ticketSelect == 2) || (input.ticketSelect == 3) || (input.ticketSelect == 4)){
						totalDiscountPrice = (int)(discountPrice + countPriceYesdiscount * 0.5);
					}
				}else{
					discountPrice = (int)(countPrice * 0.5);
					totalDiscountPrice = discountPrice;
				}	
					break;
					
				case 4 :									//4. �ް��庴 �� ��  -> �����̿��  ���� +  ����1�α��� 49% ���� 
					if(input.orderCount >= 3 && ((input.backIdNumber == 1) || (input.backIdNumber == 3))){
						discountPrice = countPriceNodiscount;
						if((input.ticketSelect == 3) || (input.ticketSelect == 4)){
							totalDiscountPrice = (int) (discountPrice + countPriceYesdiscount * 0.51); 	
						}else{
							discountPrice = countPrice;
							totalDiscountPrice = discountPrice;
						}
					}else{
						if((input.ticketSelect == 3) || (input.ticketSelect == 4)){
							discountPrice = (int)(countPrice * 0.51);
							totalDiscountPrice = discountPrice;	
						}else{
							discountPrice = countPrice;
							totalDiscountPrice = discountPrice;
						}
					}
					break;
				
				case 5 :									//5. �ӻ�� �� ��  -> �����̿��  ���θ� 50% ���� 
					if(input.orderCount >= 3 && ((input.backIdNumber == 2) || (input.backIdNumber == 4))){
						discountPrice = countPriceNodiscount + countPriceNodiscount;
						if((input.ticketSelect == 3) || (input.ticketSelect == 4)){
							totalDiscountPrice = (int)(discountPrice + ((countPriceYesdiscount / 2) * 0.5)); 	
						}else{
							discountPrice = countPrice;
							totalDiscountPrice = discountPrice;
						}
					}
					else if(input.orderCount == 2 && ((input.backIdNumber == 2) || (input.backIdNumber == 4))){
						if((input.ticketSelect == 3) || (input.ticketSelect == 4)){
						discountPrice = (int)((countPrice / 2) + (countPrice / 2) * 0.5);
						totalDiscountPrice = discountPrice;
						}else{
							discountPrice = countPrice;
							totalDiscountPrice = discountPrice;
						}
					}else{
						if((input.ticketSelect == 3) || (input.ticketSelect == 4) && ((input.backIdNumber == 2) || (input.backIdNumber == 4))){
							discountPrice = (int) (countPrice * 0.5);
							totalDiscountPrice = discountPrice;
						}else{
							discountPrice = countPrice;
							totalDiscountPrice = discountPrice;
						}
					}
					break;
					
				case 6 :								 	//6. �ٵ��� �ູī�� ���  	-> �����̿�� ���� + ����1�α��� 30% ���� 
					if(input.orderCount >= 3){
						discountPrice = countPriceNodiscount;
						if((input.ticketSelect == 3) || (input.ticketSelect == 4)){
							totalDiscountPrice = (int)(discountPrice + countPriceYesdiscount * 0.7); 	
						}else{
							discountPrice = countPrice;
							totalDiscountPrice = discountPrice;
						}
					}else if(input.orderCount <= 2){
						if((input.ticketSelect == 3) || (input.ticketSelect == 4)){
							discountPrice =(int) (countPrice * 0.7);
							totalDiscountPrice = discountPrice;
						}else{
							discountPrice = countPrice;
							totalDiscountPrice = discountPrice;
						}
					}
					break;	
			}
}

void calSummary(){
	for(int index = 0; index < add_addCount; index++){
		if(orderList[index][0] == 1){
			System.out.printf("��ũ�̿��[1DAY] ");                                                  // ��ũ�̿�� ���� ��� ��º�  
			if(orderList[index][1] == 1 || orderList[index][1] == 2){
				System.out.printf(" ���̺� X %d  %d�� ", orderList[index][2], orderList[index][3]);
				if(orderList[index][4] == 1){
				System.out.printf("* ������� ����\n");
				}else if(orderList[index][4] == 2){
					System.out.printf("* ����� ��� ����\n");
				}else if(orderList[index][4] == 3){
					System.out.printf("* ���������� ��� ����\n");
				}else if(orderList[index][4] == 4){
					System.out.printf("* �ް��庴 ��� ������(�����̿�Ǹ� ����)\n");
				}else if(orderList[index][4] == 5){
					System.out.printf("* �ӻ�� ��� ������(�����̿�Ǹ� ����)\n");
				}else{
					System.out.printf("* �ٵ��� ��� ������(�����̿�Ǹ� ����)\n");
				}
			}else if(orderList[index][1] == 3){
				System.out.printf(" ��� X %d  %d�� ", orderList[index][2], orderList[index][3]);
				if(orderList[index][4] == 1){
					System.out.printf("* ������� ����\n");
				}else if(orderList[index][4] == 2){
					System.out.printf("* ����� ��� ����\n");
				}else if(orderList[index][4] == 3){
					System.out.printf("* ���������� ��� ����\n");
				}else if(orderList[index][4] == 4){
					System.out.printf("* �ް��庴 ��� ������(�����̿�Ǹ� ����)\n");
				}else if(orderList[index][4] == 5){
					System.out.printf("* �ӻ�� ��� ������(�����̿�Ǹ� ����)\n");
				}else{
					System.out.printf("* �ٵ��� ��� ������(�����̿�Ǹ� ����)\n");
				}
			}else if(orderList[index][1] == 4){
				System.out.printf(" û�ҳ� X %d  %d�� ", orderList[index][2], orderList[index][3]);
				if(orderList[index][4] == 1){
					System.out.printf("* ������� ����\n");
				}else if(orderList[index][4] == 2){
					System.out.printf("* ����� ��� ����\n");
				}else if(orderList[index][4] == 3){
					System.out.printf("* ���������� ��� ����\n");
				}else if(orderList[index][4] == 4){
					System.out.printf("* �ް��庴 ��� ������(�����̿�Ǹ� ����)\n");
				}else if(orderList[index][4] == 5){
					System.out.printf("* �ӻ�� ��� ������(�����̿�Ǹ� ����)\n");
				}else{
					System.out.printf("* �ٵ��� ��� ������(�����̿�Ǹ� ����)\n");
				}
			}else if(orderList[index][1] == 5){
				System.out.printf("  ���� X %d  %d�� ", orderList[index][2], orderList[index][3]);
				if(orderList[index][4] == 1){
					System.out.printf("* ������� ����\n");
				}else if(orderList[index][4] == 2){
					System.out.printf("* ����� ��� ����\n");
				}else if(orderList[index][4] == 3){
					System.out.printf("* ���������� ��� ����\n");
				}else if(orderList[index][4] == 4){
					System.out.printf("* �ް��庴 ��� ������(�����̿�Ǹ� ����)\n");
				}else if(orderList[index][4] == 5){
					System.out.printf("* �ӻ�� ��� ������(�����̿�Ǹ� ����)\n");
				}else{
					System.out.printf("* �ٵ��� ��� ������(�����̿�Ǹ� ����)\n");
				}
			}else{
				System.out.printf("  ��� X %d  %d�� ", orderList[index][2], orderList[index][3]);
				if(orderList[index][4] == 1){
					System.out.printf("* ������� ����\n");
				}else if(orderList[index][4] == 2){
					System.out.printf("* ����� ��� ����\n");
				}else if(orderList[index][4] == 3){
					System.out.printf("* ���������� ��� ����\n");
				}else if(orderList[index][4] == 4){
					System.out.printf("* �ް��庴 ��� ������(�����̿�Ǹ� ����)\n");
				}else if(orderList[index][4] == 5){
					System.out.printf("* �ӻ�� ��� ������(�����̿�Ǹ� ����)\n");
				}else{
					System.out.printf("* �ٵ��� ��� ������(�����̿�Ǹ� ����)\n");
				}
			}
		}else if(orderList[index][0] == 2){                                           // ��ũ�̿��[����4��~] ���� ��� ��º�  
			System.out.printf("��ũ�̿��[After4] ");
			if(orderList[index][1] == 1 || orderList[index][1] == 2){
				System.out.printf("���̺� X %d  %d�� ", orderList[index][2], orderList[index][3]);
				if(orderList[index][4] == 1){
					System.out.printf("* ������� ����\n");
				}else if(orderList[index][4] == 2){
					System.out.printf("* ����� ��� ����\n");
				}else if(orderList[index][4] == 3){
					System.out.printf("* ���������� ��� ����\n");
				}else if(orderList[index][4] == 4){
					System.out.printf("* �ް��庴 ��� ������(�����̿�Ǹ� ����)\n");
				}else if(orderList[index][4] == 5){
					System.out.printf("* �ӻ�� ��� ������(�����̿�Ǹ� ����)\n");
				}else{
					System.out.printf("* �ٵ��� ��� ������(�����̿�Ǹ� ����)\n");
				}
			}else if(orderList[index][1] == 3){
				System.out.printf("��� X %d  %d�� ", orderList[index][2], orderList[index][3]);
				if(orderList[index][4] == 1){
					System.out.printf("* ������� ����\n");
				}else if(orderList[index][4] == 2){
					System.out.printf("* ����� ��� ����\n");
				}else if(orderList[index][4] == 3){
					System.out.printf("* ���������� ��� ����\n");
				}else if(orderList[index][4] == 4){
					System.out.printf("* �ް��庴 ��� ������(�����̿�Ǹ� ����)\n");
				}else if(orderList[index][4] == 5){
					System.out.printf("* �ӻ�� ��� ������(�����̿�Ǹ� ����)\n");
				}else{
					System.out.printf("* �ٵ��� ��� ������(�����̿�Ǹ� ����)\n");
				}
			}else if(orderList[index][1] == 4){
				System.out.printf("û�ҳ� X %d  %d�� ", orderList[index][2], orderList[index][3]);
				if(orderList[index][4] == 1){
					System.out.printf("* ������� ����\n");
				}else if(orderList[index][4] == 2){
					System.out.printf("* ����� ��� ����\n");
				}else if(orderList[index][4] == 3){
					System.out.printf("* ���������� ��� ����\n");
				}else if(orderList[index][4] == 4){
					System.out.printf("* �ް��庴 ��� ������(�����̿�Ǹ� ����)\n");
				}else if(orderList[index][4] == 5){
					System.out.printf("* �ӻ�� ��� ������(�����̿�Ǹ� ����)\n");
				}else{
					System.out.printf("* �ٵ��� ��� ������(�����̿�Ǹ� ����)\n");
				}
			}else if(orderList[index][1] == 5){
				System.out.printf("���� X %d  %d�� ", orderList[index][2], orderList[index][3]);
				if(orderList[index][4] == 1){
					System.out.printf("* ������� ����\n");
				}else if(orderList[index][4] == 2){
					System.out.printf("* ����� ��� ����\n");
				}else if(orderList[index][4] == 3){
					System.out.printf("* ���������� ��� ����\n");
				}else if(orderList[index][4] == 4){
					System.out.printf("* �ް��庴 ��� ������(�����̿�Ǹ� ����)\n");
				}else if(orderList[index][4] == 5){
					System.out.printf("* �ӻ�� ��� ������(�����̿�Ǹ� ����)\n");
				}else{
					System.out.printf("* �ٵ��� ��� ������(�����̿�Ǹ� ����)\n");
				}
			}else{
				System.out.printf("��� X %d  %d�� ", orderList[index][2], orderList[index][3]);
				if(orderList[index][4] == 1){
					System.out.printf("* ������� ����\n");
				}else if(orderList[index][4] == 2){
					System.out.printf("* ����� ��� ����\n");
				}else if(orderList[index][4] == 3){
					System.out.printf("* ���������� ��� ����\n");
				}else if(orderList[index][4] == 4){
					System.out.printf("* �ް��庴 ��� ������(�����̿�Ǹ� ����)\n");
				}else if(orderList[index][4] == 5){
					System.out.printf("* �ӻ�� ��� ������(�����̿�Ǹ� ����)\n");
				}else{
					System.out.printf("* �ٵ��� ��� ������(�����̿�Ǹ� ����)\n");
				}
			}
		}else if(orderList[index][0] == 3){                                           // �����̿�� ���� ��� ��º�  
			System.out.printf("�����̿��[1DAY] ");
			if(orderList[index][1] == 1 || orderList[index][1] == 2){
				System.out.printf(" ���̺� X %d  %d�� ", orderList[index][2], orderList[index][3]);
				if(orderList[index][4] == 1){
					System.out.printf("* ������� ����\n");
				}else if(orderList[index][4] == 2){
					System.out.printf("* ����� ��� ����\n");
				}else if(orderList[index][4] == 3){
					System.out.printf("* ���������� ��� ����\n");
				}else if(orderList[index][4] == 4){
					System.out.printf("* �ް��庴 ��� ����\n");
				}else if(orderList[index][4] == 5){
					System.out.printf("* �ӻ�� ��� ����\n");
				}else{
					System.out.printf("* �ٵ��� ��� ����\n");
				}
			}else if(orderList[index][1] == 3){
				System.out.printf(" ��� X %d  %d�� ", orderList[index][2], orderList[index][3]);
				if(orderList[index][4] == 1){
					System.out.printf("* ������� ����\n");
				}else if(orderList[index][4] == 2){
					System.out.printf("* ����� ��� ����\n");
				}else if(orderList[index][4] == 3){
					System.out.printf("* ���������� ��� ����\n");
				}else if(orderList[index][4] == 4){
					System.out.printf("* �ް��庴 ��� ����\n");
				}else if(orderList[index][4] == 5){
					System.out.printf("* �ӻ�� ��� ����\n");
				}else{
					System.out.printf("* �ٵ��� ��� ����\n");
				}
			}else if(orderList[index][1] == 4){
				System.out.printf(" û�ҳ� X %d  %d�� ", orderList[index][2], orderList[index][3]);
				if(orderList[index][4] == 1){
					System.out.printf("* ������� ����\n");
				}else if(orderList[index][4] == 2){
					System.out.printf("* ����� ��� ����\n");
				}else if(orderList[index][4] == 3){
					System.out.printf("* ���������� ��� ����\n");
				}else if(orderList[index][4] == 4){
					System.out.printf("* �ް��庴 ��� ����\n");
				}else if(orderList[index][4] == 5){
					System.out.printf("* �ӻ�� ��� ����\n");
				}else{
					System.out.printf("* �ٵ��� ��� ����\n");
				}
			}else if(orderList[index][1] == 5){
				System.out.printf("  ���� X %d  %d�� ", orderList[index][2], orderList[index][3]);
				if(orderList[index][4] == 1){
					System.out.printf("* ������� ����\n");
				}else if(orderList[index][4] == 2){
					System.out.printf("* ����� ��� ����\n");
				}else if(orderList[index][4] == 3){
					System.out.printf("* ���������� ��� ����\n");
				}else if(orderList[index][4] == 4){
					System.out.printf("* �ް��庴 ��� ����\n");
				}else if(orderList[index][4] == 5){
					System.out.printf("* �ӻ�� ��� ����\n");
				}else{
					System.out.printf("* �ٵ��� ��� ����\n");
				}
			}else{
				System.out.printf("  ��� X %d  %d�� ", orderList[index][2], orderList[index][3]);
				if(orderList[index][4] == 1){
					System.out.printf("* ������� ����\n");
				}else if(orderList[index][4] == 2){
					System.out.printf("* ����� ��� ����\n");
				}else if(orderList[index][4] == 3){
					System.out.printf("* ���������� ��� ����\n");
				}else if(orderList[index][4] == 4){
					System.out.printf("* �ް��庴 ��� ����\n");
				}else if(orderList[index][4] == 5){
					System.out.printf("* �ӻ�� ��� ����\n");
				}else{
					System.out.printf("* �ٵ��� ��� ����\n");
				}
			}
		}else{                                                                        // �����̿��[���� 4��~] ���� ��� ��º�  
			System.out.printf("�����̿��[After4] ");
			if(orderList[index][1] == 1 || orderList[index][1] == 2){
				System.out.printf("���̺� X %d  %d�� ", orderList[index][2], orderList[index][3]);
				if(orderList[index][4] == 1){
					System.out.printf("* ������� ����\n");
				}else if(orderList[index][4] == 2){
					System.out.printf("* ����� ��� ����\n");
				}else if(orderList[index][4] == 3){
					System.out.printf("* ���������� ��� ����\n");
				}else if(orderList[index][4] == 4){
					System.out.printf("* �ް��庴 ��� ����\n");
				}else if(orderList[index][4] == 5){
					System.out.printf("* �ӻ�� ��� ����\n");
				}else{
					System.out.printf("* �ٵ��� ��� ����\n");
				}
			}else if(orderList[index][1] == 3){
				System.out.printf("��� X %d  %d�� ", orderList[index][2], orderList[index][3]);
				if(orderList[index][4] == 1){
					System.out.printf("* ������� ����\n");
				}else if(orderList[index][4] == 2){
					System.out.printf("* ����� ��� ����\n");
				}else if(orderList[index][4] == 3){
					System.out.printf("* ���������� ��� ����\n");
				}else if(orderList[index][4] == 4){
					System.out.printf("* �ް��庴 ��� ����\n");
				}else if(orderList[index][4] == 5){
					System.out.printf("* �ӻ�� ��� ����\n");
				}else{
					System.out.printf("* �ٵ��� ��� ����\n");
				}
			}else if(orderList[index][1] == 4){
				System.out.printf("û�ҳ� X %d  %d�� ", orderList[index][2], orderList[index][3]);
				if(orderList[index][4] == 1){
					System.out.printf("* ������� ����\n");
				}else if(orderList[index][4] == 2){
					System.out.printf("* ����� ��� ����\n");
				}else if(orderList[index][4] == 3){
					System.out.printf("* ���������� ��� ����\n");
				}else if(orderList[index][4] == 4){
					System.out.printf("* �ް��庴 ��� ����\n");
				}else if(orderList[index][4] == 5){
					System.out.printf("* �ӻ�� ��� ����\n");
				}else{
					System.out.printf("* �ٵ��� ��� ����\n");
				}
			}else if(orderList[index][1] == 5){
				System.out.printf("���� X %d  %d�� ", orderList[index][2], orderList[index][3]);
				if(orderList[index][4] == 1){
					System.out.printf("* ������� ����\n");
				}else if(orderList[index][4] == 2){
					System.out.printf("* ����� ��� ����\n");
				}else if(orderList[index][4] == 3){
					System.out.printf("* ���������� ��� ����\n");
				}else if(orderList[index][4] == 4){
					System.out.printf("* �ް��庴 ��� ����\n");
				}else if(orderList[index][4] == 5){
					System.out.printf("* �ӻ�� ��� ����\n");
				}else{
					System.out.printf("* �ٵ��� ��� ����\n");
				}
			}else{
				System.out.printf("��� X %d  %d�� ", orderList[index][2], orderList[index][3]);
				if(orderList[index][4] == 1){
					System.out.printf("* ������� ����\n");
				}else if(orderList[index][4] == 2){
					System.out.printf("* ����� ��� ����\n");
				}else if(orderList[index][4] == 3){
					System.out.printf("* ���������� ��� ����\n");
				}else if(orderList[index][4] == 4){
					System.out.printf("* �ް��庴 ��� ����\n");
				}else if(orderList[index][4] == 5){
					System.out.printf("* �ӻ�� ��� ����\n");
				}else{
					System.out.printf("* �ٵ��� ��� ����\n");
				}
			}
		}
	}
}

}