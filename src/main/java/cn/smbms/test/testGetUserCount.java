package cn.smbms.test;

import cn.smbms.dao.user.UserDao;
import cn.smbms.util.MyBatiesUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class testGetUserCount {
    private static  Logger logger = Logger.getLogger(testGetUserCount.class);

    public static void main(String[] args) {
        try {
            // 1 读取配置文件
            InputStream is = Resources.getResourceAsStream("configuration.xml");
            // 2 创建工厂
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            // 3 打开会话
            SqlSession sqlSession = factory.openSession();
            // 4 操作数据库
            int userCount = sqlSession.getMapper(UserDao.class).getUserCount();
            logger.debug("用户的个数为：" + userCount);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void test() {
        SqlSession sqlSession = MyBatiesUtil.createSqlSession();
        int userCount = sqlSession.getMapper(UserDao.class).getUserCount();
        MyBatiesUtil.closeSqlSession(sqlSession);
        logger.debug("用户数量：" + userCount);

    }




}
