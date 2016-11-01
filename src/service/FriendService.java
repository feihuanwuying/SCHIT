package service;

import dao.FriendDao;
import dao.UserDao;
import vo.Friend;

import java.util.List;

/**
 * Created by ZouKaifa on 2016/10/29.
 */
public class FriendService extends BasicService {
    /**
     * 判断两个人是否是朋友
     * @param username
     * @param friendName
     * @return
     */
    public boolean isFriend(String username, String friendName) {
        FriendDao friendDao = new FriendDao();
        if (friendDao.getFriend(username, friendName) != null) {
            friendDao.close();
            return true;
        }
        friendDao.close();
        return false;
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


}
