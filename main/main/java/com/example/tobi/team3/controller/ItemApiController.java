package com.example.tobi.team3.controller;

import com.example.tobi.team3.dto.ItemDetailResponseDTO;
import com.example.tobi.team3.model.Item;
import com.example.tobi.team3.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ItemApiController {

    private final ItemService itemService;

    @GetMapping("/main/category")
    public ResponseEntity<List<Item>> getItemsByCategory(@RequestParam("category") String category) {
        List<Item> itemList = itemService.getItemsByCategory(category);

        return ResponseEntity.ok(itemList);
    }

    @GetMapping("/main/category/{id}")
    public ItemDetailResponseDTO getItemDetail(@PathVariable("id") Long id) {
        System.out.println("id :: " + id);
        Item itemDetail = itemService.getItemDetail(id);
        return ItemDetailResponseDTO.builder()
                .id(itemDetail.getId())
                .item(itemDetail.getItem())
                .price(itemDetail.getPrice())
                .detail(itemDetail.getDetail())
                .seller(itemDetail.getSeller())
                .category(itemDetail.getCategory())
                .build();
    }



    @PostMapping("/addItem")
    public ResponseEntity<String> uploadImage(
            @RequestParam("image") MultipartFile file,
            @RequestParam("item") String item,
            @RequestParam("detail") String detail,
            @RequestParam("seller") String seller,
            @RequestParam("price") String price,
            @RequestParam("category") String category) {

        String uploadDir = "C:\\Users\\pc\\Desktop\\images";
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs(); // 경로가 없으면 생성
        }

        try {
            if (file.isEmpty()) {
                throw new IOException("파일이 비어 있습니다."); // 예외 발생
            }
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            File targetFile = new File(uploadDir, fileName);
            file.transferTo(targetFile);

            itemService.saveItem(item, "/uploads/" + fileName, detail, seller ,price,category);
            return ResponseEntity.ok("파일 업로드 성공"); // 성공 메시지 반환
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("파일 업로드 오류: " + e.getMessage());
        }
    }

    @PutMapping("itemList/editItem")
    public ResponseEntity<Void> editItem(
            @RequestParam("editItem") String editItem,
            @RequestParam("editPrice") String editPrice,
            @RequestParam("editDetail") String editDetail,
            @RequestParam("editImage") String editImage,
            @RequestParam("editSelectBar") String category
    ){
        itemService.editItem(editItem,editPrice,editDetail,editImage, category);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/itemList")
    public String getUserItems(Model model, Principal principal) {
        // 현재 로그인한 사용자 이름을 가져옴
        String userName = principal.getName();

        // 사용자가 등록한 상품 리스트를 가져옴
        List<Item> items = itemService.getItemList(userName);

        // 모델에 상품 리스트 추가
        model.addAttribute("items", items);

        return "itemList"; // Thymeleaf 템플릿 이름
    }



}
