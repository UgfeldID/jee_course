package ru.ugfeld.id.lec6.controllers;

import org.springframework.web.servlet.ModelAndView;

public class BaseController {

	protected ModelAndView getExceptionModelAndView ( String errorMessage ){
		ModelAndView mav = new ModelAndView( "error" );
		mav.addObject("error", errorMessage);
		return mav;
	}
}
