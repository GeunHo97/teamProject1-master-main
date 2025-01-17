package com.koreait.coffee.view;

import com.koreait.coffee.controller.CategoryController;
import com.koreait.coffee.controller.DishController;
import com.koreait.coffee.controller.ShoppingCartController;
import com.koreait.coffee.model.dto.*;

import java.util.List;
import java.util.Scanner;

public class MenuView {
    public OrderView orderView = new OrderView();
    public Scanner sc = new Scanner(System.in);
    public ShoppingCartController shoppingCartController = new ShoppingCartController();
    public CategoryController categoryController = new CategoryController();
    public DishController dishController = new DishController();

    /**
     * 카테고리 보여주는 메소드
     * @param type
     */
    // 선근호 11-29 21:14 수정
    public void categoryView(Type type){
        while (true){
            System.out.println("=========================");
            System.out.println("        GH Coffee        ");
            System.out.println("=========================");
            for (Category category : categoryController.getAllCategory()) {
                System.out.println(category.getId() + ":" + category.getName());
            }
            System.out.print("번호를 입력하세요 :");
            int choose = 0;
            try {
                choose = sc.nextInt();
            } catch (Exception e) {
                System.out.println("ERROR");
                sc.nextLine();
                continue;
            }

            switch (choose){
            case 1:
                menuView(choose);
                break;
            case 2:
                menuView(choose);
                break;
            case 3:
                menuView(choose);
                break;
            case 4:
                menuView(choose);
                break;
            case 5:
                menuView(choose);
                break;
            case 6:
                menuView(choose);
                break;
            default:
                System.out.println("뒤로가기");
                return;
        }
        }

    }

    /**
     * 내가고른 카테고리 id : 메뉴카테고리이름을 출력하고
     * 메뉴이름 출력
     * @param categoryId
     */
    // 선근호 11-29 21:14 수정
    public void menuView(Integer categoryId){

        while (true) {
            List<Dish> dishesByCategoryId = dishController.getDishesByCategoryId(categoryId);
            Category categoryById = categoryController.getCategoryById(categoryId);
            System.out.println("==========="+ categoryById.getId()+":"+categoryById.getName() +"============");
//          // "==========="+ categoryById.getId() 카테고리번호 +":"+categoryById.getName() 카테고리이름 +"============"
            for (Dish dish : dishesByCategoryId) {
                System.out.println(dish.getId() + ":" + dish.getName());
            }
            System.out.print("번호를 입력하세요 :");
            int choose = sc.nextInt();
            switch (choose){
                case 1:
                    Temperature temperature = orderView.temperatureView();
                    Shot shot = orderView.shotView();
                    Dish dish = dishController.getDishById(choose);
                    dish.setShot(shot);
                    dish.setTemperature(temperature);
                    dishController.addDishFlavor(dish);
                    ShoppingCart shoppingCart = new ShoppingCart();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("뒤로가기");
            }
        }
    }
}


