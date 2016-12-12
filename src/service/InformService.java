package service;

import com.opensymphony.xwork2.ActionContext;
import dao.InformDao;
import dao.UserDao;
import vo.Friend;
import vo.Inform;
import vo.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ZouKaifa on 2016/11/14.
 */
public class InformService extends BasicService {
    public long getNewInformCount(int userId) {
        InformDao informDao = new InformDao();
        long count = informDao.getNewInformCount(userId);
        informDao.close();
        return count;
    }

    public long getInformCount(int informType, int userId) {
        InformDao informDao = new InformDao();
        long count = informDao.getInformCount(informType, userId);
        informDao.close();
        return count;
    }

    public long getInformPageCount(int informType, int userId) {
        long informCount = getInformCount(informType, userId);
        pageCount = informCount%pageSize==0?informCount/pageSize:informCount/pageSize+1;
        return pageCount;
    }

    public List<Inform> getInformList(int informType, int userId) {
        InformDao informDao = new InformDao();
        List<Inform> informList = informDao.getInformList(informType, userId, pageNumber, pageSize);
        informDao.close();
        return informList;
    }

    public boolean addMessage(int userId, String friendMessage) {
        UserDao userDao = new UserDao();
        User user = userDao.getUser(userId);
        if (user == null) {
            userDao.close();
            return false;
        }
        if (friendMessage.length() < 2 || friendMessage.length() > 100) {
            userDao.close();
            return false;
        }
        int informType = Inform.MESSAGE;
        int friendId = (int) ActionContext.getContext().getSession().get("id");
        Inform inform = new Inform();
        inform.setTime(new Date());
        inform.setTreatment(userId == friendId ? 1 : 0);
        inform.setInformType(informType);
        Friend friend = new Friend();
        friend.setFriend(userDao.getUser(friendId));
        inform.setFriend(friend);
        inform.setFriendMessage(friendMessage);
        inform.setUser(user);
        InformDao informDao = new InformDao();
        informDao.addInform(inform);
        informDao.close();
        userDao.close();
        return true;
    }

    private long getInformCount() {
        int userId = (int)ActionContext.getContext().getSession().get("id");
        InformDao informDao = new InformDao();
        long count = informDao.getInformCount(userId);
        informDao.close();
        return count;
    }

    public long getInformPageCount() {
        long informCount = getInformCount();
        pageCount = informCount%pageSize==0?informCount/pageSize:informCount/pageSize+1;
        return pageCount;
    }

    public List<Inform> getInformList() {
        int userId = (int)ActionContext.getContext().getSession().get("id");
        InformDao informDao = new InformDao();
        List<Inform> informList = informDao.getInformList(userId, pageNumber, pageSize);
        for (int i = 0; i < informList.size(); i++) {
            if (informList.get(i).getTreatment() == 0) {
                informDao.updateTreatment(informList.get(i).getId(), 1);
            }
        }
        informDao.close();
        return informList;
    }

}

