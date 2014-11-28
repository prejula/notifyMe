package org.prej.noti.service.message;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.prej.noti.message.MessageInfo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
@RequestMapping("/GetMessageInfo")
public class GetMessageInfo {

	private ExecutorService executorService = null;

	@PostConstruct
	public void init() {
		executorService = Executors.newFixedThreadPool(100);

	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public DeferredResult<MessageInfo> getMessageInfo(
			@RequestParam(required = true) String msgId) {
		System.out.println("Message Id received is: " + msgId);

		DeferredResult<MessageInfo> deferredResult = new DeferredResult<MessageInfo>();

		getNotiMessageInfo(msgId, deferredResult);

		return deferredResult;
	}

	private void getNotiMessageInfo(final String msgId,
			final DeferredResult<MessageInfo> deferredResult) {

		executorService
				.execute(new GetMessageInfoThread(msgId, deferredResult));

	}

	@PreDestroy
	private void shutDownExecutorService() {

		System.out.println("shutdown in progress");
		executorService.shutdown();

		try {
			executorService.awaitTermination(0, null);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private class GetMessageInfoThread implements Runnable {
		private String msgId = null;
		private DeferredResult<MessageInfo> deferredResult = null;

		GetMessageInfoThread(String msgId,
				DeferredResult<MessageInfo> deferredResult) {
			this.deferredResult = deferredResult;
			this.msgId = msgId;
		}

		@Override
		public void run() {

			MessageInfo message = new MessageInfo();
			message.setMsgId(msgId);

			System.out.println("setting result for Id : " + msgId);

			deferredResult.setResult(message);
		}

	}
}
