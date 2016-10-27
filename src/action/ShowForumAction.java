package action;

import com.opensymphony.xwork2.ActionSupport;
import service.ForumService;

import java.util.Map;

/**
 * Created by ZouKaifa on 2016/10/24.
 */
public class ShowForumAction extends ActionSupport {
    private Map<Integer, Long[]> map;  //分区为k，[主题数，帖子数]为v

    public Map<Integer, Long[]> getMap() {
        return map;
    }

    public void setMap(Map<Integer, Long[]> map) {
        this.map = map;
    }

    @Override
    public String execute() throws Exception {
        ForumService forumService = new ForumService();
        setMap(forumService.getNumberMap());
        return SUCCESS;
    }
}
