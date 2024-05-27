package com.co.tienda.controller;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.co.tienda.dtos.VentaDTO;
import com.co.tienda.mappers.VentaMapper;
import com.co.tienda.models.Venta;
import com.co.tienda.services.VentaService;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/Ventas")
public class VentaController {

    private static final Logger log = 
    LoggerFactory.getLogger(VentaController.class);

    private final VentaService ventaService;
    private final VentaMapper ventaMapper;

    public VentaController(VentaService ventaService, VentaMapper ventaMapper) {
        this.ventaService = ventaService;
        this.ventaMapper = ventaMapper;
    }

    @GetMapping({ "", "/" })
    public String getVenta(Model model) throws Exception {
        try {
        List<Venta> Venta = ventaService.getAllVentas(); 
        log.info("venta: {}", Venta);
        model.addAttribute("venta", Venta);

        return "catalogoVenta/venta";
    } catch (Exception e) {
        log.error(e.getMessage(), e);
        throw e;
    }
    }

    @GetMapping("/registrar")
    public String mostrarPaginaRegistrarVenta(Model model) {
        VentaDTO ventaDto = new VentaDTO();
        model.addAttribute("ventaDto", ventaDto); 


    
        return "listaVenta/registrarVenta";
    }

    @PostMapping("/regitrar")
    public String registrarVenta(@Valid @ModelAttribute("ventaDto") VentaDTO ventaDto, BindingResult result)
            throws Exception {

        if (result.hasErrors()) {
            return "listaVenta/registrarVenta";
        }

        Venta venta = ventaMapper.toVenta(ventaDto);
        ventaService.registrarVenta(null, null, 0);
        return "listaVenta/registrarVenta";
    }



       @GetMapping("/eliminar/{id}")
    public String deleteVenta(@PathVariable("id") Long id,  Model model){
        try {
            ventaService.deleteVenta(id);
            model.addAttribute("clase", "success");
            model.addAttribute("mensaje", "Venta se ha eliminado correctamente");
        } catch (Exception e) {
            model.addAttribute("clase", "danger");
            model.addAttribute("mensaje", "Venta no se ha eliminado correctamente");
        }

        return "redirect:/ventas/";
}

}

