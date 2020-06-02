package M4.ProductManagement.controller;

import M4.ProductManagement.model.Product;
import M4.ProductManagement.service.IProductService;
import M4.ProductManagement.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @GetMapping("/")
    public ModelAndView index() {
        List<Product> productList = iProductService.findAll();
        ModelAndView modelAndView = new ModelAndView("product/index");
        modelAndView.addObject("products", productList);
        return modelAndView;
    }
    @GetMapping("/product/create")
    public ModelAndView create(){
        ModelAndView modelAndView=new ModelAndView("product/create");
        modelAndView.addObject("product",new Product());
        return modelAndView;
    }
    @PostMapping("/product/save")
    public ModelAndView save(Product product, RedirectAttributes redirectAttributes){
        product.setId((int)(Math.random()*10000));
        iProductService.save(product);
        redirectAttributes.addFlashAttribute("success","Saved Product successfuly !");
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        return modelAndView;
    }
    @GetMapping("/product/{id}/edit")
    public ModelAndView edit(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("product/edit");
        modelAndView.addObject("product",iProductService.findById(id));
        return modelAndView;
    }
    @PostMapping("/product/update")
    public ModelAndView update(Product product,RedirectAttributes redirectAttributes){
        iProductService.update(product.getId(),product);
        redirectAttributes.addFlashAttribute("success","Modified product sucessful !");
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        return modelAndView;
    }
    @GetMapping("/product/{id}/delete")
    public ModelAndView delete(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("product/delete");
        modelAndView.addObject("product", iProductService.findById(id));
        return modelAndView;
    }
    @PostMapping("/product/delete")
    public ModelAndView delete(Product product,RedirectAttributes redirectAttributes){
        iProductService.delete(product.getId());
        redirectAttributes.addFlashAttribute("success", "Removed Product Successful ! ");
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        return modelAndView;
    }
    @GetMapping("/product/{id}/view")
    public ModelAndView view (@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("product/view");
        modelAndView.addObject("product",iProductService.findById(id));
        return modelAndView;
    }


}
