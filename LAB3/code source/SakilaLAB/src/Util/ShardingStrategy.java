package Util;

import Model.Category;

public interface ShardingStrategy {

	public int getShardId (Category c);
	public int getShardId (int id);
	
}
