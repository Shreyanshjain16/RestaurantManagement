package com.pharmeasy.restaurant

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.slf4j.LoggerFactory


@SpringBootApplication
class RestaurantApplication

fun main(args: Array<String>) {
	runApplication<RestaurantApplication>(*args)
}
