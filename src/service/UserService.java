package service;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.javafx.collections.MappingChange;
import dao.UserDao;
import vo.User;

import java.io.UnsupportedEncodingException;
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
        userDao.close();
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
            if (!checkData(user)) {
                return false;
            }
            userDao.addUser(user);
            userDao.close();
            ActionContext.getContext().getSession().put("username", user.getUsername());
            ActionContext.getContext().getSession().put("nickname", user.getNickname());
            return true;
        }
        userDao.close();
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
            session.remove("nickname");
            return true;
        }
        return false;
    }

    /**
     * 查看用户名是否存在
     * @param username
     * @return
     */
    public boolean exist(String username) {
        UserDao userDao = new UserDao();
        User user = userDao.getUser(username);
        userDao.close();
        return user != null;
    }

    /**
     * 检测数据合法性
     * @param user
     * @return
     */
    private boolean checkData(User user) {
        if (!user.getUsername().matches("[a-zA-Z0-9]*")
                || user.getUsername().length() < 8
                || user.getUsername().length() > 20) {
            return false;  //用户名长度
        }
        if (!user.getPassword().matches("[a-zA-Z0-9]*")
                || user.getPassword().length() < 8
                || user.getPassword().length() > 20) {
            return false;  //密码长度
        }
        int nickLength = user.getNickname().length();
        if (nickLength < 4 || nickLength > 30) {
            return false;  //昵称程度
        }
        int emailLength = user.getEmail().length();
        if (!user.getEmail().matches("^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w+)+)$")
                || emailLength < 50) {
            return false;  //邮箱长度
        }
        return true;
    }
}
