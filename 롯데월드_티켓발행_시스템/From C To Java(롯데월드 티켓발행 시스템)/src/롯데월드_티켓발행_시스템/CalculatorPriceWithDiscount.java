package �Ե�����_Ƽ�Ϲ���_�ý���;

public class CalculatorPriceWithDiscount {
	
	OrderDate o = new OrderDate();
	Calculator_Age c = new Calculator_Age();
	public int countPrice;
	public int countPriceYesdiscount;
	public int countPriceNodiscount;
	public int discountPrice;
	public static int totalDiscountPrice;
	
public void calCountPriceWithDiscount(){ // ���̴뺰 ���ݰ� �� ������ ���� ���� Ƽ�ϰ��� ���ϱ�  
	
	if(o.orderCount <= 10){
		countPrice = c.price * o.orderCount;                                    //1. �� ������ Ƽ�� �ݾ�(1 = 2 + 3) 
		countPriceYesdiscount = countPrice - (c.price * (o.orderCount - 2));    //2. �� ������ Ƽ�� �ݾ� - ���� �����׺� ����(���� 1�� ���η� �ݿ� ���� ���ؼ�) �ο��� ����Ͽ� �и� 
		countPriceNodiscount = countPrice - (c.price * 2);                    //3. �� ������ Ƽ�� �ݾ� - ������ ������ ���� ���ϴ� �ο� ����Ͽ� �и� 
	}
}
	
public void calFinalPriceWithDiscount(){
	// �����׺� �������� ����� ���� ���� ���  
			switch(o.discount){
				case 1 :							      //1. ������ ���� - > �� ������ Ƽ�� �ݾ��� ���� �����ؾ� �� �ݾ�		
					discountPrice = countPrice;
					totalDiscountPrice = discountPrice;
					break;
				
				case 2 :						         //2. ����� �� ��  -> �����̿��/��ũ�̿�� ���� +  ����1�α��� 50% ���� 
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
				
				case 3 :									//3. ���������� �� ��  -> �����̿��/��ũ�̿�� ���� +  ����1�α��� 50% ���� 
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
					
				case 4 :									//4. �ް��庴 �� ��  -> �����̿��  ���� +  ����1�α��� 49% ���� 
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
				
				case 5 :									//5. �ӻ�� �� ��  -> �����̿��  ���θ� 50% ���� 
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
					
				case 6 :								 	//6. �ٵ��� �ູī�� ���  	-> �����̿�� ���� + ����1�α��� 30% ���� 
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