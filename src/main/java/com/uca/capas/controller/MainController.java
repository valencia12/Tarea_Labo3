package com.uca.capas.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Product;
import com.uca.capas.domain.Student;

@Controller
public class MainController {
	private ArrayList<Product> components = new ArrayList<Product>();
	private List<Student> students = new ArrayList<Student>();
	

	
	@GetMapping("/compraProducto")
	public ModelAndView compraProducto() {
		
		ModelAndView mav1 = new ModelAndView();
		
		components.add(new Product(0, "Nike Air Zoom Pegasus 37 ", 10));
		components.add(new Product(1, "Nike Daybreak-Type", 20));
		components.add(new Product(2, "Air Jordan 4 Retro", 20));
		components.add(new Product(3, "KD13 Chill", 20));	
		components.add(new Product(4, "Nike Air Zoom Winflo 7", 2)); 
		components.add(new Product(5, "Nike React Metcon", 5));
		components.add(new Product(6, "LeBron 17", 5));
		components.add(new Product(7, "Adidas peradator Z", 5));
		
		mav1.setViewName("componentes");
		
		
		mav1.addObject("product", new Product());
		
		
		
		mav1.addObject("producto", components);
		
		
		return mav1;
		
	}
	@PostMapping("/validar")
	@ResponseBody
	public ModelAndView validarDato(Product componente) {
		ModelAndView mav = new ModelAndView();
		
		if(components.get(componente.getId()).getCantidad() < componente.getCantidad()) {
			
			mav.setViewName("/error");
		
		}else {mav.setViewName("/compra");}
		
		mav.addObject("item", components.get(componente.getId()).getNombre());
		
		return mav;
	}
	

}
