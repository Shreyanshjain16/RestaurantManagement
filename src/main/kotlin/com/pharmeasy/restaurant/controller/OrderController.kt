package com.pharmeasy.restaurant.controller

import com.pharmeasy.restaurant.dto.OrderItemDto
import com.pharmeasy.restaurant.exception.ErrorResponse
import com.pharmeasy.restaurant.services.OrderService
import com.pharmeasy.restaurant.services.UserService
import com.pharmeasy.restaurant.type.OrderStatus
import com.pharmeasy.restaurant.type.UserType
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


//JUNIT testcase mockito
//naming the path as per rest standards . Path variable,
@RestController
@RequestMapping("/orders")
class OrderController(private val orderService: OrderService, private val userService: UserService) {
    companion object {
        private val log = LoggerFactory.getLogger(UserController::class.java)
    }

    @GetMapping()
    fun getOrders(@RequestHeader userId: Long): ResponseEntity<Any> {
        try {
            userService.authorize(userId, listOf(UserType.ADMIN))
            return ResponseEntity(orderService.getOrders(), HttpStatus.OK) //200 //http status codes
        } catch (e: Exception) {
            return ResponseEntity(ErrorResponse(e.message!!, "Get Order API failed"), HttpStatus.BAD_REQUEST)
        }

    }

    @GetMapping("/{orderStatus}")
    fun getOrdersByStatusType(
        @PathVariable orderStatus: OrderStatus,
        @RequestHeader userId: Long
    ): ResponseEntity<Any> {
        try {
            userService.authorize(userId, listOf(UserType.ADMIN))
            return ResponseEntity(orderService.getAllByOrderStatus(orderStatus), HttpStatus.OK)
        } catch (e: Exception) {
            return ResponseEntity(ErrorResponse(e.message!!, "Get Order API failed for getting order list by order status"), HttpStatus.BAD_REQUEST)
        }

    }


    @PostMapping()
    fun placeOrder(@RequestBody itemsList: List<OrderItemDto>, @RequestHeader userId: Long): String {

        return orderService.placeOrder(itemsList, userId)
    }


    //  //PUT orders/orderId
    @PutMapping("/{orderId}")
    fun acceptOrder(@PathVariable orderId: Long, @RequestHeader userId: Long): ResponseEntity<Any> {
        try{
            userService.authorize(userId, listOf(UserType.ADMIN))
            orderService.orderStatusCheck(orderId,listOf(OrderStatus.ACCEPTED,OrderStatus.FAILED))
            return ResponseEntity(orderService.acceptOrder(orderId),HttpStatus.OK)
        }
        catch (e: Exception) {
            return ResponseEntity(ErrorResponse(e.message!!, "Put Order API failed used for accepting/rejecting order"), HttpStatus.BAD_REQUEST)
        }
    }





//@Autowired


}