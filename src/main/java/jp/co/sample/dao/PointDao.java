package jp.co.sample.dao;

import java.util.List;

import jp.co.sample.model.Point;
import jp.co.sample.model.PointHistory;
import jp.co.sample.model.User;
import jp.co.sample.model.mapper.PointMapper;
import jp.co.sample.model.mapper.UserMapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class PointDao {

	private SqlSessionFactory sessionFactory;

	public PointDao() {
		sessionFactory = DaoUtil.getSqlSessionFactory();
	}

	public void addPoint(Point point) {
		
		PointHistory pointHistory = new PointHistory();
		pointHistory.setPoint(point.getPoint());
		pointHistory.setUser_id(point.getUser_id());
		
		SqlSession session = sessionFactory.openSession();
		PointMapper mapper = session.getMapper(PointMapper.class);

		Point result = mapper.selectPoint(point);
		if (result == null) {
			mapper.insertPoint(point);
		} else {
			mapper.updatePoint(point);
		}
		mapper.insertPointHistory(pointHistory);
		
		session.commit();
		session.close();

	}
}
