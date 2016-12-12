package action.user;

import com.opensymphony.xwork2.ActionSupport;
import service.InformService;
import vo.Inform;

import java.util.List;

/**
 * Created by ZouKaifa on 2016/11/29.
 */
public class ShowInformAction extends ActionSupport {
    private long pageNumber;
    private long pageCount;
    private List<Inform> informList;

    public long getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(long pageNumber) {
        this.pageNumber = pageNumber;
    }

    public long getPageCount() {
        return pageCount;
    }

    public void setPageCount(long pageCount) {
        this.pageCount = pageCount;
    }

    public List<Inform> getInformList() {
        return informList;
    }

    public void setInformList(List<Inform> informList) {
        this.informList = informList;
    }

    @Override
    public String execute() throws Exception {
        InformService informService = new InformService();
        pageCount = informService.getInformPageCount();
        pageNumber = informService.getPageNumber(pageNumber);
        informList = informService.getInformList();
        return SUCCESS;
    }
}
