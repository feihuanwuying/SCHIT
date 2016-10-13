package service;

import com.opensymphony.xwork2.ActionContext;
import dao.Dao;
import dao.UserDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/** 登录相关的服务
 * Created by ZouKaifa on 2016/10/13.
 */
public class LoginService {
    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return 成功则返回true，否则false
     */
    public boolean login(String username, String password) {
        UserDao userDao = new UserDao();
        if (userDao.exits(username, password)) {
            ActionContext.getContext().getSession().put("username", username);
            return true;
        }
        return false;
    }
}
