package jp.co.sample.model.mapper;

import jp.co.sample.model.Point;
import jp.co.sample.model.PointHistory;

public interface PointMapper {

	public Point selectPoint(Point point);
	public void insertPoint(Point point);
	public void updatePoint(Point point);
	
	public void insertPointHistory(PointHistory pointHistory);
}
