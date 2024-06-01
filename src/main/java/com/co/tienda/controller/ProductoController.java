package com.co.tienda.controller;

import java.util.List;
import java.util.Map;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.co.tienda.dtos.ProductoDTO;
import com.co.tienda.mappers.ProductoMapper;
import com.co.tienda.models.Producto;
import com.co.tienda.services.ProductoService;
import jakarta.validation.Valid;
import java.util.HashMap;
 



@Controller
@RequestMapping("/productos")
public class ProductoController {
    private static final Logger log = 
    LoggerFactory.getLogger(ProductoController.class);
    private final ProductoService productoService;
    private final ProductoMapper productoMapper;
    
 
   

    public ProductoController(ProductoService productoService,     ProductoMapper productoMapper) {
        this.productoService = productoService;
        this.productoMapper = productoMapper;
    }
    @GetMapping({ "", "/" })
    public String getProducto(Model model) throws Exception {
      try{
        List<Producto> producto = productoService.getAllProducto();
        log.info("productos: {}", producto);
        model.addAttribute("productos", producto);
        return "catalogoProductos/producto";
    } catch (Exception e) {
        log.error(e.getMessage(), e);
        throw e;
    }    }

    @GetMapping("/crear")
    public String mostrarPaginaCrearProducto(Model model) {
        ProductoDTO productoDto = new ProductoDTO();
        model.addAttribute("productoDto", productoDto);
      
        String[] opciones = { "Alimentos", "Tenis", "Pantalones",
         "Camisetas", "Telefonos", "Computadores" };
         model.addAttribute("opciones", opciones);
      
         String[] opciones2 = { "NO", "SI" };
        model.addAttribute("opciones2", opciones2);
      
        return "catalogoProductos/crearProducto";
    }

    @PostMapping("/crear")
    public String addProducto(@Valid @ModelAttribute("productoDto") ProductoDTO productoDto, BindingResult result)
            throws Exception {
        if (result.hasErrors()) {
            return "catalogoProductos/crearProducto";
        }
        Producto producto = productoMapper.toProducto(productoDto);
        productoService.updateProducto(producto);
        return "catalogoProductos/crearProducto";
    }

    @GetMapping("/editar/{id}")
    public String mostrarPaginaEditarProducto(@PathVariable("id") Long id,  Model model) throws Exception {
        ProductoDTO productoDto = new ProductoDTO();
        Producto producto = productoService.getProductoById(id);
        productoDto = productoMapper.toproductoDTO(producto);
        model.addAttribute("productoDto", productoDto);
        return "catalogoProductos/editarProducto";
    }
@PostMapping("/editar/{id}")
    public String updateProducto(@Valid @ModelAttribute("productoDto") ProductoDTO productoDto, BindingResult result, Model model, RedirectAttributes flash, @PathVariable("id") Long id ) throws Exception {
        
        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(err -> {
                errores.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
            });
            model.addAttribute("errores", errores);
            model.addAttribute("productoDto", productoDto);
        }

        Producto producto = productoMapper.toProducto(productoDto);
        productoService.updateProducto(producto);

        model.addAttribute("clase", "success");
        model.addAttribute("mensaje", "Producto actualizado correctamente");
        return "catalogoProductos/editarProducto";
    }


    @GetMapping("/eliminar/{id}")
    public String deleteProducto(@PathVariable("id") Long id,  Model model){
        try {
            productoService.deleteProducto(id);
            model.addAttribute("clase", "success");
            model.addAttribute("mensaje", "Producto se ha eliminado correctamente");
        } catch (Exception e) {
            model.addAttribute("clase", "danger");
            model.addAttribute("mensaje", "Prueba");
        }

        return "redirect:/productos/";
        
}


}