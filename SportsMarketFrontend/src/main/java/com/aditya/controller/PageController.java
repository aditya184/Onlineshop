package com.aditya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aditya.SportsMarketBackend.dao.CategoryDAO;
import com.aditya.SportsMarketBackend.dto.Category;

@Controller
public class PageController
{
	@Autowired
	private CategoryDAO categoryDAO;

    @RequestMapping(value={"/","/home","/index"})
	public ModelAndView index()
   {
	   ModelAndView mv=new ModelAndView("page");
	   mv.addObject("title","Home");
	   
	   mv.addObject("categories",categoryDAO.list());
	   mv.addObject("userClickHome",true);
	   return mv;
   }
    @RequestMapping(value={"/login"})
	public ModelAndView login()
   {
	   ModelAndView mv=new ModelAndView("page");
	   mv.addObject("title","Login");
	   mv.addObject("userClickLogin",true);
	   return mv;
   }
    
    @RequestMapping(value={"/register"})
	public ModelAndView register()
   {
	   ModelAndView mv=new ModelAndView("page");
	   mv.addObject("title","Register");
	   mv.addObject("userClickRegister",true);
	   return mv;
   }
    @RequestMapping(value={"/contact"})
	public ModelAndView contact()
   {
	   ModelAndView mv=new ModelAndView("page");
	   mv.addObject("title","Contact");
	   mv.addObject("userClickContact",true);
	   return mv;
   }
    @RequestMapping(value={"/product"})
	public ModelAndView product()
   {
	   ModelAndView mv=new ModelAndView("page");
	   mv.addObject("title","Product");
	   mv.addObject("userClickProduct",true);
	   return mv;
   }




@RequestMapping(value="/show/all/products")
public ModelAndView showallproducts()
{
   ModelAndView mv=new ModelAndView("page");
   mv.addObject("title","All Products");
   
   mv.addObject("categories",categoryDAO.list());
   mv.addObject("userClickAllProducts",true);
   return mv;
}

@RequestMapping(value="/show/category/{id}/products")
public ModelAndView showcategoryproducts(@PathVariable("id") int id)
{
   ModelAndView mv=new ModelAndView("page");
   
   Category category=null;
   
   category=categoryDAO.get(id);
   
   mv.addObject("title",category.getName());
   
   mv.addObject("categories",categoryDAO.list());
   
   mv.addObject("category",category);
      
   mv.addObject("userClickCategoryProducts",true);
   return mv;
}

}