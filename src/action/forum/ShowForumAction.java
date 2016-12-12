package action.forum;

import com.opensymphony.xwork2.ActionSupport;
import service.ForumService;
import vo.Post;

import java.util.List;
import java.util.Map;

/**
 * Created by ZouKaifa on 2016/10/24.
 */
public class ShowForumAction extends ActionSupport {
    private Map<Integer, Long[]> map;  //分区为k，[主题数，帖子数]为v
    private List<Post> latestPostList;  //最新帖子

    public Map<Integer, Long[]> getMap() {
        return map;
    }

    public void setMap(Map<Integer, Long[]> map) {
        this.map = map;
    }

    public List<Post> getLatestPostList() {
        return latestPostList;
    }

    public void setLatestPostList(List<Post> latestPostList) {
        this.latestPostList = latestPostList;
    }

    @Override
    public String execute() throws Exception {
        ForumService forumService = new ForumService();
        setMap(forumService.getNumberMap());
        latestPostList = forumService.getLatestPostList();
        return SUCCESS;
    }
}
