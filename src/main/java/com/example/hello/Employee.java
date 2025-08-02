package com.example.hello;

import lombok.Data;

/**
 * @Data : Lombokのアノテーション。getter,setter,equals,hashCode,toStringを自動生成する。
 */
@Data
public class Employee {
	private String employeeId;
	private String employeeName;
	private Integer employeeAge;
}
