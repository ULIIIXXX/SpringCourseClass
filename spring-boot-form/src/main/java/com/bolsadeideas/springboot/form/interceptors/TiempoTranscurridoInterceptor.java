package com.bolsadeideas.springboot.form.interceptors;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component("tiempoTranscurridoInterceptor")
public class TiempoTranscurridoInterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(TiempoTranscurridoInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if (request.getMethod().equalsIgnoreCase("post")) {
			return true;
		}

		logger.info("TiempoTranscurridoInterceptor: preHandle() entrando...");
		long tiempoInicio = System.currentTimeMillis();
		request.setAttribute("tiempoIniico", tiempoInicio);

		Random random = new Random();
		Integer demora = random.nextInt(50);
		Thread.sleep(demora);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		if (request.getMethod().equalsIgnoreCase("post")) {
			return; //asi se retorna un void
		}

		long tiempoFin = System.currentTimeMillis();
		long tiempoInicio = (Long) request.getAttribute("tiempoIniico");
		long tiempoTranscurrido = tiempoFin - tiempoInicio;

		if (modelAndView != null) {
			modelAndView.addObject("tiempoTranscurrido", tiempoTranscurrido);
		}
		logger.info("TiempoTranscurrido: " + tiempoTranscurrido + "milisegundos");
		logger.info("TiempoTranscurridoInterceptor: preHandle() saliendo...");

	}

}
