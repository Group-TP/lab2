package Util;

import org.hibernate.shards.ShardId;
import org.hibernate.shards.loadbalance.RoundRobinShardLoadBalancer;
import org.hibernate.shards.strategy.selection.RoundRobinShardSelectionStrategy;

import Model.Category;
import Model.Payment;

public class ShardSelectionStrategy extends RoundRobinShardSelectionStrategy {

	ShardingStrategy sharding = null;
	public ShardSelectionStrategy(RoundRobinShardLoadBalancer loadBalancer) {
		super(loadBalancer);
	}

	
	@Override
	public ShardId selectShardIdForNewObject(Object obj) {
		if (obj instanceof Category) {
			ShardId id = new ShardId(sharding.getShardId((Category) obj));
			return id;
		}
		return super.selectShardIdForNewObject(obj);
	}
}
