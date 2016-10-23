package service;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.javafx.collections.MappingChange;
import dao.UserDao;
import vo.User;

import java.util.Map;


/** 登录相关的服务
 * Created by ZouKaifa on 2016/10/13.
 */
public class UserService {
    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return 成功则返回true，否则false
     */
    public boolean login(String username, String password) {
        UserDao userDao = new UserDao();
        User user = userDao.getUser(username, password);
        if (user != null) {
            ActionContext.getContext().getSession().put("username", username);
            ActionContext.getContext().getSession().put("nickname", user.getNickname());
            return true;
        }
        return false;
    }

    /**
     * 注册
     * @param user 要注册的信息
     * @return 注册是否成功
     */
    public boolean register(User user) {
        UserDao userDao = new UserDao();
        if (userDao.getUser(user.getUsername()) == null) {
            userDao.addUser(user);
            ActionContext.getContext().getSession().put("username", user.getUsername());
            ActionContext.getContext().getSession().put("nickname", user.getNickname());
            return true;
        }
        return false;
    }

    /**
     * 登出
     * @return 登出是否成功
     */
    public boolean logout() {
        Map<String, Object> session = ActionContext.getContext().getSession();
        if (session.containsKey("username")) {
            session.remove("username");
            return true;
        }
        return false;
    }
}
