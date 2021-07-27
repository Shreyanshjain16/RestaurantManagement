package com.pharmeasy.restaurant.controller

import com.pharmeasy.restaurant.dto.OrderItemDto
import com.pharmeasy.restaurant.model.Order
import com.pharmeasy.restaurant.model.User
import com.pharmeasy.restaurant.services.OrderService
import com.pharmeasy.restaurant.services.UserService
import com.pharmeasy.restaurant.type.OrderStatus
import com.pharmeasy.restaurant.type.UserType
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*
import javax.persistence.Id

//naming the path as per rest standards . Path variable,
@RestController
@RequestMapping()
class OrderController(private val orderService: OrderService,private val userService: UserService) {
    companion object {private val log = LoggerFactory.getLogger(UserController::class.java)}

    @GetMapping("/orders")
    fun getOrders(@RequestParam userId: Long) :List <Order>{
//        var user:User = userService.getUser(userId)
//        if(user.userType== UserType.ADMIN)
        return orderService.getOrders()

    }

    @GetMapping("/orders/{orderStatus}")
    fun getOrdersByStatusType(@PathVariable orderStatus: OrderStatus):List <Order>{
        return orderService.getAllByOrderStatus(orderStatus)
    }


    @PostMapping("/users/{userId}/orders")
    fun placeOrder(@RequestBody itemsList: List<OrderItemDto>, @PathVariable userId: Long): String {
            return orderService.placeOrder(itemsList, userId)
        }


//  //PUT orders/orderId
  @PutMapping("/orders/{orderId}")
        fun acceptOrder(@PathVariable orderId:Long): String {
            return orderService.acceptOrder(orderId)
        }


//@Autowired

}