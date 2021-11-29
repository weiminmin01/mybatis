package cn.smbms.test;

import cn.smbms.beans.Bill;
import cn.smbms.beans.User;
import cn.smbms.dao.bill.BillDao;
import cn.smbms.dao.user.UserDao;
import cn.smbms.util.MyBatiesUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class testGetBillList {

    @Test
   public void  test01(){
       SqlSession sqlSession=MyBatiesUtil.createSqlSession();
       Bill bill=new Bill();
       bill.setProductName("油");
       bill.setProviderId(6);
      List<Bill> billList= sqlSession.getMapper(BillDao.class).getBillList(bill);
       for(Bill s :billList){
           System.out.println(s.toString());
       }
       MyBatiesUtil.closeSqlSession(sqlSession);
   }

    @Test
    public void test02() {
        SqlSession sqlSession = MyBatiesUtil.createSqlSession();
        List<Bill> u= sqlSession.getMapper(BillDao.class).getBillListByNameId("油",6,2);
        for (Bill s :u){
            System.out.println(
                   s.getBillCode()+"\t"+s.getProductName()+"\t"+s.getTotalPrice()+"\t"+
                         s.getIsPayment()+"\t"+s.getProvider().getProCode()
                    +"\t"+s.getProvider().getProName()+"\t"+ s.getProvider().getProContact()
                    +"\t"+s.getProvider().getProPhone()
            );
        }
        MyBatiesUtil.closeSqlSession(sqlSession);
    }

}
