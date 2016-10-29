package service;

/**
 * 服务基类，含有一些对页码的处理
 * Created by ZouKaifa on 2016/10/29.
 */
public class BasicService {
    protected final int pageSize = 5;  //一页的帖子数
    protected long pageNumber;  //页码
    protected long pageCount;  //总页数

    /**
     * 对页码进行容错
     * @param pageNumber
     * @return
     */
    public long getPageNumber(long pageNumber) {
        if (pageNumber <= 0) {
            this.pageNumber = 1;
        } else if (pageNumber > pageCount){
            this.pageNumber = pageCount;
        } else {
            this.pageNumber = pageNumber;
        }
        return this.pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }
}
