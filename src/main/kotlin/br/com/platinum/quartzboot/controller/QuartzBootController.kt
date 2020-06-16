package br.com.platinum.quartzboot.controller

import br.com.platinum.quartzboot.service.JobService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class QuartzBootController(private val jobService: JobService) {

    @PostMapping("/schedule")
    fun scheduleJob() {
        jobService.scheduleJob()
    }

}
