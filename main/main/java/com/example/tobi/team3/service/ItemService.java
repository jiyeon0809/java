package com.example.tobi.team3.service;

import com.example.tobi.team3.mapper.ItemMapper;
import com.example.tobi.team3.model.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemMapper itemMapper;

    public List<Item> getItemsByCategory(String category) {
        return itemMapper.getItemListByCategory(category);
    }

    public Item getItemDetail(Long id) {
        return itemMapper.getItemDetail(id);
    }

    public void saveItem(String item, String imagePath, String detail, String seller, String price, String category) {
        Item item1 = Item.builder()
                .item(item)
                .imagePath(imagePath)
                .detail(detail)
                .seller(seller)
                .price(price)
                .category(category)
                .build();
        int result = itemMapper.saveItem(item1);
        if (result > 0) {
            // 성공 처리
            System.out.println("성공함"+result);
            // 필요 시 추가 로직 (예: 알림, 리다이렉트 등)
        } else {
            // 실패 처리
            System.out.println("실패함"+result);
            // 예외 발생 또는 사용자에게 알림
            throw new RuntimeException("Failed to save item.");
        }
    }

    public void editItem(String item, String imagePath, String detail,String price, String category) {
        itemMapper.editItem(
                Item.builder()
                        .item(item)
                        .imagePath(imagePath)
                        .detail(detail)
                        .price(price)
                        .category(category)
                        .build()
        );

    }

    public List<Item> getItemList(Long )
}
