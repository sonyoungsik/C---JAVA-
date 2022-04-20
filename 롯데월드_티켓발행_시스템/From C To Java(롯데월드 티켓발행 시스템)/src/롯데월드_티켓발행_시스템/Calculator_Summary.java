package 롯데월드_티켓발행_시스템;

public class Calculator_Summary {

	public static int add_addCount;
	public static int[][] orderList = new int[10000][5];
	
public void calSummary(){
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

