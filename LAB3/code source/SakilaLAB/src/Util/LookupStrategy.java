package Util;

import Model.Category;

public class LookupStrategy implements ShardingStrategy {

	@Override
	public int getShardId(Category c) {
		return c.getCategoryId()%4 + 1;
	}

	@Override
	public int getShardId(int id) {
		return id%4 + 1;
	}

}
