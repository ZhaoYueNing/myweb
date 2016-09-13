 package cn.zhaoyuening.service;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;

import org.junit.Test;

import cn.zhaoyuening.dao.NewsDao;
import cn.zhaoyuening.model.Column;
import cn.zhaoyuening.model.News;
import cn.zhaoyuening.utils.ToolSet;

public class NewsService {
	private static NewsDao dao;
	//栏目列表
	private static List<Column> columns;
	
	public NewsService() {
		dao = new NewsDao();
		if (columns == null) {
			columns = new ArrayList<Column>();
			ResourceBundle bundle = ResourceBundle.getBundle("column");
			Enumeration<String> keys = bundle.getKeys();
			while(keys.hasMoreElements()){
				String otherName = keys.nextElement();
				Column column = new Column();
				column.setOtherName(otherName);
				column.setName(bundle.getString(otherName));
				columns.add(column);
			}
		}
	}
	public static List<News> getList(Column column) throws SQLException{
		return dao.getList(column);
	}
	public News get(int newsId) throws SQLException {		
		return dao.get(newsId);
	}
	
	
	public static List<Column> getColumns() {
		return columns;
	}
	public static void setColumns(List<Column> columns) {
		NewsService.columns = columns;
	}
	/**
	 * 
	 * @param news
	 * @return 返回0添加失败
	 * @throws SQLException
	 */
	public int add(News news) throws SQLException{
		//判断news是否符合条件
		boolean bol = ToolSet.isEmpty(news.getTitle());
		if (bol) {
			return 0;
		}
		return dao.add(news);
	}
	
	@Test
	public void testName() throws Exception {
		NewsService service = new NewsService();
		
	}
}
