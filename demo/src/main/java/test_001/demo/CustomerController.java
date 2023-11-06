package test_001.demo;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CustomerController {

    private final List<Customer> customers = new ArrayList<>();
    private long nextCustomerId = 1;

    @GetMapping(path = "/")
    public String index() {
        return "external";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) throws Exception {
        request.logout();
        return "redirect:/";
    }

    @GetMapping(path = "/customers")
    public String customers(Principal principal, Model model) {
        // 직접 데이터 추가
        addCustomers();

        model.addAttribute("customers", customers);
        model.addAttribute("username", principal.getName());
        return "customers";
    }

    public void addCustomers() {
    	customers.clear();
        Customer customer1 = new Customer();
        customer1.setId(nextCustomerId++);
        customer1.setAddress("1111");
        customer1.setName("user1");
        customer1.setServiceRendered("Important services");
        customers.add(customer1);

        Customer customer2 = new Customer();
        customer2.setId(nextCustomerId++);
        customer2.setAddress("1111");
        customer2.setName("admin");
        customer2.setServiceRendered("Important services");
        customers.add(customer2);
    }
}
