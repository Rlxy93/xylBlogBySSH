package Controller;

import Entity.Comment;
import Service.impl.ContentServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

public class ContentAction extends ActionSupport {

    private ContentServiceImpl contentServiceimpl;

    public void setContentServiceimpl(ContentServiceImpl contentServiceimpl) {
        this.contentServiceimpl = contentServiceimpl;
    }

    private String commentListById = "";

    private Boolean isComment = false;

    private String BlogListCategory = "";

    private String blogContent = "";

    public String getBlogContent() {
        return blogContent;
    }

    public String getBlogListCategory() {
        return BlogListCategory;
    }

    public Boolean getComment() {
        return isComment;
    }

    public String getCommentListById() {
        return commentListById;
    }

    public String getCommentListByBlogId() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String blogId = request.getParameter("id");
        commentListById = contentServiceimpl.getCommentListByBlogId(blogId);
        return "getCommentListByBlogId";
    }

    public String addComment() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String commentJson = request.getParameter("comment");
        JSONObject jsonObject = JSONObject.fromObject(commentJson);
        Comment comment = (Comment) JSONObject.toBean(jsonObject, Comment.class);
        isComment = contentServiceimpl.addComment(comment);
        return "addComment";
    }

    public String getBlog() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String blogId = request.getParameter("id");
        blogContent = contentServiceimpl.getBlog(blogId);
        return "getBlog";
    }
}
