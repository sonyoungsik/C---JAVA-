package �Ե�����_Ƽ�Ϲ���_�ý���;

public class Calculator_Age{
	
	TodayYMD t = new TodayYMD();
	OrderDate o = new OrderDate();
	TicketPriceList p = new TicketPriceList();
	
	public static int calAge;
	public static int generation;
	public static int price;
	
public void calAgeFromTodayYMD(){ //���� ��¥ �������� ������ ��� 
	calAge = (t.todayYMD - (o.idNumber)) / 10000;	
	if((o.backIdNumber == 1) || (o.backIdNumber == 2)){   // �ֹε�Ϲ�ȣ ���ڸ� 1 �Ǵ� 2�� ��� �߰� ���
			calAge = calAge + 100;
	}
}

public void calGeneration(){ // ���̺� ���� ����
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

public void calDistributePriceFromTicketSelect(){ //���� ��� ���̿� ���� ���� �Ҵ� (��ũ�̿��, �����̿�� ���� ��, �� ���̴뺰 ���� �Ҵ�) 
	switch(o.ticketSelect){
		case 1 :                            // ��ũ�̿��(1��) 
			if(generation == 1){
				price = p.FREE;
			}else if(generation == 2){
				price = p.BABY_DAY;
			}else if(generation == 3){
				price = p.CHILD_DAY;
			}else if(generation == 4){
				price = p.TEEN_DAY;
			}else if(generation == 5){
				price = p.ADULT_DAY;
			}else{
				price = p.CHILD_DAY;
			}
			break;
		case 2 :                            // ��ũ�̿��(���� 4��~) 
			if(generation == 1){
				price = p.FREE;
			}else if(generation == 2){
				price = p.BABY_AFTER;
			}else if(generation == 3){
				price = p.CHILD_AFTER;
			}else if(generation == 4){
				price = p.TEEN_AFTER;
			}else if(generation == 5){
				price = p.ADULT_AFTER;
			}else{
				price = p.CHILD_AFTER;
			} 
			break;
			
		case 3 :                            // �����̿��(1��) 
			if(generation == 1){
				price = p.FREE;
			}else if(generation == 2){
				price = p.BABY_DAY_TOTAL;
			}else if(generation == 3){
				price = p.CHILD_DAY_TOTAL;
			}else if(generation == 4){
				price = p.TEEN_DAY_TOTAL;
			}else if(generation == 5){
				price = p.ADULT_DAY_TOTAL;
			}else{
				price = p.CHILD_DAY_TOTAL;
			}
			break;
			
		case 4 :                            // �����̿��(���� 4��~) 
			if(generation == 1){
				price = p.FREE;
			}else if(generation == 2){
				price = p.BABY_AFTER_TOTAL;
			}else if(generation == 3){
				price = p.CHILD_AFTER_TOTAL;
			}else if(generation == 4){
				price = p.TEEN_AFTER_TOTAL;
			}else if(generation == 5){
				price = p.ADULT_AFTER_TOTAL;
			}else{
				price = p.CHILD_AFTER_TOTAL;
			}
			break;
	}
}

}