package 롯데월드_티켓발행_시스템;

public class Calculator_Age{
	
	TodayYMD t = new TodayYMD();
	OrderDate o = new OrderDate();
	TicketPriceList p = new TicketPriceList();
	
	public static int calAge;
	public static int generation;
	public static int price;
	
public void calAgeFromTodayYMD(){ //현재 날짜 기준으로 만나이 계산 
	calAge = (t.todayYMD - (o.idNumber)) / 10000;	
	if((o.backIdNumber == 1) || (o.backIdNumber == 2)){   // 주민등록번호 뒷자리 1 또는 2인 경우 추가 고려
			calAge = calAge + 100;
	}
}

public void calGeneration(){ // 나이별 세대 구분
	if(calAge < 1){						                //생후 만나이 1살 미만
		generation = 1;
	}else if((calAge >= 1) && (calAge < 3)){	        //생후 만나이 1 ~ 3살 미만 
		generation = 2;
	}else if((calAge >= 3) && (calAge < 13)){	        //생후 만나이 3 ~ 13살 미만 
		generation = 3;
	}else if((calAge >= 13) && (calAge < 18)){	        //생후 만나이 13 ~ 18세 미만 
		generation = 4;
	}else if((calAge >= 19) && (calAge < 65)){	        //생후 만나이 19 ~ 65세 미만 
		generation = 5;
	}else if(calAge >= 65){						        //생후 65세 이상~ 
		generation = 6;
	}
}

public void calDistributePriceFromTicketSelect(){ //생후 몇개월 나이에 따른 가격 할당 (파크이용권, 종합이용권 구분 후, 각 나이대별 가격 할당) 
	switch(o.ticketSelect){
		case 1 :                            // 파크이용권(1일) 
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
		case 2 :                            // 파크이용권(오후 4시~) 
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
			
		case 3 :                            // 종합이용권(1일) 
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
			
		case 4 :                            // 종합이용권(오후 4시~) 
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