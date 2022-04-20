package 롯데월드_티켓발행_시스템;

public class CalculatorPriceWithDiscount {
	
	OrderDate o = new OrderDate();
	Calculator_Age c = new Calculator_Age();
	public int countPrice;
	public int countPriceYesdiscount;
	public int countPriceNodiscount;
	public int discountPrice;
	public static int totalDiscountPrice;
	
public void calCountPriceWithDiscount(){ // 나이대별 가격과 총 수량을 곱한 실제 티켓가격 구하기  
	
	if(o.orderCount <= 10){
		countPrice = c.price * o.orderCount;                                    //1. 총 구매한 티켓 금액(1 = 2 + 3) 
		countPriceYesdiscount = countPrice - (c.price * (o.orderCount - 2));    //2. 총 구매한 티켓 금액 - 각종 우대사항별 혜택(동반 1인 할인률 반영 등을 위해서) 인원을 고려하여 분리 
		countPriceNodiscount = countPrice - (c.price * 2);                    //3. 총 구매한 티켓 금액 - 우대사항 혜택을 받지 못하는 인원 고려하여 분리 
	}
}
	
public void calFinalPriceWithDiscount(){
	// 우대사항별 할인율을 고려한 실제 가격 계산  
			switch(o.discount){
				case 1 :							      //1. 우대사항 없음 - > 총 구매한 티켓 금액이 실제 지불해야 할 금액		
					discountPrice = countPrice;
					totalDiscountPrice = discountPrice;
					break;
				
				case 2 :						         //2. 장애인 우 대  -> 종합이용권/파크이용권 본인 +  동반1인까지 50% 할인 
				if(o.orderCount >= 3){
					discountPrice = countPriceNodiscount;
					if((o.ticketSelect == 1) || (o.ticketSelect == 2) || (o.ticketSelect == 3) || (o.ticketSelect == 4)){
						totalDiscountPrice = (int)(discountPrice + countPriceYesdiscount * 0.5); 	
					}
				}else{
					discountPrice = (int) (countPrice * 0.5);
					totalDiscountPrice = discountPrice;
				}	
					break;					
				
				case 3 :									//3. 국가유공자 우 대  -> 종합이용권/파크이용권 본인 +  동반1인까지 50% 할인 
					if(o.orderCount >= 3){
					discountPrice = countPriceNodiscount;
					if((o.ticketSelect == 1) || (o.ticketSelect == 2) || (o.ticketSelect == 3) || (o.ticketSelect == 4)){
						totalDiscountPrice = (int)(discountPrice + countPriceYesdiscount * 0.5);
					}
				}else{
					discountPrice = (int)(countPrice * 0.5);
					totalDiscountPrice = discountPrice;
				}	
					break;
					
				case 4 :									//4. 휴가장병 우 대  -> 종합이용권  본인 +  동반1인까지 49% 할인 
					if(o.orderCount >= 3){
					discountPrice = countPriceNodiscount;
					if((o.ticketSelect == 3) || (o.ticketSelect == 4)){
						totalDiscountPrice = (int) (discountPrice + countPriceYesdiscount * 0.51); 	
					}else{
					discountPrice = countPrice;
					totalDiscountPrice = discountPrice;
					}
				}else{
					if((o.ticketSelect == 3) || (o.ticketSelect == 4)){
					discountPrice = (int)(countPrice * 0.51);
					totalDiscountPrice = discountPrice;	
					}else{
					discountPrice = countPrice;
					totalDiscountPrice = discountPrice;
					}
				}
					break;
				
				case 5 :									//5. 임산부 우 대  -> 종합이용권  본인만 50% 할인 
					if(o.orderCount >= 3){
						discountPrice = countPriceNodiscount + countPriceNodiscount;
						if((o.ticketSelect == 3) || (o.ticketSelect == 4)){
							totalDiscountPrice = (int)(discountPrice + ((countPriceYesdiscount / 2) * 0.5)); 	
						}else{
							discountPrice = countPrice;
							totalDiscountPrice = discountPrice;
						}
					}
					else if(o.orderCount == 2){
						if((o.ticketSelect == 3) || (o.ticketSelect == 4)){
						discountPrice = (int)((countPrice / 2) + (countPrice / 2) * 0.5);
						totalDiscountPrice = discountPrice;
						}else{
							discountPrice = countPrice;
							totalDiscountPrice = discountPrice;
						}
					}else{
						if((o.ticketSelect == 3) || (o.ticketSelect == 4)){
							discountPrice = (int) (countPrice * 0.5);
							totalDiscountPrice = discountPrice;
						}else{
							discountPrice = countPrice;
							totalDiscountPrice = discountPrice;
						}
					}
					break;
					
				case 6 :								 	//6. 다둥이 행복카드 우대  	-> 종합이용권 본인 + 동반1인까지 30% 할인 
					if(o.orderCount >= 3){
						discountPrice = countPriceNodiscount;
						if((o.ticketSelect == 3) || (o.ticketSelect == 4)){
							totalDiscountPrice = (int)(discountPrice + countPriceYesdiscount * 0.7); 	
						}else{
							discountPrice = countPrice;
							totalDiscountPrice = discountPrice;
						}
					}else if(o.orderCount <= 2){
						if((o.ticketSelect == 3) || (o.ticketSelect == 4)){
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


}