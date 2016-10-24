package service;

import dao.PostDao;
import dao.ReplyDao;
import vo.Post;
import vo.Reply;

import java.util.HashMap;
import java.util.List;
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
    protected int pageSize = 2;  //一页的帖子数
    protected long pageNumber;  //页码
    protected long pageCount;  //总页数


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
        postDao.close();
        replyDao.close();
        return map;
    }

    /**
     * 根据分区、页码返回一个post列表,在调用此方法前，必须调用依次调用getPostPageCount和getPageNumber
     * @param type
     * @param pageNumber
     * @return
     */
    public List<Post> getPostList(int type) {
        PostDao postDao = new PostDao();
        List<Post> postList = postDao.getPostList(type, this.pageNumber, pageSize);
        postDao.close();
        return postList;
    }

    /**
     * 根据分区返回帖子总数
     * @param type
     * @return
     */
    public long getPostCount(int type) {
        PostDao postDao = new PostDao();
        long result = postDao.getPostCount(type);
        postDao.close();
        return result;
    }

    /**
     * 返回并设置某分区的帖子页数
     * @param type
     * @return
     */
    public long getPostPageCount(int type) {
        long postCount = getPostCount(type);
        pageCount = postCount % pageSize == 0? (postCount/pageSize) : postCount/pageSize+1;
        return pageCount;
    }

    /**
     * 对页码进行容错
     * @param pageNumber
     * @return
     */
    public long getPageNumber(long pageNumber) {
        if (pageNumber <= 0) {
            this.pageNumber = 1;
        } else if (pageNumber > pageCount){
            this.pageNumber = pageCount;
        } else {
            this.pageNumber = pageNumber;
        }
        return this.pageNumber;
    }

    /**
     * 获得这一分区的标签
     * @param type
     * @return
     */
    public String getLabel(int type) {
        switch (type) {
            case 5:
                return "聊天灌水";
            case 6:
                return "学习交流";
            case 7:
                return "交友征婚";
            case 8:
                return "咨询求助";
            default:
                return null;
        }
    }

    /**
     * 根据id返回帖子
     * @param id
     * @return
     */
    public Post getPost(long id) {
        PostDao postDao = new PostDao();
        Post post = postDao.getPost(id);
        postDao.close();
        return post;
    }

    /**
     * 根据id返回帖子的回复列表，此方法调用前需按序调用getReplyPageCount和getPageNumber
     * @param id
     * @return
     */
    public List<Reply> getReplyList(long id) {
        ReplyDao replyDao = new ReplyDao();
        List<Reply> replyList = replyDao.getReplyList(id, pageNumber, pageSize);
        replyDao.close();
        return replyList;
    }

    /**
     * 根据id返回帖子回复数
     * @param id
     * @return
     */
    public long getReplyCount(long id) {
        ReplyDao replyDao = new ReplyDao();
        long result = replyDao.getReplyCount(id);
        replyDao.close();
        return result;
    }

    /**
     * 根据id返回并设置回复的总页数
     * @param id
     * @return
     */
    public long getReplyPageCount(long id) {
        long replyCount = getReplyCount(id);
        pageCount = replyCount % pageSize == 0? (replyCount/pageSize) : replyCount/pageSize+1;
        return pageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

}
