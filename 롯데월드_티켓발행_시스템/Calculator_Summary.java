package �Ե�����_Ƽ�Ϲ���_�ý���;

public class Calculator_Summary {

	public static int add_addCount;
	public static int[][] orderList = new int[10000][5];
	
public void calSummary(){
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

