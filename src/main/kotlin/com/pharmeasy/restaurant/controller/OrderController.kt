package com.pharmeasy.restaurant.controller

import com.pharmeasy.restaurant.dto.OrderItemDto
import com.pharmeasy.restaurant.model.Order
import com.pharmeasy.restaurant.services.OrderService
import com.pharmeasy.restaurant.type.OrderStatus
import org.springframework.web.bind.annotation.*
import javax.persistence.Id

//naming the path as per rest standards . Path variable,
@RestController
@RequestMapping()
class OrderController(private val orderService: OrderService) {

    @GetMapping("/orders")
    fun getOrders() :List <Order>{
        return orderService.getOrders()
    }
//
//    @GetMapping("/orders/{orderStatus}")
//    fun getOrdersByStatusType(orderStatus: OrderStatus):List <Order>{
//        return orderService.getOrdersByStatusType(orderStatus)
//    }


    @PostMapping("/users/{userId}/orders")
    fun placeOrder(@RequestBody itemsList: List<OrderItemDto>, @PathVariable userId: Long): String {
            return orderService.placeOrder(itemsList, userId)
        }


//  //PUT orders/orderId
  @PutMapping("/orders/{orderId}")
        fun acceptOrder(@RequestBody itemsList: List<OrderItemDto>,@PathVariable orderId:Long): String {
            return orderService.acceptOrder(itemsList,orderId)
        }


//@Autowired

}