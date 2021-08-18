package com.lorenzo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lorenzo.models.Customer;
import com.lorenzo.models.PartOrder;
import com.lorenzo.models.Product;
import com.lorenzo.models.Ticket;
import com.lorenzo.repository.CustomerRepo;
import com.lorenzo.serviceimplementation.CustomerServiceImpl;
import com.lorenzo.serviceimplementation.PartOrderServiceImpl;
import com.lorenzo.serviceimplementation.ProductServiceImpl;
import com.lorenzo.serviceimplementation.TicketServiceImpl;

@Controller
public class HomeController {

	
	// Services 
	
	@Autowired
	private CustomerServiceImpl customerServ;
	
	@Autowired
	private TicketServiceImpl ticketServ;
	
	@Autowired
	private ProductServiceImpl productServ;
	
	@Autowired
	private PartOrderServiceImpl partOrderServ;
	
	
											// Controller Mappings
	
	// Home Page
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	
	// Customer Mappings
	
	
	// This is setting up for updating customer
	// This needs to be for showing all customers
	
	/*                          Customers url will have two models attached
	 * a new Customer() called "customer"
	 * a list of customers called "customers"
	 * 
	 * the view resolver will include the list of customers and a button that will show a form to create a new customer
	 * 
	 * in the table "customers" attribute will be used to populate the tables
	 * 
	 * in the form "customer" attribute will be used to create the new customer
	 * 
	 * */
	@GetMapping("/customers")
	public String customersForm(Model model) {
		model.addAttribute("customer", new Customer());
		model.addAttribute("customers", customerServ.findAll());
		return "customers-view";
	}
	
	@PostMapping("/customers")
	  public String customerSubmit(@ModelAttribute Customer customer) {
	    customerServ.save(customer);
	    return "redirect:/customers-view";
	  }
	
	@GetMapping("/customers/{id}")
	public String getCustomer(@PathVariable Long id, Model model) throws Exception {
		model.addAttribute("customer", customerServ.findById(id));
		return "customerupdate";
	}
	
	@PostMapping("/customers/{id}")
	public String updateCustomer(@PathVariable Long id, @ModelAttribute Customer customer) throws Exception {
		Customer dataCustomer = customerServ.findById(id);
		dataCustomer.setEmail(customer.getEmail());
		dataCustomer.setFirstName(customer.getFirstName());
		dataCustomer.setLastName(customer.getLastName());
		customerServ.save(dataCustomer);
		return "redirect:/customers-view";
	}
	
	@RequestMapping(value = "/customers/{id}/remove", method = {RequestMethod.GET, RequestMethod.DELETE})
	public String deleteCustomer(@PathVariable Long id) {
		customerServ.deleteById(id);
		return "redirect:/customers-view";
	}
	
	@GetMapping("/customers-view")
	public String viewCustomers(Model model) {
		model.addAttribute("customers", customerServ.findAll());
		return "customers-view";
	}
	
	// Ticket Mappings
	
	@GetMapping("/tickets")
	public String ticketsForm(Model model) {
		model.addAttribute("ticket", new Ticket());
		return "ticketform";
	}
	
	@PostMapping("/tickets")
	  public String ticketSubmit(@ModelAttribute Ticket ticket) {
	    ticketServ.save(ticket);
	    return "redirect:/tickets-view";
	  }
	
	@GetMapping("/tickets/{id}")
	public String getTicket(@PathVariable Long id, Model model) throws Exception {
		model.addAttribute("ticket", ticketServ.findById(id));
		return "ticketupdate";
	}
	
	@PostMapping("/tickets/{id}")
	public String updateTicket(@PathVariable Long id, @ModelAttribute Ticket ticket) throws Exception {
		Ticket dataTicket = ticketServ.findById(id);
		dataTicket.setRepairType(ticket.getRepairType());
		dataTicket.setDescription(ticket.getDescription());
		ticketServ.save(dataTicket);
		return "redirect:/tickets-view";
	}
	
	@RequestMapping(value = "/tickets/{id}/remove", method = {RequestMethod.GET, RequestMethod.DELETE})
	public String deleteTicket(@PathVariable Long id) {
		ticketServ.deleteById(id);
		return "redirect:/tickets-view";
	}
	
	@GetMapping("/tickets-view")
	public String viewTickets(Model model) {
		model.addAttribute("tickets", ticketServ.findAll());
		return "tickets-view";
	}
	
	// Products Mappings
	
	@GetMapping("/products")
	public String productsForm(Model model) {
		model.addAttribute("product", new Product());
		return "productform";
	}
	
	@PostMapping("/products")
	  public String productSubmit(@ModelAttribute Product product) {
	    productServ.save(product);
	    return "redirect:/products-view";
	  }
	
	@GetMapping("/products/{id}")
	public String getProduct(@PathVariable Long id, Model model) throws Exception {
		model.addAttribute("product", productServ.findById(id));
		return "productupdate";
	}
	
	@PostMapping("/products/{id}")
	public String updateProduct(@PathVariable Long id, @ModelAttribute Product product) throws Exception {
		Product dataProduct = productServ.findById(id);
		dataProduct.setProductName(product.getProductName());
		dataProduct.setProductPrice(product.getProductPrice());
		dataProduct.setProductQuantity((long) product.getProductQuantity());
		productServ.save(dataProduct);
		return "redirect:/products-view";
	}
	
	@RequestMapping(value = "/products/{id}/remove", method = {RequestMethod.GET, RequestMethod.DELETE})
	public String deleteProduct(@PathVariable Long id) {
		productServ.deleteById(id);
		return "redirect:/products-view";
	}
	
	@GetMapping("/products-view")
	public String viewProducts(Model model) {
		model.addAttribute("products", productServ.findAll());
		return "products-view";
	}
	
	// PartOrder Mappings
	
	@GetMapping("/partorders")
	public String partOrderForm(Model model) {
		model.addAttribute("product", new PartOrder());
		return "partorderform";
	}
	
	@PostMapping("/partorders")
	  public String partOrderSubmit(@ModelAttribute PartOrder partOrder) {
	    partOrderServ.save(partOrder);
	    return "redirect:/partorders-view";
	  }
	
	@GetMapping("/partorders/{id}")
	public String getPartOrder(@PathVariable Long id, Model model) throws Exception {
		model.addAttribute("partorder", productServ.findById(id));
		return "partorderupdate";
	}
	
	@PostMapping("/partorders/{id}")
	public String updatePartOrder(@PathVariable Long id, @ModelAttribute PartOrder partOrder) throws Exception {
		PartOrder dataPartOrder = partOrderServ.findById(id);
		dataPartOrder.setPartName(partOrder.getPartName());
		dataPartOrder.setPartPrice(partOrder.getPartPrice());
		dataPartOrder.setPartQuantity((long) partOrder.getPartQuantity());
		partOrderServ.save(dataPartOrder);
		return "redirect:/partorders-view";
	}
	
	@RequestMapping(value = "/partorders/{id}/remove", method = {RequestMethod.GET, RequestMethod.DELETE})
	public String deletePartOrder(@PathVariable Long id) {
		partOrderServ.deleteById(id);
		return "redirect:/partorders-view";
	}
	
	@GetMapping("/partorders-view")
	public String viewPartsOrders(Model model) {
		model.addAttribute("partorders", partOrderServ.findAll());
		return "partorders-view";
	}
	
}
