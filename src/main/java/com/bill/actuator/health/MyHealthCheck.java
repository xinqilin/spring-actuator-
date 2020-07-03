package com.bill.actuator.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;


@Component
public class MyHealthCheck implements HealthIndicator{

	@Override
	public Health health() {
		
		//		自訂義檢查方法 do sth.....後 return 
		// TODO Auto-generated method stub
		//return Health.up().build();  代表正常
		return Health.down().withDetail("msg", "服務異常").build();
	}

}
