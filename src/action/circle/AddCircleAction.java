package action.circle;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import service.CircleService;
import service.FriendService;
import vo.Circle;
import vo.Friend;

import java.util.List;

/**
 * Created by ZouKaifa on 2016/12/11.
 */
public class AddCircleAction extends ActionSupport {
    private int[] userIdList;
    private String name;
    private String label;

    public int[] getUserIdList() {
        return userIdList;
    }

    public void setUserIdList(int[] userIdList) {
        this.userIdList = userIdList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }


    @Override
    public String execute() throws Exception {
        int userId = (int) ActionContext.getContext().getSession().get("id");
        CircleService circleService = new CircleService();
        if (!circleService.addCircle(userId, userIdList, name, label)) {
            return ERROR;
        }
        return SUCCESS;
    }
}
