package br.com.platinum.quartzboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class QuartzBootApplication

fun main(args: Array<String>) {
	runApplication<QuartzBootApplication>(*args)
}
