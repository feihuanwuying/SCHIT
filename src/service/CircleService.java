package service;

import com.opensymphony.xwork2.ActionContext;
import dao.CircleDao;
import dao.UserDao;
import vo.Circle;
import vo.CirclePost;
import vo.CircleReply;
import vo.User;

import java.util.Date;
import java.util.List;

/**
 * Created by ZouKaifa on 2016/12/11.
 */
public class CircleService extends BasicService {
    protected int pageSize = 8;
    public boolean addCircle(int ownerId, int[] userIdList, String name, String label) {
        UserDao userDao = new UserDao();
        User owner = userDao.getUser(ownerId);
        if (userIdList != null) {
            for (int i = 0; i < userIdList.length; i++) {
                if (userDao.getUser(userIdList[i]) == null) {
                    userDao.close();
                    return false;
                }
            }
        } else {
            userIdList = new int[0];
        }
        //name 与 label
        Circle circle = new Circle();
        circle.setName(name);
        circle.setLabel(label);
        circle.setOwner(owner);
        CircleDao circleDao = new CircleDao();
        circleDao.addCircle(circle, userIdList);
        circleDao.close();
        return true;
    }
    public List<Circle> getCircleList(int userId) {
        CircleDao circleDao = new CircleDao();
        List<Circle> circleList = circleDao.getCircleList(userId, pageNumber, pageSize);
        circleDao.close();
        return circleList;
    }

    public long getCirclePageCount(int userId) {
        long circleCount = getCircleCount(userId);
        pageCount = circleCount%pageSize == 0? circleCount/pageSize:circleCount/pageSize+1;
        return pageCount;
    }

    public long getCircleCount(int userId) {
        CircleDao circleDao = new CircleDao();
        long count = circleDao.getCircleCount(userId);
        circleDao.close();
        return count;
    }

    public List<CirclePost> getCirclePostList(int circleId) {
        CircleDao circleDao = new CircleDao();
        List<CirclePost> postList = null;
        int userId = (int)ActionContext.getContext().getSession().get("id");
        if (circleDao.getCircle(circleId) != null) {
            if (circleDao.isMember(userId, circleId)) {
                postList = circleDao.getCirclePostList(circleId, this.pageNumber, pageSize);
            }
        }
        circleDao.close();
        return postList;
    }

    public long getCirclePostCount(int circleId) {
        CircleDao circleDao = new CircleDao();
        long result = circleDao.getPostCount(circleId);
        circleDao.close();
        return result;
    }

    public long getCirclePostPageCount(int circleId) {
        long postCount = getCirclePostCount(circleId);
        pageCount = postCount % pageSize == 0? (postCount/pageSize) : postCount/pageSize+1;
        return pageCount;
    }

    public CirclePost getCirclePost(int id) {
        CircleDao circleDao = new CircleDao();
        CirclePost post = circleDao.getCirclePost(id);
        circleDao.close();
        return post;
    }

    public List<CircleReply> getCircleReplyList(int id) {
        CircleDao circleDao = new CircleDao();
        List<CircleReply> replyList = circleDao.getCircleReplyList(id, pageNumber, pageSize);
        circleDao.close();
        return replyList;
    }

    public long getCircleReplyCount(int id) {
        CircleDao replyDao = new CircleDao();
        long result = replyDao.getPostReplyCount(id);
        replyDao.close();
        return result;
    }

    public long getReplyPageCount(int id) {
        long replyCount = getCircleReplyCount(id);
        pageCount = replyCount % pageSize == 0? (replyCount/pageSize) : replyCount/pageSize+1;
        return pageCount;
    }

    public boolean addCircleReply(CircleReply reply) {
        CircleDao circleDao = new CircleDao();
        CirclePost post = circleDao.getCirclePost(reply.getPostId());
        if (post == null) {  //无主题帖
            return false;
        } else if (post.getCircleId() != reply.getCircleId()) {  //分区不符
            return false;
        }
        if (reply.getParentId() != -1) {
            CircleReply parent = circleDao.getCircleReply(reply.getParentId());
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
        circleDao.addCircleReply(reply);
        circleDao.updateCirclePost(post);
        userDao.close();
        circleDao.close();
        return true;
    }

    private boolean checkCirclePost(CirclePost post) {
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
        return true;
    }

    public boolean addCirclePost(CirclePost post) {
        if (! checkCirclePost(post)) {
            return false;
        }
        post.setTime(new Date());
        post.setLastReplyTime(post.getTime());
        CircleDao circleDao = new CircleDao();
        circleDao.addCirclePost(post);
        circleDao.close();
        return true;
    }

    public boolean deleteCircleReply(int id) {
        CircleDao circleDao = new CircleDao();
        CircleReply reply = circleDao.getCircleReply(id);
        if (reply == null) {
            return false;
        }
        CirclePost post = circleDao.getCirclePost(reply.getPostId());  //帖子
        circleDao.deleteCircleReply(id);
        CircleReply newReply = circleDao.getLastCircleReply(post.getId());  //新的最新回复
        if (newReply == null) {
            post.setLastReplyTime(post.getTime());
        } else {
            post.setLastReplyTime(newReply.getTime());
        }
        circleDao.updateCirclePost(post);
        circleDao.close();
        return true;
    }

    public boolean deleteCirclePost(int id) {
        CircleDao circleDao = new CircleDao();
        CirclePost post = circleDao.getCirclePost(id);
        if (post == null) {
            return false;
        }
        circleDao.deletePost(id);
        circleDao.close();
        return true;
    }

    public Circle getCircle(int circleId) {
        CircleDao circleDao = new CircleDao();
        Circle circle = circleDao.getCircle(circleId);
        circleDao.close();
        return circle;
    }

    public int isOwner(int userId, int circleId) {
        CircleDao circleDao = new CircleDao();
        boolean is = circleDao.isOwner(userId, circleId);
        circleDao.close();
        return is?1:0;
    }

}
