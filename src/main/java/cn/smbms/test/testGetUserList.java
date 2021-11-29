package cn.smbms.test;

import cn.smbms.beans.Address;
import cn.smbms.beans.Provider;
import cn.smbms.beans.User;

import cn.smbms.dao.provider.ProviderDao;
import cn.smbms.dao.user.UserDao;
import cn.smbms.util.MyBatiesUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class testGetUserList {




    @Test
    public void test01() {
        SqlSession sqlSession = MyBatiesUtil.createSqlSession();
        List<User> userList = sqlSession.selectList("cn.smbms.dao.user.UserDao.getUserList");
        for (User u : userList) {
            System.out.println(u.toString());
        }
        MyBatiesUtil.closeSqlSession(sqlSession);

    }

    @Test
    public void test02() {
        SqlSession sqlSession = MyBatiesUtil.createSqlSession();
        List<User> userList = sqlSession.getMapper(UserDao.class).getUserList();
        for (User u : userList) {
            System.out.println(u.toString());
        }
        MyBatiesUtil.closeSqlSession(sqlSession);
    }

    @Test
    public void test03() {
        SqlSession sqlSession = MyBatiesUtil.createSqlSession();
        List<Provider> p = sqlSession.getMapper(ProviderDao.class).getAllProvider();
        for (Provider s : p) {
            System.out.println(s.toString());
        }
        MyBatiesUtil.closeSqlSession(sqlSession);
    }


    @Test
    public void test04() {
        SqlSession sqlSession = MyBatiesUtil.createSqlSession();
        List<Provider> p = sqlSession.selectList("cn.smbms.dao.provider.ProviderDao.getAllProvider");
        for (Provider s : p) {
            System.out.println(s.toString());
        }
    }


    @Test
    public void test05() {
        SqlSession sqlSession = MyBatiesUtil.createSqlSession();
        List<User> userList = sqlSession.getMapper(UserDao.class).getUserListByName("张");
        for (User s : userList) {
            System.out.println(s.toString());
        }
        MyBatiesUtil.closeSqlSession(sqlSession);

    }
    @Test
    public void  test06(){
          User user=new User();
        user.setUserCode("xiaozhang");
        user.setUserName("小张");
        user.setUserPassword("123456");
      SqlSession sqlSession=  MyBatiesUtil.createSqlSession();
         sqlSession.getMapper(UserDao.class).addUser(user);
        sqlSession.commit();
        MyBatiesUtil.closeSqlSession(sqlSession);
    }
@Test
    public void  test07(){
        User user=new User();
        //user.setUserCode("zhuzi");
        user.setUserName("柱子");
        user.setId(16);
        SqlSession sqlSession=  MyBatiesUtil.createSqlSession();
        sqlSession.getMapper(UserDao.class).updateUser(user);
        sqlSession.commit();
        MyBatiesUtil.closeSqlSession(sqlSession);
    }


    @Test
    public void test08() {

            SqlSession sqlSession=  MyBatiesUtil.createSqlSession();
            sqlSession.getMapper(UserDao.class).updatePwdById("456123",16);
            sqlSession.commit();
            MyBatiesUtil.closeSqlSession(sqlSession);


    }



    @Test
    public void test09() {

        SqlSession sqlSession = MyBatiesUtil.createSqlSession();
        sqlSession.getMapper(UserDao.class).deleteUser(19);
        sqlSession.commit();
        MyBatiesUtil.closeSqlSession(sqlSession);
    }

    @Test
    public void test10() {
        SqlSession sqlSession = MyBatiesUtil.createSqlSession();
       List<User> u= sqlSession.getMapper(UserDao.class).getUserListByRole(2);
        for (User s :u){
            System.out.println(
                    s.getId()+"\t"+ s.getUserCode() +"\t"+s.getUserName()
                    +"\t"+s.getUserRole() +"\t"+s.getRole().getRoleCode()
                    +"\t"+s.getRole().getRoleName()
            );
        }
        MyBatiesUtil.closeSqlSession(sqlSession);
    }




    @Test
    public void test11() {
        SqlSession sqlSession = MyBatiesUtil.createSqlSession();
        List<User> u= sqlSession.getMapper(UserDao.class).getUserListByid(1);
        for (User s :u) {
            System.out.println(
                    s.getId() + "\t" + s.getUserName()
            );
            for (Address a:s.getCouaddress()){
                System.out.println(
                        a.getContact()+"\t" +a.getAddressDesc()
                );
            }
        }


        MyBatiesUtil.closeSqlSession(sqlSession);
    }



}