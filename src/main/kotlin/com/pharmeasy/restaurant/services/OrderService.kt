package com.pharmeasy.restaurant.services

import com.pharmeasy.restaurant.dto.OrderItemDto
import com.pharmeasy.restaurant.model.Item
import com.pharmeasy.restaurant.model.Order
import com.pharmeasy.restaurant.model.OrderItem
import com.pharmeasy.restaurant.repository.ItemRepository
import com.pharmeasy.restaurant.repository.OrderItemRepository
import com.pharmeasy.restaurant.repository.OrderRepository
import com.pharmeasy.restaurant.type.OrderStatus
import jdk.nashorn.internal.runtime.regexp.joni.Config.log
import org.springframework.stereotype.Service




@Service
class OrderService(private val orderItemRepository: OrderItemRepository, private val orderRepository: OrderRepository,private val itemRepository:ItemRepository) {

    fun getOrders() : List<Order>{
        return orderRepository.findAll()
    }

    fun placeOrder(itemsList: List<OrderItemDto>, userId:Long) : String{

        val order = orderRepository.save(Order(null,userId,OrderStatus.CREATED))

        itemsList.forEach {
            var item = itemRepository.getById(it.itemId)
            orderItemRepository.save(OrderItem(null,order.orderId!!,it.itemId,it.itemQuantity))


        }


        return "Your OrderId is : " +  order.orderId!!   + " Please Keep it for tracking your order "

    }

    fun acceptOrder(itemsList: List<OrderItemDto>,orderId : Long) : String{

        var order= orderRepository.getById(orderId)

        var itemsIdNotInStock = ArrayList<Long>()
        //log.info("The Items not in stock are: ")
        println("The items not in stock are: ")



        itemsList.forEach {
            var a = itemRepository.getById(it.itemId)
//            println(a.itemquantity)

            if (it.itemQuantity > a.itemquantity) {
                itemsIdNotInStock.add(a.itemId!!)
            }else{
                a.itemquantity = a.itemquantity - it.itemQuantity
            }

        }
            var itemsNotAvailable = "Following Items are not Available : "
            var itemNamesNotInStock = ArrayList<String>()


            for (l in itemsIdNotInStock) {
                var b = itemRepository.getById((l))
                itemsNotAvailable += b.itemname + ", "


            }
        order.orderStatus = OrderStatus.ACCEPTED
        orderRepository.save(order)
        var orderUpdateForUser = "Your Order has Been ACCEPTED but $itemsNotAvailable"
        return  orderUpdateForUser ;
    }

//    fun getOrdersByStatusType(orderStatus: OrderStatus): List<Order> {
//        return orderRepository.getAllByorderStatustype(orderStatus)
//
//
//    }

    // Shreyansh :Update The orderItem Status in order_item table




//JUNIT TESTING
}