package 롯데월드_티켓발행_시스템;

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

void calTodayYMD(){ // 오늘 날짜 계산 + 연월일 추출

	Calendar calendar = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("YYMMdd");
	int today = Integer.parseInt(sdf.format(calendar.getTime()));
	year = (today / 10000);
	month = (today / 100) % 100;
	day = (today % 100);
	todayYMD = year *10000 +  month *100 +  + day;
	}

void calAgeFromTodayYMD(){ //현재 날짜 기준으로 만나이 계산 
	calAge = (todayYMD - (input.idNumber)) / 10000;	
	if((input.backIdNumber == 1) || (input.backIdNumber == 2)){   // 주민등록번호 뒷자리 1 또는 2인 경우 추가 고려
			calAge = calAge + 100;
	}
}

void calGeneration(){ // 나이별 세대 구분
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

void calDistributePriceFromTicketSelect(){ //생후 몇개월 나이에 따른 가격 할당 (파크이용권, 종합이용권 구분 후, 각 나이대별 가격 할당) 
	switch(input.ticketSelect){
		case 1 :                            // 파크이용권(1일) 
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
		case 2 :                            // 파크이용권(오후 4시~) 
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
			
		case 3 :                            // 종합이용권(1일) 
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
			
		case 4 :                            // 종합이용권(오후 4시~) 
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

void calCountPriceWithDiscount(){ // 나이대별 가격과 총 수량을 곱한 실제 티켓가격 구하기  
	
	if(input.orderCount <= 10){
		countPrice = price * input.orderCount;                                    //1. 총 구매한 티켓 금액(1 = 2 + 3) 
		countPriceYesdiscount = countPrice - (price * (input.orderCount - 2));    //2. 총 구매한 티켓 금액 - 각종 우대사항별 혜택(동반 1인 할인률 반영 등을 위해서) 인원을 고려하여 분리 
		countPriceNodiscount = countPrice - (price * 2);                    //3. 총 구매한 티켓 금액 - 우대사항 혜택을 받지 못하는 인원 고려하여 분리 
	}
}

void calFinalPriceWithDiscount(){
	// 우대사항별 할인율을 고려한 실제 가격 계산  
			switch(input.discount){
				case 1 :							      //1. 우대사항 없음 - > 총 구매한 티켓 금액이 실제 지불해야 할 금액		
					discountPrice = countPrice;
					totalDiscountPrice = discountPrice;
					break;
				
				case 2 :						         //2. 장애인 우 대  -> 종합이용권/파크이용권 본인 +  동반1인까지 50% 할인 
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
				
				case 3 :									//3. 국가유공자 우 대  -> 종합이용권/파크이용권 본인 +  동반1인까지 50% 할인 
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
					
				case 4 :									//4. 휴가장병 우 대  -> 종합이용권  본인 +  동반1인까지 49% 할인 
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
				
				case 5 :									//5. 임산부 우 대  -> 종합이용권  본인만 50% 할인 
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
					
				case 6 :								 	//6. 다둥이 행복카드 우대  	-> 종합이용권 본인 + 동반1인까지 30% 할인 
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
			System.out.printf("파크이용권[1DAY] ");                                                  // 파크이용권 관련 결과 출력분  
			if(orderList[index][1] == 1 || orderList[index][1] == 2){
				System.out.printf(" 베이비 X %d  %d원 ", orderList[index][2], orderList[index][3]);
				if(orderList[index][4] == 1){
				System.out.printf("* 우대적용 없음\n");
				}else if(orderList[index][4] == 2){
					System.out.printf("* 장애인 우대 적용\n");
				}else if(orderList[index][4] == 3){
					System.out.printf("* 국가유공자 우대 적용\n");
				}else if(orderList[index][4] == 4){
					System.out.printf("* 휴가장병 우대 미적용(종합이용권만 가능)\n");
				}else if(orderList[index][4] == 5){
					System.out.printf("* 임산부 우대 미적용(종합이용권만 가능)\n");
				}else{
					System.out.printf("* 다둥이 우대 미적용(종합이용권만 가능)\n");
				}
			}else if(orderList[index][1] == 3){
				System.out.printf(" 어린이 X %d  %d원 ", orderList[index][2], orderList[index][3]);
				if(orderList[index][4] == 1){
					System.out.printf("* 우대적용 없음\n");
				}else if(orderList[index][4] == 2){
					System.out.printf("* 장애인 우대 적용\n");
				}else if(orderList[index][4] == 3){
					System.out.printf("* 국가유공자 우대 적용\n");
				}else if(orderList[index][4] == 4){
					System.out.printf("* 휴가장병 우대 미적용(종합이용권만 가능)\n");
				}else if(orderList[index][4] == 5){
					System.out.printf("* 임산부 우대 미적용(종합이용권만 가능)\n");
				}else{
					System.out.printf("* 다둥이 우대 미적용(종합이용권만 가능)\n");
				}
			}else if(orderList[index][1] == 4){
				System.out.printf(" 청소년 X %d  %d원 ", orderList[index][2], orderList[index][3]);
				if(orderList[index][4] == 1){
					System.out.printf("* 우대적용 없음\n");
				}else if(orderList[index][4] == 2){
					System.out.printf("* 장애인 우대 적용\n");
				}else if(orderList[index][4] == 3){
					System.out.printf("* 국가유공자 우대 적용\n");
				}else if(orderList[index][4] == 4){
					System.out.printf("* 휴가장병 우대 미적용(종합이용권만 가능)\n");
				}else if(orderList[index][4] == 5){
					System.out.printf("* 임산부 우대 미적용(종합이용권만 가능)\n");
				}else{
					System.out.printf("* 다둥이 우대 미적용(종합이용권만 가능)\n");
				}
			}else if(orderList[index][1] == 5){
				System.out.printf("  성인 X %d  %d원 ", orderList[index][2], orderList[index][3]);
				if(orderList[index][4] == 1){
					System.out.printf("* 우대적용 없음\n");
				}else if(orderList[index][4] == 2){
					System.out.printf("* 장애인 우대 적용\n");
				}else if(orderList[index][4] == 3){
					System.out.printf("* 국가유공자 우대 적용\n");
				}else if(orderList[index][4] == 4){
					System.out.printf("* 휴가장병 우대 미적용(종합이용권만 가능)\n");
				}else if(orderList[index][4] == 5){
					System.out.printf("* 임산부 우대 미적용(종합이용권만 가능)\n");
				}else{
					System.out.printf("* 다둥이 우대 미적용(종합이용권만 가능)\n");
				}
			}else{
				System.out.printf("  경로 X %d  %d원 ", orderList[index][2], orderList[index][3]);
				if(orderList[index][4] == 1){
					System.out.printf("* 우대적용 없음\n");
				}else if(orderList[index][4] == 2){
					System.out.printf("* 장애인 우대 적용\n");
				}else if(orderList[index][4] == 3){
					System.out.printf("* 국가유공자 우대 적용\n");
				}else if(orderList[index][4] == 4){
					System.out.printf("* 휴가장병 우대 미적용(종합이용권만 가능)\n");
				}else if(orderList[index][4] == 5){
					System.out.printf("* 임산부 우대 미적용(종합이용권만 가능)\n");
				}else{
					System.out.printf("* 다둥이 우대 미적용(종합이용권만 가능)\n");
				}
			}
		}else if(orderList[index][0] == 2){                                           // 파크이용권[오후4시~] 관련 결과 출력분  
			System.out.printf("파크이용권[After4] ");
			if(orderList[index][1] == 1 || orderList[index][1] == 2){
				System.out.printf("베이비 X %d  %d원 ", orderList[index][2], orderList[index][3]);
				if(orderList[index][4] == 1){
					System.out.printf("* 우대적용 없음\n");
				}else if(orderList[index][4] == 2){
					System.out.printf("* 장애인 우대 적용\n");
				}else if(orderList[index][4] == 3){
					System.out.printf("* 국가유공자 우대 적용\n");
				}else if(orderList[index][4] == 4){
					System.out.printf("* 휴가장병 우대 미적용(종합이용권만 가능)\n");
				}else if(orderList[index][4] == 5){
					System.out.printf("* 임산부 우대 미적용(종합이용권만 가능)\n");
				}else{
					System.out.printf("* 다둥이 우대 미적용(종합이용권만 가능)\n");
				}
			}else if(orderList[index][1] == 3){
				System.out.printf("어린이 X %d  %d원 ", orderList[index][2], orderList[index][3]);
				if(orderList[index][4] == 1){
					System.out.printf("* 우대적용 없음\n");
				}else if(orderList[index][4] == 2){
					System.out.printf("* 장애인 우대 적용\n");
				}else if(orderList[index][4] == 3){
					System.out.printf("* 국가유공자 우대 적용\n");
				}else if(orderList[index][4] == 4){
					System.out.printf("* 휴가장병 우대 미적용(종합이용권만 가능)\n");
				}else if(orderList[index][4] == 5){
					System.out.printf("* 임산부 우대 미적용(종합이용권만 가능)\n");
				}else{
					System.out.printf("* 다둥이 우대 미적용(종합이용권만 가능)\n");
				}
			}else if(orderList[index][1] == 4){
				System.out.printf("청소년 X %d  %d원 ", orderList[index][2], orderList[index][3]);
				if(orderList[index][4] == 1){
					System.out.printf("* 우대적용 없음\n");
				}else if(orderList[index][4] == 2){
					System.out.printf("* 장애인 우대 적용\n");
				}else if(orderList[index][4] == 3){
					System.out.printf("* 국가유공자 우대 적용\n");
				}else if(orderList[index][4] == 4){
					System.out.printf("* 휴가장병 우대 미적용(종합이용권만 가능)\n");
				}else if(orderList[index][4] == 5){
					System.out.printf("* 임산부 우대 미적용(종합이용권만 가능)\n");
				}else{
					System.out.printf("* 다둥이 우대 미적용(종합이용권만 가능)\n");
				}
			}else if(orderList[index][1] == 5){
				System.out.printf("성인 X %d  %d원 ", orderList[index][2], orderList[index][3]);
				if(orderList[index][4] == 1){
					System.out.printf("* 우대적용 없음\n");
				}else if(orderList[index][4] == 2){
					System.out.printf("* 장애인 우대 적용\n");
				}else if(orderList[index][4] == 3){
					System.out.printf("* 국가유공자 우대 적용\n");
				}else if(orderList[index][4] == 4){
					System.out.printf("* 휴가장병 우대 미적용(종합이용권만 가능)\n");
				}else if(orderList[index][4] == 5){
					System.out.printf("* 임산부 우대 미적용(종합이용권만 가능)\n");
				}else{
					System.out.printf("* 다둥이 우대 미적용(종합이용권만 가능)\n");
				}
			}else{
				System.out.printf("경로 X %d  %d원 ", orderList[index][2], orderList[index][3]);
				if(orderList[index][4] == 1){
					System.out.printf("* 우대적용 없음\n");
				}else if(orderList[index][4] == 2){
					System.out.printf("* 장애인 우대 적용\n");
				}else if(orderList[index][4] == 3){
					System.out.printf("* 국가유공자 우대 적용\n");
				}else if(orderList[index][4] == 4){
					System.out.printf("* 휴가장병 우대 미적용(종합이용권만 가능)\n");
				}else if(orderList[index][4] == 5){
					System.out.printf("* 임산부 우대 미적용(종합이용권만 가능)\n");
				}else{
					System.out.printf("* 다둥이 우대 미적용(종합이용권만 가능)\n");
				}
			}
		}else if(orderList[index][0] == 3){                                           // 종합이용권 관련 결과 출력분  
			System.out.printf("종합이용권[1DAY] ");
			if(orderList[index][1] == 1 || orderList[index][1] == 2){
				System.out.printf(" 베이비 X %d  %d원 ", orderList[index][2], orderList[index][3]);
				if(orderList[index][4] == 1){
					System.out.printf("* 우대적용 없음\n");
				}else if(orderList[index][4] == 2){
					System.out.printf("* 장애인 우대 적용\n");
				}else if(orderList[index][4] == 3){
					System.out.printf("* 국가유공자 우대 적용\n");
				}else if(orderList[index][4] == 4){
					System.out.printf("* 휴가장병 우대 적용\n");
				}else if(orderList[index][4] == 5){
					System.out.printf("* 임산부 우대 적용\n");
				}else{
					System.out.printf("* 다둥이 우대 적용\n");
				}
			}else if(orderList[index][1] == 3){
				System.out.printf(" 어린이 X %d  %d원 ", orderList[index][2], orderList[index][3]);
				if(orderList[index][4] == 1){
					System.out.printf("* 우대적용 없음\n");
				}else if(orderList[index][4] == 2){
					System.out.printf("* 장애인 우대 적용\n");
				}else if(orderList[index][4] == 3){
					System.out.printf("* 국가유공자 우대 적용\n");
				}else if(orderList[index][4] == 4){
					System.out.printf("* 휴가장병 우대 적용\n");
				}else if(orderList[index][4] == 5){
					System.out.printf("* 임산부 우대 적용\n");
				}else{
					System.out.printf("* 다둥이 우대 적용\n");
				}
			}else if(orderList[index][1] == 4){
				System.out.printf(" 청소년 X %d  %d원 ", orderList[index][2], orderList[index][3]);
				if(orderList[index][4] == 1){
					System.out.printf("* 우대적용 없음\n");
				}else if(orderList[index][4] == 2){
					System.out.printf("* 장애인 우대 적용\n");
				}else if(orderList[index][4] == 3){
					System.out.printf("* 국가유공자 우대 적용\n");
				}else if(orderList[index][4] == 4){
					System.out.printf("* 휴가장병 우대 적용\n");
				}else if(orderList[index][4] == 5){
					System.out.printf("* 임산부 우대 적용\n");
				}else{
					System.out.printf("* 다둥이 우대 적용\n");
				}
			}else if(orderList[index][1] == 5){
				System.out.printf("  성인 X %d  %d원 ", orderList[index][2], orderList[index][3]);
				if(orderList[index][4] == 1){
					System.out.printf("* 우대적용 없음\n");
				}else if(orderList[index][4] == 2){
					System.out.printf("* 장애인 우대 적용\n");
				}else if(orderList[index][4] == 3){
					System.out.printf("* 국가유공자 우대 적용\n");
				}else if(orderList[index][4] == 4){
					System.out.printf("* 휴가장병 우대 적용\n");
				}else if(orderList[index][4] == 5){
					System.out.printf("* 임산부 우대 적용\n");
				}else{
					System.out.printf("* 다둥이 우대 적용\n");
				}
			}else{
				System.out.printf("  경로 X %d  %d원 ", orderList[index][2], orderList[index][3]);
				if(orderList[index][4] == 1){
					System.out.printf("* 우대적용 없음\n");
				}else if(orderList[index][4] == 2){
					System.out.printf("* 장애인 우대 적용\n");
				}else if(orderList[index][4] == 3){
					System.out.printf("* 국가유공자 우대 적용\n");
				}else if(orderList[index][4] == 4){
					System.out.printf("* 휴가장병 우대 적용\n");
				}else if(orderList[index][4] == 5){
					System.out.printf("* 임산부 우대 적용\n");
				}else{
					System.out.printf("* 다둥이 우대 적용\n");
				}
			}
		}else{                                                                        // 종합이용권[오후 4시~] 관련 결과 출력분  
			System.out.printf("종합이용권[After4] ");
			if(orderList[index][1] == 1 || orderList[index][1] == 2){
				System.out.printf("베이비 X %d  %d원 ", orderList[index][2], orderList[index][3]);
				if(orderList[index][4] == 1){
					System.out.printf("* 우대적용 없음\n");
				}else if(orderList[index][4] == 2){
					System.out.printf("* 장애인 우대 적용\n");
				}else if(orderList[index][4] == 3){
					System.out.printf("* 국가유공자 우대 적용\n");
				}else if(orderList[index][4] == 4){
					System.out.printf("* 휴가장병 우대 적용\n");
				}else if(orderList[index][4] == 5){
					System.out.printf("* 임산부 우대 적용\n");
				}else{
					System.out.printf("* 다둥이 우대 적용\n");
				}
			}else if(orderList[index][1] == 3){
				System.out.printf("어린이 X %d  %d원 ", orderList[index][2], orderList[index][3]);
				if(orderList[index][4] == 1){
					System.out.printf("* 우대적용 없음\n");
				}else if(orderList[index][4] == 2){
					System.out.printf("* 장애인 우대 적용\n");
				}else if(orderList[index][4] == 3){
					System.out.printf("* 국가유공자 우대 적용\n");
				}else if(orderList[index][4] == 4){
					System.out.printf("* 휴가장병 우대 적용\n");
				}else if(orderList[index][4] == 5){
					System.out.printf("* 임산부 우대 적용\n");
				}else{
					System.out.printf("* 다둥이 우대 적용\n");
				}
			}else if(orderList[index][1] == 4){
				System.out.printf("청소년 X %d  %d원 ", orderList[index][2], orderList[index][3]);
				if(orderList[index][4] == 1){
					System.out.printf("* 우대적용 없음\n");
				}else if(orderList[index][4] == 2){
					System.out.printf("* 장애인 우대 적용\n");
				}else if(orderList[index][4] == 3){
					System.out.printf("* 국가유공자 우대 적용\n");
				}else if(orderList[index][4] == 4){
					System.out.printf("* 휴가장병 우대 적용\n");
				}else if(orderList[index][4] == 5){
					System.out.printf("* 임산부 우대 적용\n");
				}else{
					System.out.printf("* 다둥이 우대 적용\n");
				}
			}else if(orderList[index][1] == 5){
				System.out.printf("성인 X %d  %d원 ", orderList[index][2], orderList[index][3]);
				if(orderList[index][4] == 1){
					System.out.printf("* 우대적용 없음\n");
				}else if(orderList[index][4] == 2){
					System.out.printf("* 장애인 우대 적용\n");
				}else if(orderList[index][4] == 3){
					System.out.printf("* 국가유공자 우대 적용\n");
				}else if(orderList[index][4] == 4){
					System.out.printf("* 휴가장병 우대 적용\n");
				}else if(orderList[index][4] == 5){
					System.out.printf("* 임산부 우대 적용\n");
				}else{
					System.out.printf("* 다둥이 우대 적용\n");
				}
			}else{
				System.out.printf("경로 X %d  %d원 ", orderList[index][2], orderList[index][3]);
				if(orderList[index][4] == 1){
					System.out.printf("* 우대적용 없음\n");
				}else if(orderList[index][4] == 2){
					System.out.printf("* 장애인 우대 적용\n");
				}else if(orderList[index][4] == 3){
					System.out.printf("* 국가유공자 우대 적용\n");
				}else if(orderList[index][4] == 4){
					System.out.printf("* 휴가장병 우대 적용\n");
				}else if(orderList[index][4] == 5){
					System.out.printf("* 임산부 우대 적용\n");
				}else{
					System.out.printf("* 다둥이 우대 적용\n");
				}
			}
		}
	}
}

}