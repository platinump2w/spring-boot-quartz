package br.com.platinum.quartzboot.service

import br.com.platinum.quartzboot.job.SimpleJob
import org.quartz.JobBuilder
import org.quartz.TriggerBuilder
import org.slf4j.LoggerFactory
import org.springframework.scheduling.quartz.SchedulerFactoryBean
import org.springframework.stereotype.Service
import java.time.Instant
import java.util.*

@Service
class JobServiceImpl(private val schedulerFactory: SchedulerFactoryBean) : JobService {

    private val logger = LoggerFactory.getLogger(JobServiceImpl::class.java)

    override fun scheduleJob() {
        val jobDetail = buildJobDetail()
        val trigger = buildTrigger(Date.from(Instant.now().plusSeconds(30)))

        val scheduledDate = schedulerFactory.scheduler.scheduleJob(jobDetail, trigger)

        logger.info("Job scheduled to run at {}", scheduledDate)
    }

    private fun buildJobDetail() = JobBuilder.newJob(SimpleJob::class.java)
            .storeDurably(false)
            .withIdentity("jobDetail")
            .withDescription("Simple Job").build()

    private fun buildTrigger(startAt: Date) = TriggerBuilder.newTrigger()
            .withIdentity("trigger")
            .forJob(buildJobDetail())
            .startAt(startAt)
            .build()

}
