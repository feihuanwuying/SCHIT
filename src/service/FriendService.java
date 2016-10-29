package service;

import dao.FriendDao;

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
        if (friendDao.getFriend(username, friendName) != null
                || friendDao.getFriend(friendName, username) != null) {
            return true;
        }
        return false;
    }


}
