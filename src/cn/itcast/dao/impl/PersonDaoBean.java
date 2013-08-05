package cn.itcast.dao.impl;

import cn.itcast.dao.PersonDao;

public class PersonDaoBean implements PersonDao {
	/* (non-Javadoc)
	 * @see cn.itcast.dao.impl.PersonDao#add()
	 */
	@Override
	public void add(){
		System.out.println("这是PersonDaoBean Add()方法！");
	}
}
