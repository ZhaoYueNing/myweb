package cn.zhaoyuening.action.admin;

import java.util.List;

import cn.zhaoyuening.model.Column;
import cn.zhaoyuening.model.News;
import cn.zhaoyuening.service.NewsService;
import cn.zhaoyuening.utils.MyActionSupport;

import com.opensymphony.xwork2.ActionContext;

public class AddNewsAction extends MyActionSupport{
	//需要保存的news对象，从jsp页面传递过来
	private News news;
	//栏目列表
	private List<Column> columns;
	
	private final String MSG_ADD_RESULT= "addResult";
	private NewsService service;

	public AddNewsAction(){
		service = new NewsService();
		columns = service.getColumns();
	}
	
	
	@Override
	public String execute() throws Exception {
		if (news==null) {			
			ActionContext.getContext().put(MSG_ADD_RESULT, "请添加消息！");
			return SUCCESS;
		}
		int count = service.add(news);
		if (count>0) {
			//添加成功
			ActionContext.getContext().put(MSG_ADD_RESULT, "添加成功！");
			System.out.println("添加消息成功");
			news=null;
		}else{
			//添加失败
			ActionContext.getContext().put(MSG_ADD_RESULT, "添加失败！");
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


	public List<Column> getColumns() {
		return columns;
	}


	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}

	
}
