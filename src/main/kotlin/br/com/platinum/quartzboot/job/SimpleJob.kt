package br.com.platinum.quartzboot.job

import org.quartz.JobExecutionContext
import org.slf4j.LoggerFactory
import org.springframework.scheduling.quartz.QuartzJobBean
import org.springframework.stereotype.Component

@Component
class SimpleJob : QuartzJobBean() {

    private val logger = LoggerFactory.getLogger(SimpleJob::class.java)

    override fun executeInternal(jobExecutionContext: JobExecutionContext) {
        logger.info("Executing SimpleJob")
    }

}
