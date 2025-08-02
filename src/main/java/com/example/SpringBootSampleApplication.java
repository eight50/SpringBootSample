package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  Spring Bootアプリケーションのエントリポイント。
 *  同じ階層以下のファイルしか探索しないため注意。探索範囲を拡張するか、同じ階層以下に参照するファイルを配置する。
 */

@SpringBootApplication
public class SpringBootSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSampleApplication.class, args);
	}

}
