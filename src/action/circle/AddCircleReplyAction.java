package action.circle;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import service.CircleService;
import vo.CircleReply;

/**
 * Created by ZouKaifa on 2016/12/11.
 */
public class AddCircleReplyAction extends ActionSupport implements ModelDriven<CircleReply> {
    private CircleReply reply = new CircleReply();
    private String url;

    public CircleReply getReply() {
        return reply;
    }

    public void setReply(CircleReply reply) {
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
        CircleService circleService = new CircleService();
        url = ServletActionContext.getRequest().getHeader("referer");
        if (! circleService.addCircleReply(reply)) {
            return ERROR;
        }
        return SUCCESS;
    }

    @Override
    public CircleReply getModel() {
        return reply;
    }
}
