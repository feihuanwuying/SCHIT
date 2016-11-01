package service;

import com.opensymphony.xwork2.ActionContext;
import dao.FriendDao;
import dao.UserDao;
import vo.Friend;
import vo.User;

import java.util.List;

/**
 * Created by ZouKaifa on 2016/10/29.
 */
public class FriendService extends BasicService {
    /**
     * 获得一个好友对象
     * @param username
     * @param friendName
     * @return
     */
    public Friend getFriend(String username, String friendName) {
        FriendDao friendDao = new FriendDao();
        Friend friend = friendDao.getFriend(username, friendName);
        friendDao.close();
        return friend;
    }

    /**
     * 获得某个用户的全部好友
     * @param username
     * @return
     */
    public List<Friend> getFriendList(String username) {
        FriendDao friendDao = new FriendDao();
        List<Friend> friendList = friendDao.getFriendList(username);
        friendDao.close();
        return friendList;
    }

    /**
     * 单向添加好友
     * @param username
     * @param friend_name
     * @param remark
     * @return
     */
    public boolean addFriend(String username, String friend_name, String remark) {
        boolean success = true;
        UserDao userDao = new UserDao();
        FriendDao friendDao = new FriendDao();
        User user = userDao.getUser(username);
        User friend = userDao.getUser(friend_name);
        if (user == null || friend == null) {  //存在
            success = false;
        } else if (friendDao.getFriend(username, friend_name) != null
                || remark.length() > 30) {  //不是好友
            success = false;
        } else if (!username.equals((String) ActionContext.getContext().getSession().get("username"))) {  //是当前用户
            success = false;
        } else {
            Friend friend1 = new Friend();
            friend1.setFriend(friend);
            friend1.setRemark(remark);
            friendDao.addFriend(username, friend1);
        }
        userDao.close();
        friendDao.close();
        return success;
    }

    /**
     * 删除好友，双向
     * @param username
     * @param friendName
     * @return
     */
    public boolean deleteFriend(String username, String friendName) {
        boolean success = true;
        UserDao userDao = new UserDao();
        FriendDao friendDao = new FriendDao();
        if (userDao.getUser(username) == null  //存在
            || userDao.getUser(friendName) == null) {
            success = false;
        } else if (friendDao.getFriend(username, friendName) == null) {  //是好友
            success = false;
        } else if (!username.equals((String) ActionContext.getContext().getSession().get("username"))) {  //当前用户
            success = false;
        } else {
            Friend friend = new Friend();
            friend.setFriend(userDao.getUser(friendName));
            friendDao.deleteFriend(username, friend);
        }
        userDao.close();
        friendDao.close();
        return success;
    }

    /**
     * 更新备注
     * @param username
     * @param friendName
     * @param remark
     * @return
     */
    public boolean updateRemark(String username, String friendName, String remark) {
        boolean success = true;
        UserDao userDao = new UserDao();
        FriendDao friendDao = new FriendDao();
        if (userDao.getUser(username) == null
                || userDao.getUser(friendName) == null) {
            success = false;  //存在
        } else if (friendDao.getFriend(username, friendName) == null
                || remark.length() > 30) {
            success = false;  //是好友
        } else if (!username.equals((String)ActionContext.getContext().getSession().get("username"))) {
            success = false;  //是当前用户
        } else {
            friendDao.updateRemark(username, friendName, remark);
        }
        userDao.close();
        friendDao.close();
        return success;
    }

}
