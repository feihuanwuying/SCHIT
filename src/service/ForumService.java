package service;

import com.opensymphony.xwork2.ActionContext;
import com.sun.org.apache.regexp.internal.RE;
import dao.PostDao;
import dao.ReplyDao;
import dao.UserDao;
import vo.Post;
import vo.Reply;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * 论坛相关服务
 * Created by ZouKaifa on 2016/10/24.
 */
public class ForumService extends BasicService {
    private final int ACTIVITY = 1;  //讲座与活动
    private final int RECRUIT = 2;  //招聘
    private final int BUSINESS = 3;  //交易
    private final int PARTTIME = 4;  //兼职
    private final int DISCCUSION = 5;  //聊天
    private final int LEARN = 6;  //学习
    private final int MAKE_FRIEND = 7;  //交友
    private final int QUERY = 8;  //求助


    /**
     * 返回一个论坛分区为key，[主题数，回复数]为value的map
     * @return
     */
    public Map<Integer, Long[]> getNumberMap() {
        Map<Integer, Long[]> map = new HashMap<>(4);
        PostDao postDao = new PostDao();
        ReplyDao replyDao = new ReplyDao();
        map.put(ACTIVITY, new Long[]{postDao.getPostCount(ACTIVITY), replyDao.getReplyCount(ACTIVITY)});
        map.put(RECRUIT, new Long[]{postDao.getPostCount(RECRUIT), replyDao.getReplyCount(RECRUIT)});
        map.put(BUSINESS, new Long[]{postDao.getPostCount(BUSINESS), replyDao.getReplyCount(BUSINESS)});
        map.put(PARTTIME, new Long[]{postDao.getPostCount(PARTTIME), replyDao.getReplyCount(PARTTIME)});
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
     * 获得这一分区的标签
     * @param type
     * @return
     */
    public String getLabel(int type) {
        switch (type) {
            case 1:
                return "讲座活动";
            case 2:
                return "招聘信息";
            case 3:
                return "物品交易";
            case 4:
                return "家教兼职";
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

    /**
     * 添加一条回复
     * @param reply
     * @return
     */
    public boolean addReply(Reply reply) {
        PostDao postDao = new PostDao();
        ReplyDao replyDao = new ReplyDao();
        Post post = postDao.getPost(reply.getPostId());
        if (post == null) {  //无主题帖
            return false;
        } else if (post.getType() != reply.getType()) {  //分区不符
            return false;
        }
        if (reply.getParentId() != -1) {
            Reply parent = replyDao.getReply(reply.getParentId());
            if (parent == null) {  //不存在父贴
                return false;
            }
        }
        UserService userService = new UserService();
        if (reply.getReplier() == null ||
                reply.getReplier().getId() != (int)
                        ActionContext.getContext().getSession().get("id")
                || userService.getUser(reply.getReplier().getId()) == null) {
            return false;  //用户名不对
        }
        UserDao userDao = new UserDao();
        int length = reply.getContent().length();
        if (length < 4 || length > 4000) {  //长度验证
            return false;
        }
        reply.setContent(reply.getContent().replace("\n", "<br>"));
        if (post.getLastReply() == null) {
            reply.setFloor(2);
        } else {
            reply.setFloor(post.getLastReply().getFloor() + 1);
        }
        reply.setTime(new Date());
        post.setLastReplyTime(reply.getTime());
        replyDao.addReply(reply);
        postDao.updatePost(post);
        userDao.close();
        postDao.close();
        replyDao.close();
        return true;
    }

    /**
     * 校验Post数据
     * @param post
     * @return
     */
    private boolean checkPost(Post post) {
        UserService userService = new UserService();
        int userId = post.getPoster().getId();
        if (userService.getUser(userId) == null
                || userId != (int) ActionContext.
                getContext().getSession().get("id")) {
            return false;  //用户
        }
        String title = post.getTitle();
        if (title.length() < 4 || title.length() > 50) {
            return false;  //标题长度
        }
        String content = post.getContent();
        if (content.length() > 4000) {
            return false;  //内容长度
        }
        post.setContent(content.replace("\n", "<br>"));
        int type = post.getType();
        if (type < 1 || type > 8) {
            return false;  //分区
        }
        return true;
    }

    /**
     * 增加一条post
     * @param post
     * @return
     */
    public boolean addPost(Post post) {
        if (! checkPost(post)) {
            return false;
        }
        post.setTime(new Date());
        post.setLastReplyTime(post.getTime());
        PostDao postDao = new PostDao();
        postDao.addPost(post);
        postDao.close();
        return true;
    }

    /**
     * 根据id删除回复
     * @param id
     * @return
     */
    public boolean deleteReply(long id) {
        ReplyDao replyDao = new ReplyDao();
        Reply reply = replyDao.getReply(id);
        if (reply == null) {
            return false;
        }
        PostDao postDao = new PostDao();
        Post post = postDao.getPost(reply.getPostId());  //帖子
        replyDao.deleteReply(id);
        Reply newReply = replyDao.getLastReply(post.getId());  //新的最新回复
        if (newReply == null) {
            post.setLastReplyTime(post.getTime());
        } else {
            post.setLastReplyTime(newReply.getTime());
        }
        postDao.updatePost(post);
        replyDao.close();
        postDao.close();
        return true;
    }

    /**
     * 根据id删除帖子
     * @param id
     * @return
     */
    public boolean deletePost(long id) {
        PostDao postDao = new PostDao();
        Post post = postDao.getPost(id);
        if (post == null) {
            return false;
        }
        postDao.deletePost(id);
        postDao.close();
        return true;
    }


    /**
     * 获得最新的5个帖子
     * @return
     */
    public List<Post> getLatestPostList() {
        PostDao postDao = new PostDao();
        List<Post> postList = postDao.getLatestPostList();
        postDao.close();
        return postList;
    }

    public long getUserPostCount(int userId) {
        PostDao postDao = new PostDao();
        long count = postDao.getUserPostCount(userId);
        postDao.close();
        return count;
    }

    public long getUserReplyCount(int userId) {
        ReplyDao replyDao = new ReplyDao();
        long count = replyDao.getUserReplyCount(userId);
        replyDao.close();
        return count;
    }

    public List<Post> getUserPostList(int userId) {
        PostDao postDao = new PostDao();
        List<Post> postList = postDao.getUserPostList(userId);
        postDao.close();
        return postList;
    }

}
