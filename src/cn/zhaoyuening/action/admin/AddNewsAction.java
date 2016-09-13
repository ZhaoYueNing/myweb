package cn.zhaoyuening.action.admin;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.zhaoyuening.model.News;
import cn.zhaoyuening.service.NewsService;

public class AddNewsAction extends ActionSupport{
	//需要保存的news对象，从jsp页面传递过来
	private News news;
	
	private final String MSG_ADD_RESULT= "add-result";

	
	@Override
	public String execute() throws Exception {
		System.out.println(this.getClass().getSimpleName());
		if (news==null) {
			return SUCCESS;
		}
		NewsService service = new NewsService();
		int count = service.add(news);
		if (count>0) {
			//添加成功
			ActionContext.getContext().put(MSG_ADD_RESULT, "添加失败！");
			System.out.println("添加消息成功");
			news=null;
		}else{
			//添加失败
			ActionContext.getContext().put(MSG_ADD_RESULT, "添加成功！");
			System.out.println("添加消息失败");
		}
		return SUCCESS;
	}

	
	//get&set
	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	
}
