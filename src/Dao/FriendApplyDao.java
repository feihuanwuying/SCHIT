package Dao;

import Data.FriendApply;

import java.sql.Connection;
import java.util.List;

/**
 * 获取friend_apply表的内容
 * Created by ZouKaifa on 2016/10/10.
 */
public class FriendApplyDao {
    private Connection con;

    /**
     * 获得某个用户的好友申请列表
     *
     * @param username 用户名
     * @return 好友申请列表
     */
    public List<FriendApply> getFriendApplies(String username) {
        //// TODO: 2016/10/10  
        return null;
    }
}
