package org.boli.myweb.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MyTask {

	private static final Logger logger = LoggerFactory.getLogger(MyTask.class);

	/**
	 * {@link Async @Async}标注的方法将异步执行
	 */
	@Async
	public void startMyTask() {
		logger.info("my async task start...");

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			logger.error("my async task failed: ", e);
		}

		logger.info("my async task end.");

	}

}
