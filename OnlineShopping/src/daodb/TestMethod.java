package daodb;

public class TestMethod {
	public static void main(String[] args) {
		/*�û���Ϣ��ѯ�������ԣ������Ч
		int i,j;
		CustomerMethods c = new CustomerMethods();
		String list[][] = c.searchAll();
		for(i=0,j=0;i<1&&j<4;j++) {
		System.out.println(list[i][j]);		
		*/	
		BusinessMethods b = new BusinessMethods();
		int x = b.tableNum();
		System.out.println(x);
		}

}
