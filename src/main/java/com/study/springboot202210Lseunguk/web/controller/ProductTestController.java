package com.study.springboot202210Lseunguk.web.controller;

import com.study.springboot202210Lseunguk.web.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProductTestController {

    @GetMapping("/product/addition")
    public String loadAddition() {
        return "product/product_add";
    }

//    @PostMapping("/api/product") // servlet과 사용방법 동일하게 request사용 방법
//    public String registerProduct(HttpServletRequest request) {
//        System.out.println(request.getParameter("price")); // request.getParameter("price")을 하면 무조건 타입이 String 타입이라서 형변환을 해줘야함 (price값이 integer
//        return "product/product_view";
//    }

//    @PostMapping("/api/product") // 위방법과 동일함
//////    public String registerProduct(@RequestParam("productCode") String pc, @RequestParam("productName") String pn, @RequestParam("price") int p, @RequestParam("stock") int s) {
////  public String registerProduct(int productCode, String productName, int price, int stock) { //변수명과 원래의 변수이름이 같으면 어노테이션을 생략이 가능 ( 하지만 가능한 적는것이 좋다)
//////        System.out.println("상품 코드: "+pc);
//////        System.out.println("상품 이름: "+pn);
//////        System.out.println("가격: "+p);
//////        System.out.println("수량: "+s);
////
////        System.out.println("상품 코드: "+ productCode );
////        System.out.println("상품 이름: "+ productName );
////        System.out.println("가격: "+ price );
////        System.out.println("수량: "+ stock );
////
////
////        return "product/product_view";

    @PostMapping("/api/product") // 위방법과 동일함
    public String registerProduct(Model model, ProductDto productDto) {
//        System.out.println(productDto);
        model.addAttribute("productDto", productDto);


        System.out.println("★★★★★★★★★★★★★★★★★★");
        System.out.println("★상품 등록 현황★");
        System.out.println("★★★★★★★★★★★★★★★★★★");

        System.out.println("상품 코드: "+ productDto.getProductCode());
        System.out.println("상품 이름: "+ productDto.getProductName());
        System.out.println("가     격: "+ productDto.getPrice());
        System.out.println("수     량: "+ productDto.getStock());
        return "product/product_view";
    }

    @GetMapping("/product/addition2")
    public String loadAddition2() {
        return "product/product_add2";
    }

    @ResponseBody // data를 응답할때 사용! 없으면 view응답 = controller에서 데이터가 응답이됨
    @PostMapping("/api/product/2") // 위방법과 동일함
    public String registerProduct(@RequestBody ProductDto productDto) {
        System.out.println(productDto);
//        return productDto.toString();
        return "응답쓰";
    }
}
