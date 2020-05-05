package daodb;

import javabean.Customer;
import javabean.Goods;

public class TestMethod {
	public static void main(String[] args) {
		/*
		 * 用户信息查询方法测试：结果有效
		int i,j;
		CustomerMethods c = new CustomerMethods();
		String list[][] = c.searchAll();
		for(i=0,j=0;i<1&&j<4;j++) {
		System.out.println(list[i][j]);		
			
			用户个数查询方法测试：结果有效
		BusinessMethods b = new BusinessMethods();
		int x = b.tableNum();
		System.out.println(x);
		
			用户注册方法测试：结果有效
		CustomerMethods c = new CustomerMethods();
		c.addInfo("xlf", "111");
		
			用户修改密码depend用户名：结果有效
		CustomerMethods c = new CustomerMethods();
		c.UpdatePassword("xlf","222");
		
		CustomerMethods c = new CustomerMethods();
		Customer cus = c.searchAll("wangyusong");
		System.out.println(cus.getCustomer_name());
		*/
		int a;
		String s;
		boolean x;
		Goods good = new Goods();
		GoodsMethods g = new GoodsMethods();
		Customer cus = new Customer();
		CustomerMethods c = new CustomerMethods();
		s = g.Profit("wys");
		//cus = c.searchAll("wangyusong");
		//good = g.SearchGoodsInfo("macbookair3");
		//int y = Integer.parseInt(good.getGoods_price());
		System.out.println(s);
	}
}
