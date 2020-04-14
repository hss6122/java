package bean;

public class testset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		String no1 = "<<물건1>>";
	      String no2 = "<<물건2>>";
	      String no3 = "<<물건3>>";
	      String no4 = "<<물건4>>";
	      String no5 = "<<물건5>>";
	      String no6 = "<<물건6>>";
	      String no7 = "<<물건7>>";
	      String no8 = "<<물건8>>";
	      
	      String[] good = {"등록자","물건","금액","자리유무","판매후기","기타1","기타2","기타3"};
	      String no = no1+"#"+no2+"#"+no3+"#"+no4+"#"+no5+"#"+no6+"#"+no7+"#"+no8+"#";
	      System.out.println(no);
	      
	      String[] nono = no.split("#"); //split 지정한 값을 기준으로 배열에 넣어주는 함수
	      
	      //테이블을 만들 경우 요런 식으로 이용해서 <table>안에 <% %>자바를 이용해서 값을 넣어주시면 되요
	      
	      
	      for (int i = 0; i < nono.length; i++) {
	         System.out.println(good[i] +"   <----->    "+ nono[i]);
	         // <tr>물건등록자</tr><tr>none[0]</tr>
	      }

	}

}
