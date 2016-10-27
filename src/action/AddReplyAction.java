package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import service.ForumService;
import vo.Reply;

/**
 * Created by ZouKaifa on 2016/10/25.
 */
public class AddReplyAction extends ActionSupport implements ModelDriven<Reply> {
    private Reply reply = new Reply();  //要添加的回复
    private String url;

    public Reply getReply() {
        return reply;
    }

    public void setReply(Reply reply) {
        this.reply = reply;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String execute() throws Exception {
        ForumService forumService = new ForumService();
        url = ServletActionContext.getRequest().getHeader("referer");
        if (! forumService.addReply(reply)) {
            return ERROR;
        }
        return SUCCESS;
    }

    @Override
    public Reply getModel() {
        return reply;
    }
}
