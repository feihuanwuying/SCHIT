package service;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.javafx.collections.MappingChange;
import dao.UserDao;
import dao.VisitDao;
import vo.Inform;
import vo.User;
import vo.Visit;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;


/** 登录相关的服务
 * Created by ZouKaifa on 2016/10/13.
 */
public class UserService extends BasicService{
    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return 成功则返回true，否则false
     */
    public boolean login(String username, String password) {
        if (username == null) {
            username = "";
        }
        if (password == null) {
            password = "";
        }
        UserDao userDao = new UserDao();
        User user = userDao.getUser(username, password);
        userDao.close();
        if (user != null) {
            Map<String, Object> session = ActionContext.getContext().getSession();
            session.put("username", username);
            session.put("nickname", user.getNickname());
            session.put("power", user.getPower());
            session.put("id", user.getId());
            session.put("inform", new InformService().getNewInformCount(user.getId()));
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
            user = userDao.getUser(user.getUsername());
            userDao.close();
            Map<String, Object> session = ActionContext.getContext().getSession();
            session.put("username", user.getUsername());
            session.put("nickname", user.getNickname());
            session.put("power", user.getPower());
            session.put("id", user.getId());
            session.put("inform", new InformService().getNewInformCount(user.getId()));
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
            session.remove("power");
            session.remove("id");
            session.remove("inform");
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
        String nick = user.getNickname();
        if (nick.length() < 2 || nick.length() > 30) {
            return false;  //昵称程度
        }
        String email = user.getEmail();
        if (!email.matches("^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w+)+)$")
                || email.length() > 50) {
            return false;  //邮箱长度
        }
        //// TODO: 2016/11/11 其它数据校验 
        return true;
    }

    /**
     * 根据用户名获得用户
     * @param username
     * @return
     */
    public User getUser(String username) {
        if (exist(username)) {
            UserDao userDao = new UserDao();
            User user = userDao.getUser(username);
            userDao.close();
            return user;
        }
        return null;
    }

    /**
     * 根据id获得user
     * @param id
     * @return
     */
    public User getUser(int id) {
        UserDao userDao = new UserDao();
        User user = userDao.getUser(id);
        if (user != null) {
            user.setPassword("");
        }
        userDao.close();
        return user;
    }

    /**
     * 访问过一次
     * @param userId
     * @return
     */
    public boolean visitHome(int userId) {
        UserDao userDao = new UserDao();
        int visitorId = (int)ActionContext.getContext().getSession().get("id");
        User user = userDao.getUser(userId);
        User visitor = userDao.getUser(visitorId);
        if (user == null || visitor == null || userId == visitorId) {
            userDao.close();
            return false;
        }
        VisitDao visitDao = new VisitDao();
        Visit visit = new Visit();
        visit.setTime(new Date());
        visit.setUser(user);
        visit.setVisitor(visitor);
        if (visitDao.getVisit(userId, visitorId) == null) {
            visitDao.addVisit(visit);
        } else {
            visitDao.updateVisit(visit);
        }
        userDao.close();
        visitDao.close();
        return true;
    }

    public long getVisitCount(int userId) {
        UserDao userDao = new UserDao();
        if (userDao.getUser(userId) == null) {
            userDao.close();
            return -1;
        }
        VisitDao visitDao = new VisitDao();
        long count = visitDao.getVisitCount(userId);
        visitDao.close();
        return count;
    }

    public List<Visit> getVisitList(int userId) {
        VisitDao visitDao = new VisitDao();
        List<Visit> visitList = visitDao.getVisitList(userId);
        visitDao.close();
        return visitList;
    }


    public List<User> getUserList(String nickname) {
        UserDao userDao = new UserDao();
        List<User> userList = userDao.getUserList(nickname, pageNumber, pageSize);
        userDao.close();
        return userList;
    }

    private long getUserCount(String nickname) {
        UserDao userDao = new UserDao();
        long count = userDao.getUserCount(nickname);
        userDao.close();
        return count;
    }

    public long getUserPageCount(String nickname) {
        long userCount = getUserCount(nickname);
        pageCount = userCount % pageSize == 0? (userCount/pageSize) : userCount/pageSize+1;
        return pageCount;
    }

}
