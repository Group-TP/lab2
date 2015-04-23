package Util;

import Model.Category;

public class RangeStrategy implements ShardingStrategy {

	@Override
	public int getShardId(Category c) {
		if (c.getCategoryId() < 5)
			return 1;
		if (c.getCategoryId() < 9)
			return 2;
		if (c.getCategoryId() < 13)
			return 3;
		if (c.getCategoryId() < 17)
			return 4;
		return 1;
	}

	@Override
	public int getShardId(int id) {
		// TODO Auto-generated method stub
		if (id < 5)
			return 1;
		if (id < 9)
			return 2;
		if (id < 13)
			return 3;
		if (id < 17)
			return 4;
		return 1;
	}

}
