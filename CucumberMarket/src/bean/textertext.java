package bean;

public class textertext {

	public static void main(String[] args) {
		
		String marketid = "마켓";
		String loginid = "마켓유저";
		String[] booker = { "1", "마켓"};//오프라인 장터 예약 상황
		
		for (int i = 0; i < booker.length; i++) {
			
			if (booker[i].equals("1")) { //첫번쟤 조건 => 장터 예약 유무 확인
				
				// <tr>  예약가능합니다!    <tr>
				
				System.out.println("에약가능");
				
			}else {
				
				// 예약됨
				if (booker[i].equals(loginid)) {  //두번째 조건 => 등록한 사용자가 등록된 물건을 보는지 / 다른 사용자의 물건을 보는지
					System.out.println("수정, 삭제");
					//  id="" => 버튼 기능이 달라져야함.
					
				}else {
					System.out.println("물건만 보여주기");
				}
				
			}
			
		} // <input type="text" class="id" id="<%=i%>자리" style="display: none;" >
		
		
		// $(function{
		
	//    checker  = $('#id').attr(this)
		
	// $('#checker')
		
	//})
		
		

	}

}
