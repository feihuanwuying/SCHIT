package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import util.FileHandler;

import java.io.File;

/**
 * Created by ZouKaifa on 2016/11/11.
 */
public class TestImgAction extends ActionSupport {
    private File file;
    private String fileFileName;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    @Override
    public String execute() throws Exception {
        String username = (String)ActionContext.getContext().getSession().get("username");
        String fileType = fileFileName.substring(fileFileName.lastIndexOf("."));
        String fileName = ServletActionContext.getServletContext().getRealPath(
                File.separator)+"/img/"+username.hashCode()+fileType;
        FileHandler.saveFile(fileName, file);
        return SUCCESS;
    }
}
