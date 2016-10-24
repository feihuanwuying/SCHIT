package service;

import dao.PostDao;
import dao.ReplyDao;
import vo.Post;

import java.util.HashMap;
import java.util.Map;

/**
 * 论坛相关服务
 * Created by ZouKaifa on 2016/10/24.
 */
public class ForumService {
    private int DISCCUSION = 5;  //聊天
    private int LEARN = 6;  //学习
    private int MAKE_FRIEND = 7;  //交友
    private int QUERY = 8;  //求助


    /**
     * 返回一个论坛分区为key，[主题数，回复数]为value的map
     * @return
     */
    public Map<Integer, Long[]> getNumberMap() {
        Map<Integer, Long[]> map = new HashMap<>(4);
        PostDao postDao = new PostDao();
        ReplyDao replyDao = new ReplyDao();
        map.put(DISCCUSION, new Long[]{postDao.getPostCount(DISCCUSION), replyDao.getReplyCount(DISCCUSION)});
        map.put(LEARN, new Long[]{postDao.getPostCount(LEARN), replyDao.getReplyCount(LEARN)});
        map.put(MAKE_FRIEND, new Long[]{postDao.getPostCount(MAKE_FRIEND), replyDao.getReplyCount(MAKE_FRIEND)});
        map.put(QUERY, new Long[]{postDao.getPostCount(QUERY), replyDao.getReplyCount(QUERY)});
        return map;
    }
}
