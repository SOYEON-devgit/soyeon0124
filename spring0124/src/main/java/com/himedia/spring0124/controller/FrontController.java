package com.himedia.spring0124.controller;

import com.himedia.spring0124.dto.Product;
import com.himedia.spring0124.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FrontController {

    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/")
    public String index(Model model) {
        System.out.println("main 페이지 실행");

        // 서버가 실행되서 메인페이지가 열릴 때 db에서 id를 기준으로 1~4 가져오깅
        // 디비에서 데이터가 4개 혹은 전체 가져와서(findAll()) 4개만 main.html로 보내기
        List<Product> products = productRepository.findTop4By();

        // 반복문 for-each
        // products 가지고 있는 개수만큼 자동으로 반복
        for(Product item : products){
            System.out.println(item.getName());
        }

        model.addAttribute("products", products);

        model.addAttribute("imageName"
                ,"인사이드아웃.jpeg");



        return "main";
    }
}
