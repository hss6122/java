package member;

public class MemberPrint {

	public static void main(String[] args) {
	
		Member dto = new Member();
		
		
		
		System.out.println(dto.getName()+"(" +dto.getId() +" )"+dto.getPw()+", "+dto.getBrday()+" ,"
				+ " "+dto.getGneder()+" , "+dto.getAdress()+"(" +dto.getTel()+ ")");
		
		

	}
}