package �Ե�����_Ƽ�Ϲ���_�ý���;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TodayYMD {

	public static int year;
	public static int month;
	public static int day;
	public static int todayYMD;

public void calTodayYMD(){ // ���� ��¥ ��� + ������ ����

	Calendar calendar = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("YYMMdd");
	int today = Integer.parseInt(sdf.format(calendar.getTime()));
	year = (today / 10000);
	month = (today / 100) % 100;
	day = (today % 100);
	todayYMD = year *10000 +  month *100 +  + day;
	}

}