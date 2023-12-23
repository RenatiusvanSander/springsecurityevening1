package edu.remad.springconfig.controllers;

import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Controller
@RequestMapping("/sse")
public class ResponseBodyEmitterWithServerEventsController {

	@RequestMapping("/sseTest")
	public ResponseBodyEmitter handleRequest() {

		final SseEmitter emitter = new SseEmitter();
		ExecutorService service = Executors.newSingleThreadExecutor();
		service.execute(() -> {
			for (int i = 0; i < 500; i++) {
				try {
					emitter.send(LocalTime.now().toString(), MediaType.TEXT_PLAIN);

					Thread.sleep(200);
				} catch (Exception e) {
					e.printStackTrace();
					emitter.completeWithError(e);
					return;
				}
			}
			emitter.complete();
		});

		return emitter;
	}
}
