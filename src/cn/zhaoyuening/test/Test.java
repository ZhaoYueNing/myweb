package cn.zhaoyuening.test;

import java.util.List;

import cn.zhaoyuening.dao.NewsDao;
import cn.zhaoyuening.model.Column;
import cn.zhaoyuening.model.News;
import cn.zhaoyuening.utils.JdbcUtils;

public class Test {
	@org.junit.Test
	public void connectSql() throws Exception {
		JdbcUtils.getConnection();
	}
	@org.junit.Test
	public void testGetNewsList() throws Exception {
		NewsDao dao = new NewsDao();
		List<News> newsList = dao.getList(new Column("sports"));
		System.out.println(newsList);
	}
}
