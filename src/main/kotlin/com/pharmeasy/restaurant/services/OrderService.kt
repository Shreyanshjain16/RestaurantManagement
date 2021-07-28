package com.pharmeasy.restaurant.services

import com.pharmeasy.restaurant.dto.OrderItemDto
import com.pharmeasy.restaurant.exception.RequestException
import com.pharmeasy.restaurant.model.Order
import com.pharmeasy.restaurant.model.OrderItem
import com.pharmeasy.restaurant.repository.ItemRepository
import com.pharmeasy.restaurant.repository.OrderItemRepository
import com.pharmeasy.restaurant.repository.OrderRepository
import com.pharmeasy.restaurant.type.OrderItemStatus
import com.pharmeasy.restaurant.type.OrderStatus
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service


@Service
class OrderService(
    private val orderItemRepository: OrderItemRepository,
    private val orderRepository: OrderRepository,
    private val itemRepository: ItemRepository
) {

    fun getOrders(): List<Order> {
        return orderRepository.findAll()
    }

    fun getOrder(orderId: Long) : Order {
        return orderRepository.getById(orderId)
    }

    fun placeOrder(itemsList: List<OrderItemDto>, userId: Long): String {
        val order = orderRepository.save(Order(null, userId, OrderStatus.CREATED))
        var itemsNotAvailable = "We don't have following "
        itemsList.forEach {
            val item = itemRepository.findByIdOrNull(it.itemId)
            if (item != null) {
                orderItemRepository.save(
                    OrderItem(null, order.orderId!!, it.itemId, it.itemQuantity, OrderItemStatus.PENDING)
                )
            } else {
                itemsNotAvailable = itemsNotAvailable + it.itemId + ", "
            }
        }
        return "Your OrderId is : " + order.orderId!! + " Please Keep it for tracking your order " + itemsNotAvailable
    }

    fun acceptOrder(orderId: Long): String {
        //otrderIrtems  pending /accpeted /rejected column
        var order = orderRepository.findByIdOrNull(orderId)
        if (order == null) {
            return "Invalid Order Id"
        }
        var itemsIdNotInStock = ArrayList<Long>()
        var orderedItems = orderItemRepository.findAllByOrderId(orderId)
        orderedItems.forEach {
            var a = itemRepository.getById(it.itemId)
            if (it.itemQuantity > a.itemquantity) {
                itemsIdNotInStock.add(a.itemId!!)
                it.orderItemStatus = OrderItemStatus.REJECTED
            } else {
                a.itemquantity = a.itemquantity - it.itemQuantity
                it.orderItemStatus = OrderItemStatus.ACCEPTED
            }
        }
        var itemsNotAvailable = "Following Items are not Available : "
        var itemNamesNotInStock = ArrayList<String>()
        for (l in itemsIdNotInStock) {
            var b = itemRepository.getById((l))
            itemsNotAvailable += b.itemName + ", "
        }
        order.orderStatus = OrderStatus.ACCEPTED
        orderRepository.save(order)
        var orderUpdateForUser = "Your Order has Been ACCEPTED but $itemsNotAvailable"
        return orderUpdateForUser;
    }

    fun getAllByOrderStatus(orderStatus: OrderStatus): List<Order> {
        return orderRepository.getAllByOrderStatus(orderStatus)
    }
    fun orderStatusCheck(orderId: Long,orderStatusRequired:List<OrderStatus>){
        var order = getOrder(orderId)
        if(order.orderStatus in orderStatusRequired)
            throw RequestException("The Order : $orderId is already processed , Cannot be processed further" )
    }






//JUNIT TESTING
}