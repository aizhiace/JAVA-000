CREATE TABLE `order_master_brief` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `no` varchar(255) DEFAULT NULL COMMENT '订单号',
  `order_status` tinyint(255) DEFAULT NULL COMMENT '订单状态：1-未支付，2-已支付',
  `customer_id` int(11) DEFAULT NULL COMMENT '下单人id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `account_brief` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `balance` varchar(255) DEFAULT NULL COMMENT '余额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
