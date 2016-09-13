package cn.zhaoyuening.dao;

import javax.sql.DataSource;

import cn.zhaoyuening.utils.JdbcUtils;


public class MyDataSource {
	private static DataSource dSource;

	public static DataSource getdSource() {
		if (dSource==null) {
			JdbcUtils.getDataSource();
		}
		return dSource;
	}

	public static void setdSource(DataSource dSource) {
		MyDataSource.dSource = dSource;
	}
	
}
