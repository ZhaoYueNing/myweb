package cn.zhaoyuening.action;

import java.sql.SQLException;
import java.util.List;

import cn.zhaoyuening.model.Column;
import cn.zhaoyuening.model.News;
import cn.zhaoyuening.service.NewsService;
import cn.zhaoyuening.utils.MyActionSupport;
/**
 * 获取资讯
 * @author Zhao
 *
 */
public class GetNewsAction extends MyActionSupport {
	private final static String LOOKNEWS = "looknews"; 
	private Column column;
	private NewsService service ;
	private List<News> newsList;
	private int newsId;
	private News news;
	//栏目列表
	private List<Column> columns;
	
	public GetNewsAction() {
		service = new NewsService();		
		columns = service.getColumns();
	}
	
	//获得资讯列表
	@Override
	public String execute() throws Exception {
		
		if (column==null||column.getName()==null) {
			//选择默认栏目
			column=Column.getDefalultColumn();
		} else{
			//获取该栏目的所有资讯
			newsList = service.getList(column);			
		}
		return super.execute();
	}
	//返回文章
	public String lookNews() throws SQLException{
		news = service.get(this.newsId);
		if(news==null) {
			//如果没有该新闻返回首页
			return SUCCESS;
		}
		return LOOKNEWS;
	}
	
	public Column getColumn() {
		return column;
	}

	public void setColumn(Column column) {
		this.column = column;
	}
	
	public List<News> getNewsList() {
		return newsList;
	}
	
	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}

	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

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
