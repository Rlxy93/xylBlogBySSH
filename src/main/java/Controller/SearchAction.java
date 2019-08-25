package Controller;

import Service.impl.SearchServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

public class SearchAction extends ActionSupport {

    private String searchBlog = "";

    public String getSearchBlog() {
        return searchBlog;
    }

    private SearchServiceImpl searchServiceimpl;

    public void setSearchServiceimpl(SearchServiceImpl searchServiceimpl) {
        this.searchServiceimpl = searchServiceimpl;
    }

    public String searchBlogList() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String searchContent = request.getParameter("searchContent");
        try {
            searchContent = new String(request.getParameter("searchContent").getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        searchBlog = searchServiceimpl.searchBlogList(searchContent);
        return "searchBlogList";
    }
}
