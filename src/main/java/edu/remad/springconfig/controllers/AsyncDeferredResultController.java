package edu.remad.springconfig.controllers;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import edu.remad.springconfig.services.ResourceService;

@Controller
@RequestMapping("/async")
@SessionAttributes("resource")
public class AsyncDeferredResultController {

	@Autowired
	private ResourceService resourceService;
	
	@PostMapping("/upload")
	@ResponseBody
	public String handleUpload(@RequestParam("file") MultipartFile file) {
		
		if(!file.isEmpty()) {
			return "The file size is: " + file.getSize() + ".";
		} else {
			return "The file is empty.";
		}
	}
	
	@GetMapping("/pricing")
	@ResponseBody
	public DeferredResult<String> getPricing() {
		System.out.println("getPricing invoked...");
		
		DeferredResult<String> deferredResult = new DeferredResult<>();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Runnable invoked...");
				
				try {
					Thread.sleep(3000L);
				} catch(InterruptedException ex) {
					ex.printStackTrace();
				}
				
				System.out.println("returning invoked...");
				deferredResult.setResult(String.valueOf(new Random(10).nextInt() + 1));
			}
		}).start();
		System.out.println("getPricing finished...");
		
		return deferredResult;
	}
}
