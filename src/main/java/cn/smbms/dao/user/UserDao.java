package cn.smbms.dao.user;

import cn.smbms.beans.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    // 查询有多少用户
    public int getUserCount();

    // 查询所有用户的信息
    public List<User> getUserList();

    //模糊查询用户的信息
    public  List<User> getUserListByName(String name);

    //添加用户
    public  int addUser(User user);

    //根据id修改编码，名字
    public  int updateUser(User user);

    //根据id修改密码
    public  int updatePwdById( @Param("pwd") String userPassword ,@Param("id") Integer id);

    //根据id删除用户
    public int deleteUser(Integer id);

    //根据用户的角色id查询用户的列表
    public List<User> getUserListByRole(@Param("id") Integer userRole);

    //  根据用户的id，查询用户相关的信息和其负责的人员地址
    public  List<User>  getUserListByid(@Param("id") Integer id);





}
