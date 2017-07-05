package com.aditya.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.aditya.SportsMarketBackend.dao.CategoryDAO;
import com.aditya.SportsMarketBackend.dao.ProductDAO;
import com.aditya.SportsMarketBackend.dto.Category;
import com.aditya.SportsMarketBackend.dto.Product;
import com.aditya.SportsMarketFrontend.exception.ProductNotFoundException;

@Controller
public class PageController
{
	private static final Logger logger=LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
    
	@Autowired
	private ProductDAO productDAO;
    
    @RequestMapping(value={"/","/home","/index"})
	public ModelAndView index()
   {
	   ModelAndView mv=new ModelAndView("page");
	   mv.addObject("title","Home");
	   
	   logger.info("Inside PageController index method - INFO");
	   logger.debug("Inside PageController index method - DEBUG");
	   
	   mv.addObject("categories",categoryDAO.list());
	   
	   mv.addObject("userClickHome",true);
	   return mv;
   }
    
    
    @RequestMapping(value="/register")
	public ModelAndView register()
   {
	   ModelAndView mv=new ModelAndView("page");
	   mv.addObject("title","Register");
	   return mv;
   }
    
    @RequestMapping(value={"contact"})
	public ModelAndView contact()
   {
	   ModelAndView mv=new ModelAndView("page");
	   mv.addObject("title","Contact");
	   mv.addObject("categories",categoryDAO.list());
	   mv.addObject("userClickContact",true);
	   return mv;
   }
    @RequestMapping(value={"/product"})
	public ModelAndView product()
   {
	   ModelAndView mv=new ModelAndView("page");
	   mv.addObject("title","Product");
	   mv.addObject("categories",categoryDAO.list());
	   mv.addObject("userClickProduct",true);
	   return mv;
   }
    
    @RequestMapping(value ="/show/all/products")
	public ModelAndView showallproducts()
     {
    	ModelAndView mv = new ModelAndView("page");		
		mv.addObject("title","All Products");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickAllProducts",true);
		return mv;				
     }

    @RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {		
		ModelAndView mv = new ModelAndView("page");
		
		// categoryDAO to fetch a single category
		Category category = null;
		
		category = categoryDAO.get(id);
		
		mv.addObject("title",category.getName());
		
		//passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		
		// passing the single category object
		mv.addObject("category", category);
		
		mv.addObject("userClickCategoryProducts",true);
		return mv;				
	}
    
    
    
    @RequestMapping(value = "/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException {		
	
     ModelAndView mv = new ModelAndView("page");
    
	 Product product=productDAO.get(id);
	
	 if(product==null) throw new ProductNotFoundException();
	 
	 product.setViews(product.getViews() + 1);
		
     productDAO.update(product);
     
     mv.addObject("title",product.getName());
     mv.addObject("product",product);
     
     mv.addObject("userClickShowProduct",true);
     return mv;
    }
    
    @RequestMapping(value={"/login"})
	public ModelAndView login(@RequestParam(name="error" , required=false)String error ,
			@RequestParam(name="logout" , required=false)String logout)
   {
	   ModelAndView mv=new ModelAndView("login");
	   if(error!=null)
	   {
		   mv.addObject("message","Invalid Username and Password");
	   }
	   
	   if(logout!=null)
	   {
		   mv.addObject("logout","User has successfully logged out!");
	   }
	   
	   mv.addObject("title","Login"); 
	   return mv;
   }
    
   
    @RequestMapping(value="/access-denied")
	public ModelAndView accessdenied()
   {
	   ModelAndView mv=new ModelAndView("error");
	   mv.addObject("title","403 - Access Denied");
	   mv.addObject("errorTitle","Aha! Caught You");
	   mv.addObject("errorDescription","You are not authorized to view this page!");
	   return mv;
   }
    
    @RequestMapping(value="/perform-logout")
    public String logout(HttpServletRequest request,HttpServletResponse response)
    {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	
    	if(auth!=null)
    	{
    		new SecurityContextLogoutHandler().logout(request, response, auth);
    	}
    	return "redirect:/login?logout";
    }
}