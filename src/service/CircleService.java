package service;

import com.opensymphony.xwork2.ActionContext;
import dao.CircleDao;
import dao.UserDao;
import vo.Circle;
import vo.User;

import java.util.List;

/**
 * Created by ZouKaifa on 2016/12/11.
 */
public class CircleService extends BasicService {
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
}
