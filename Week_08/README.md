学习笔记

### 1. 设计对前面的订单表数据进行水平分库分表，拆分 2 个库，每个库 16 张表。并在新结构在演示常见的增删改查操作。代码、sql 和配置文件

在czh-geek-shardingsphere-demo中的单元测试类SeparateDBAndTableTests


### 2. 基于 hmily TCC 或 ShardingSphere 的 Atomikos XA 实现一个简单的分布式事务应用 demo（二选一）
使用ShardingSphere 的 Atomikos XA实现分布式事务，在项目spring-cloud-demo中。

* xa-account
	* 支付时，修改账户余额
* xa-order
	* 支付时，修改订单状态为已支付
* xa-pay
	* 调用支付接口：http://localhost:8764/payThrow?orderId=1&accountId=1&balance=100 
	* 支付时，抛出运行时异常模拟支付服务异常
	* 修改账户余额、订单状态应该都不生效