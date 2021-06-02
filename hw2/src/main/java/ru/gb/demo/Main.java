package ru.gb.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import ru.gb.demo.configuration.ApplicationConfiguration;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class Main {
    private final ProductRepository productRepository;
    private final CartFactory cartFactory;

    public Main(ProductRepository productRepository, CartFactory cartFactory) {
        this.productRepository = productRepository;
        this.cartFactory = cartFactory;
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
    }

    @PostConstruct
    public void command() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Cart cart=null;
            while (true) {
                String read = reader.readLine();
                String[] token = read.split(" ");
                System.out.println(read);

                if (cart == null) cart = cartFactory.getCart();

                if (read.startsWith(Command.CREATE_CART)) {
                    cart = cartFactory.getCart();
                }

                if (read.startsWith(Command.ADD_ALL)) {
                    cart.addAll(productRepository.getList());
                }

                if (read.startsWith(Command.REMOVE_ALL)) {
                    cart.removeAll();
                }

                if (read.startsWith(Command.ADD_BI_ID)) {
                    cart.add(productRepository.getProductById(Integer.parseInt(token[1].trim())));
                }

                if (read.startsWith(Command.REMOVE_BI_ID)) {
                    cart.remove(productRepository.getProductById(Integer.parseInt(token[1].trim())));
                }

                System.out.println("Cart: " + cart);
                System.out.println("include: ");
                cart.getList().forEach(it -> System.out.println(it.getId() + " " + it.getTitle() + " " + it.getCost()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
