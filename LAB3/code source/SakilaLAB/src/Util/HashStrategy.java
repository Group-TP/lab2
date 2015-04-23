package Util;

import Model.Category;

public class HashStrategy implements ShardingStrategy {

	@Override
	public int getShardId(Category c) {
		return ((Integer) c.getCategoryId()).hashCode() % 4 + 1;
	}

	@Override
	public int getShardId(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
